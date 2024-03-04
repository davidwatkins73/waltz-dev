import {writable} from "svelte/store";
import pageInfo from "./page-navigation-store";


export const pageReference = writable(null);
export const pageFilters = writable(null);
export const user = writable(null);
export const permissions = writable(null);

pageReference.subscribe(d => console.log("Page Ref", d));
pageFilters.subscribe(d => console.log("Page Filters", d));
user.subscribe(d => console.log("User", d));
permissions.subscribe(d => console.log("Permissions", d));
pageInfo.subscribe(d => console.log("Page Info", d));
