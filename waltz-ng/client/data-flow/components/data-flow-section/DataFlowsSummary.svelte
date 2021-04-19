
<script>
    import Flows from "./flows/Flows.svelte";
    import {mkDataSet} from "./flows/data";

    export let logicalFlows = [];
    export let logicalFlowDecorators = [];

    let data = mkDataSet({sourceCount: 100, targetCount: 250});

    console.log({data, logicalFlows, logicalFlowDecorators})
</script>

<div class="row">
    <div class="col-md-7">
        <Flows {data}/>
    </div>
    <div class="col-md-5">
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