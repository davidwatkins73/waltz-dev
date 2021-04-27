
<script>
    import Flows from "./flows/Flows.svelte";
    import {mkDataSet} from "./flows/data";
    import {dataTypeStore} from "../../../svelte-stores/data-type-store";

    export let entityRef;
    export let logicalFlows = [];
    export let logicalFlowDecorators = [];


    function calcFacet(flows, decorators) {
        const decoratorsByFlowId = _.groupBy(decorators, d => d.dataFlowId);
        return _.flatMap(
            flows,
            d => decoratorsByFlowId[d.id]);
    }

    const dataTypesCall = dataTypeStore.findAll();

    const fakeData = mkDataSet({sourceCount: 100, targetCount: 250});

    $: dataTypes = $dataTypesCall.data;

    $: realData = {
        facetDomain: []
    };


    $: inFlows = _
        .chain(logicalFlows)
        .filter(d => d.target.id === entityRef.id)
        .value();

    $: outFlows = _
        .chain(logicalFlows)
        .filter(d => d.source.id === entityRef.id)
        .value();

    $: sources = _
        .chain(inFlows)
        .map(d => d.source)
        .uniqBy(d => d.id)
        .value();

    $: targets = _
        .chain(outFlows)
        .map(d => d.target)
        .uniqBy(d => d.id)
        .value();

    $: inFacet = calcFacet(inFlows, logicalFlowDecorators);
    $: outFacet = calcFacet(outFlows, logicalFlowDecorators);

    $: console.log({fakeData, logicalFlowDecorators, inFlows, outFlows});

    $: data = Object.assign(
        fakeData,
        {
            sources,
            targets,
            domain: dataTypes,
            oldIn: fakeData.inbound,
            oldOut: fakeData.outbound,
            inbound: {flows: inFlows, facet: inFacet},
            outbound: {flows: outFlows, facet: outFacet},
        });
</script>

<div class="row">
    <div class="col-sm-7">
        <Flows {data}/>
    </div>
    <div class="col-sm-5">
        <h1>Detail Here</h1>

        <table class="table table-condensed">
            <thead>
            <tr>
                <th>Name</th>
                <th>Asset Code</th>
                <th>Count</th>
                <th>Desc</th>
            </tr>
            </thead>
        </table>
    </div>
</div>

<pre>{logicalFlows.length}</pre>