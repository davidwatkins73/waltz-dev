<script>
    import {SlickGrid, Formatters, SelectionModel} from "slickgrid";
    import {onMount} from "svelte";
    import {cmp, refCmp} from "./sort-utils";
    import {applicationStore} from "../../svelte-stores/application-store";
    import {mkSelectionOptions} from "../../common/selector-utils";
    import {mkRef} from "../../common/entity-utils";
    import {orgUnitStore} from "../../svelte-stores/org-unit-store";
    import EntityLink from "../../common/svelte/EntityLink.svelte";
    import {mkEntityLinkFormatter, mkSortFn} from "./slick-grid-utils";


    let elem = null;

    let appCall = applicationStore.findBySelector(mkSelectionOptions(mkRef('ORG_UNIT', 10), "CHILDREN"));
    let orgUnitCall = orgUnitStore.loadAll();

    let grid;
    let percentCutoff = 100;

    function myPercentFormatter(row, cell, value, colDef, dataCtx) {
        let color = "#aedbff";
        if (value < 25) color = "#fad1d1";
        if (value > 75) color = "#d4fcc4";

        return `<div style="
                        width: ${value}px;
                        display: inline-block;
                        background-color: ${color};
                        border-radius: 3px;">${value} %
                </div>`;
    }

    const columns = [
        {id: "name", name: "Name", field: "name", sortable:  true},
        {id: "kind", name: "Kind", field: "applicationKind", sortable:  true},
        {id: "orgUnit",
            name: "Org Unit",
            field: "organisationalUnitId",
            sortable: true,
            sortFn: (a, b) => refCmp(orgUnitsById[a.organisationalUnitId], orgUnitsById[b.organisationalUnitId]),
            formatter: mkEntityLinkFormatter((v, row) => orgUnitsById[v])
        },
        {id: "%", name: "% Complete", field: "percentComplete", width: 90, formatter: myPercentFormatter },
        {id: "%3", name: "% Complete 2", field: "percentComplete", width: 90, sortable:  true, },
        {id: "%10", name: "% Complete 2", field: "percentComplete", width: 90, sortable: true },
        {id: "start", name: "Start", field: "start"},
        {id: "finish", name: "Finish", field: "finish"},
        {id: "effort-driven", name: "Effort Driven", field: "effortDriven", width: 90, sortable: true }
    ];

    const options = {
        enableCellNavigation: false,
        enableColumnReorder: false
    };

    let origData = [];
    let data = [];
    for (let i = 0; i < 50000; i++) {
        origData[i] = {
            title: "Task " + i,
            duration: "5 days",
            percentComplete: Math.round(Math.random() * 100),
            start: "01/01/2009",
            finish: "08/05/2009",
            effortDriven: (i % 5 === 0)
        };
    }

    //
    onMount(() => {
        const elemId = "#myGrid";
        grid = new SlickGrid(elemId, data, columns, options);
        grid.onSort.subscribe((e, args) => {
            const sortCol = args.sortCol;
            data.sort(mkSortFn(sortCol, args.sortAsc));
            grid.invalidate();
        });

        grid.onSelectedRowsChanged.subscribe((a, b, c) => {
            console.log("src", {a, b, c})
        });



        grid.onClick.subscribe(function(e, args) {
            console.log("oc", {e, args})
            var item = args.item;

            // or dataView.getItem(args.row);
        });


    })

    $: {
        console.log("recalc")
        data  = _
            .chain(apps)
           // .filter(d => d.percentComplete < percentCutoff)
            .value();

        console.log("data", data)
        if (grid) {
            grid.data = data;
            grid.invalidate();
        }
    }

    let apps = [];
    let orgUnitsById = {};
    $: apps = $appCall.data || [];
    $: orgUnitsById = _.keyBy($orgUnitCall.data, d => d.id);
    $: console.log({elem, SlickGrid, apps, orgUnitsById})


</script>


<h1>Hello World</h1>

<label for="percentCutoff">
    % Cutoff
    <input type="range"
           min="0"
           max="100"
           id="percentCutoff"
           bind:value={percentCutoff}>
</label>

<div id="myGrid"
     class="slick-container"
     style="width:100%;height:500px;"
     bind:this={elem}/>


<style type="text/scss">
    @import "slickgrid/dist/styles/css/slick-alpine-theme.css";
    //@import "slickgrid/dist/styles/css/example-demo.css";
</style>