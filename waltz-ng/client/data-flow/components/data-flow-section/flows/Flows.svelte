<script>
    import _ from "lodash";
    import {stratify} from "d3-hierarchy";

    import Defs from "./Defs.svelte";
    import IndicatorBar from "./IndicatorBar.svelte";
    import DomainBar from "./DomainBar.svelte";
    import Breadcrumbs from "./Breadcrumbs.svelte";

    import {activeSelection, history, activeRoot, drillIn, showBreadcrumbs} from "./stores/options";

    import {hierarchyStack} from "./hierarchyStack";
    import {flowLayout} from "./flowLayout";
    import {arc, mkArcs} from "./arcs";
    import {calcOnlyUsedDomainItems} from "./flow-utils";
    import {onMount} from "svelte";

    export let data;

    const hierStackFn = hierarchyStack().valueId(d => d.dataTypeId);

    function mkIndicatorData(data) {
        return _
            .chain(data.values)
            .countBy(d => d.rating)
            .value()
    }

    let el;

    // overall dimensions of the chart
    let width = 900;
    let height = 700;

    // these control the ui layout
    let indicatorBarWidth = 40;
    let midPaddingOuter = 3.5;
    let midPaddingInner = 0.5;
    let endpointPadding = 12;
    let tension = 0.7;

    let domainTree = null;

    let inArcs = [];
    let outArcs = [];
    let mids = [];

    onMount(() => $history = [])

    $: layoutFn = flowLayout()
        .height(height)
        .midPaddingOuter(midPaddingOuter)
        .midPaddingInner(midPaddingInner)
        .endpointPadding(endpointPadding);

    $: arcFn = arc()
        .width(width / 3 - indicatorBarWidth)
        .tension(tension);

    $: {
        const root = {id: -1, name: "Root"};
        const domain = _.map(
            facetDomain,
            d => ({
                ...d,
                parentId: d.parentId || root.id
            }));

        domainTree = stratify()(_.concat([root], domain));
        activeRoot.set(domainTree);
    }

    $: activeDomainItems = _
        .chain($activeRoot.children)
        .map(d => ({
            ...d,
            rollups: _.map(
                d.descendants(),
                c => c.id)
        }))
        .orderBy(d => d.data.name)
        .value();

    $: flowsById = _
        .chain([])
        .concat(data.inbound.flows, data.outbound.flows)
        .keyBy(d => d.id)
        .value();

    $: inFacet = data.inbound.facet;
    $: outFacet = data.outbound.facet;
    $: facetDomain = data.domain;
    $: inData = hierStackFn(inFacet, activeDomainItems, "INBOUND");
    $: outData = hierStackFn(outFacet, activeDomainItems, "OUTBOUND");
    $: layoutData = layoutFn(
        inData,
        outData,
        calcOnlyUsedDomainItems(activeDomainItems, inData, outData));

    $: mids = layoutData.mid;
    $: inArcs = mkArcs(layoutData.in, arcFn);
    $: outArcs = mkArcs(layoutData.out, arcFn);

    $: console.log({
        activeSelection: $activeSelection,
        inData,
        outData,
        inFacet,
        outFacet
    });
</script>


<pre>{JSON.stringify($activeSelection?.data.model.data.name, "", 2)}</pre>

<svg viewBox="0 0 {width} {height}"
     width="100%"
     bind:this={el}>
    <Defs/>
    <g transform="translate(0 0)"
       class="inbound">
        {#each inArcs as d}
            <path d={d.path}
                  transform="translate({indicatorBarWidth} 0)"
                  fill="url(#gradient-in)"
                  filter="url(#glow)"
                  on:click={() => {$activeSelection = d}}
                  class="flow in-flow"/>
            <g transform="translate(0 {d.sy})">
                <IndicatorBar height={d.sh}
                              data={mkIndicatorData(d.data)}
                              width={indicatorBarWidth}/>
            </g>
        {/each}
    </g>
    <g transform="translate({width / 3 * 2} 0)"
       class="outbound">
        {#each outArcs as d}
            <path d={d.path}
                  fill="url(#gradient-out)"
                  filter="url(#glow)"
                  on:click={() => {$activeSelection = d}}
                  class="flow out-flow"/>
            <g transform="translate({(width / 3) - indicatorBarWidth} {d.ey})">
                <IndicatorBar height={d.eh}
                              data={mkIndicatorData(d.data)}
                              width={indicatorBarWidth}/>
            </g>
        {/each}
    </g>
    <g transform="translate({width / 2} 0)" class="middle">
        {#each mids as mid}
            <DomainBar item={mid}
                       width={width / 3}
                       x={width/6 * -1}
                       on:click={() => drillIn(mid, $activeRoot)}/>
        {/each}
    </g>
    {#if $showBreadcrumbs}
        <Breadcrumbs/>
    {/if}
</svg>

{#if false}
<h3>Controls</h3>
<table width="100%">
    <colgroup>
        <col width="25%">
        <col width="25%">
        <col width="25%">
        <col width="25%">
    </colgroup>
    <tr>
        <td>
            Mid Band Outer Padding ({midPaddingOuter})
        </td>
        <td>
            <input type="range"
                   min="0"
                   max="10"
                   step="0.05"
                   bind:value={midPaddingOuter}/>
        </td>
        <td>
            Tension ({tension})
        </td>
        <td>
            <input type="range"
                   min="0"
                   max="1"
                   step="0.05"
                   bind:value={tension}/>
        </td>
    </tr>
    <tr>
        <td>
            Mid Band Inner Padding ({midPaddingInner})
        </td>
        <td>
            <input type="range"
                   min="0"
                   max="1"
                   step="0.05"
                   bind:value={midPaddingInner}/>
        </td>
        <td>
            Breadcrumbs ({$showBreadcrumbs})
        </td>
        <td>
            <button class="link"
                    on:click={() => $showBreadcrumbs = !$showBreadcrumbs}>
                Toggle
            </button>
        </td>
    </tr>
    <tr>
        <td>Endpoint Padding ({endpointPadding})</td>
        <td><input type="range" min="0" max="100" bind:value={endpointPadding}/></td>
        <td>Height ({height})</td>
        <td><input type="range" min="0" max="2000" bind:value={height}/></td>
    </tr>
    <tr>
        <td>Indicator Bar Width ({indicatorBarWidth})</td>
        <td><input type="range" min="0" max="100" bind:value={indicatorBarWidth}/></td>

        <td>Width ({width})</td>
        <td><input type="range" min="0" max="2000" bind:value={width}/></td>
    </tr>
</table>
{/if}

<style>
    .flow {
        opacity: 0.4;
    }

    .out-flow {
        stroke: #aaa;
    }

    .in-flow {
        stroke: #aaa;
    }
</style>
