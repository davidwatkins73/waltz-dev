import {cmp} from "./sort-utils";
import EntityLink from "../../common/svelte/EntityLink.svelte";


export function mkSortFn(sortCol, sortAsc = true) {
    return (a, b) => {
        const result = sortCol.sortFn
            ? sortCol.sortFn(a, b)
            : cmp(a[sortCol.field], b[sortCol.field])

        return sortAsc ? result : -result;
    }
}


export function mkEntityLinkFormatter(valueProvider) {
    return (row, cell, value, colDef, dataCtx) => {
        const me = document.createElement("span");
        const component = new EntityLink({target: me});

        const ref = valueProvider
            ? valueProvider(value, dataCtx)
            : value;

        component.$set({ref});
        return me;
    }
}