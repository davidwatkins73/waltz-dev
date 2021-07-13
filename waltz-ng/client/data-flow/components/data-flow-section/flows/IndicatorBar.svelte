<script>
    import _ from "lodash";
    import {scaleLinear, scaleOrdinal} from "d3-scale";
    import {stack} from "d3-shape";

    export let width = 10;
    export let height = 100;
    export let data = {};

    const color = scaleOrdinal()
        .domain(["DISCOURAGED", "SECONDARY", "PRIMARY", "NO_OPINION"])
        .range(["#e79d9d", "#e7d49a", "#a8e29e", "#c1c1c1"]);

    $: stackData = stack()
        .keys(color.domain())
        ([data]);

    $: total = _.sumBy(
        color.domain(),
        k => data[k] || 0);

    $: y = scaleLinear()
        .range([0, height])
        .domain([0, total]);

    $: coords = _
        .chain(stackData)
        .map(d => {
            let sy = d[0][0];
            let ey = d[0][1];
            return {
                y: sy,
                height: ey - sy,
                key: d.key,
                count: d[0].data[d.key]
            };
        })
        .filter(d => d.count)
        .value();

</script>

<g on:click
   on:mouseenter
   on:mouseleave>
    {#each coords as d}
        <rect y={y(d.y)}
              {width}
              height={y(d.height)}
              fill={color(d.key)}/>
        {#if width > 30 && y(d.height) > 26}
            <text dy={y(d.y) + (y(d.height) / 2 + 8)}
                  text-anchor="middle"
                  dx={width/2}
                  style="font-size: 20px">
                {d.count}
            </text>
        {/if}
    {/each}
</g>

<style>
    text {
        fill: #596d4e
    }
</style>
