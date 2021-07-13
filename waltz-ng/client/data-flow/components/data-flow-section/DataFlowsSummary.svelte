<script>
    import Flows from "./flows/Flows.svelte";
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

    $: data = {
        sources,
        targets,
        domain: dataTypes,
        inbound: {flows: inFlows, facet: inFacet},
        outbound: {flows: outFlows, facet: outFacet},
    };

</script>

<div class="row">
    <div class="col-sm-6">
        <div class="help-block">
            This is an experimental view for showing data flows with a focus on movement of data classes rather
            than showing individual applications.  You can drill-down into data types (indicated by a + after the
            data type name) or click on the arcs to see contextual information.
        </div>

        <Flows {data}/>
    </div>
    <div class="col-sm-6">
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
