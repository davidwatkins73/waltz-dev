import template from "./grid-roadmap-view-panel.html";
import {initialiseData} from "../../../common";
import {mkData} from "./data";
import {draw} from "./viz";
import {CORE_API} from "../../../common/services/core-api-utils";
import {mkSelectionOptions} from "../../../common/selector-utils";


const bindings = {
    parentEntityRef: "<"
};

const initData = {



};

const fakeConfig = {
    categoryRatingSchemeId: 8,
    milestoneAssessmentIds: [11, 12] // these better use the rating scheme above!
};


function controller($q, serviceBroker) {
    const vm = initialiseData(this, initData);

    let redrawFn =() => {};  // set once we call draw

    let filterFn = () => true;
    let dynPropFn = () => {};

    function redraw() {
        redrawFn(filterFn, dynPropFn);
    }

    vm.$onChanges = () => {

        const appPromise = serviceBroker
            .loadViewData(
                CORE_API.ApplicationStore.findBySelector,
                [ mkSelectionOptions(vm.parentEntityRef) ])
            .then(r => r.data);

        const categoriesPromise = serviceBroker
            .loadViewData(
                CORE_API.RatingSchemeStore.getById,
                [fakeConfig.categoryRatingSchemeId])
            .then(r => r.data.ratings);

        $q.all([appPromise, categoriesPromise])
            .then(([apps, categories]) => {
                redrawFn = draw("#viz", mkData(apps), categories);
            });

        global.vm = vm;
    };


    document.getElementById("y2022").onclick = () => {
        filterFn = d => d.app.size > 6;
        redraw();
    };

    document.getElementById("y2024").onclick = () => {
        filterFn = d => d.app.size > 9;
        redraw();
    };

    document.getElementById("y2020").onclick = () => {
        filterFn = () => true;
        redraw();
    };

    document.getElementById("kill").onclick = () => {
        dynPropFn = d => ({isRemoved: d.app.name.startsWith("p")});
        redraw();
    };

    document.getElementById("clear").onclick = () => {
        dynPropFn = d => ({});
        redraw();
    };


}


controller.$inject = ["$q", "ServiceBroker"];


const component = {
    controller,
    template,
    bindings
}


export default {
    id: "waltzGridRoadmapViewPanel",
    component
};