/*
 * Waltz - Enterprise Architecture
 * Copyright (C) 2016, 2017, 2018, 2019 Waltz open source project
 * See README.md for more information
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific
 *
 */
import {CORE_API} from "../../../common/services/core-api-utils";
import {initialiseData} from "../../../common";
import _ from "lodash";
import template from "./entity-diagrams-section.html";
import {refToString, toEntityRef} from "../../../common/entity-utils";
import {determineIfCreateAllowed} from "../../../flow-diagram/flow-diagram-utils";
import {displayError} from "../../../common/error-utils";
import {kindToViewState} from "../../../common/link-utils";


const bindings = {
    parentEntityRef: "<"
};


const initialState = {
    selectedDiagram: null,
    visibility: {
        flowDiagramMode: null, // null | VIEW | EDIT
        makeNew: true
    },
};


function combineDiagrams(flowDiagrams = [], svgDiagrams = [], flowActions = []) {

    const convertFlowDiagramFn = d => {
        return {
            id: refToString(d),
            ref: toEntityRef(d),
            type: "Flow",
            name: d.name,
            icon: "random",
            description: d.description,
            actions: flowActions,
            lastUpdatedAt: d.lastUpdatedAt,
            lastUpdatedBy: d.lastUpdatedBy
        };
    };

    const convertSvgDiagramFn = d => {
        return {
            id: `ENTITY_SVG_DIAGRAM/${d.id}`,
            ref: toEntityRef(d, "ENTITY_SVG_DIAGRAM"),
            type: "Generic",
            name: d.name,
            icon: "picture-o",
            description: d.description,
            svg: d.svg
        }
    };

    const normalize = (normalizeFn, diagrams = []) => _.map(diagrams, normalizeFn);

    return _.chain([])
        .concat(normalize(convertFlowDiagramFn, flowDiagrams))
        .concat(normalize(convertSvgDiagramFn, svgDiagrams))
        .orderBy(d => d.name.toLowerCase())
        .value();
}


function selectInitialDiagram(diagrams = [], selectedDiagram) {
    if (selectedDiagram) return selectedDiagram;
    return _.find(diagrams, d => d.type === "Generic");
}


function controller($q,
                    $state,
                    serviceBroker,
                    notification) {
    const vm = initialiseData(this, initialState);

    const loadFlowDiagrams = (force = true) => serviceBroker
        .loadViewData(
            CORE_API.FlowDiagramStore.findByEntityReference,
            [ vm.parentEntityRef ],
            { force })
        .then(r => r.data);

    const loadEntitySvgDiagrams = (force = false) => serviceBroker
        .loadViewData(
            CORE_API.EntitySvgDiagramStore.findByEntityReference,
            [ vm.parentEntityRef ],
            { force  })
        .then(r => r.data);

    const flowActions = [
        {
            name: "Clone",
            icon: "clone",
            execute: (diagram) => {
                const newName = prompt("What shall the cloned copy be called ?", `Copy of ${diagram.name}`);
                if (newName == null) {
                    notification.warning("Clone cancelled");
                    return;
                }
                if (_.isEmpty(newName.trim())) {
                    notification.warning("Clone cancelled, no name given");
                    return;
                }
                serviceBroker
                    .execute(CORE_API.FlowDiagramStore.clone, [diagram.ref.id, newName])
                    .then(() => {
                        notification.success("Diagram cloned");
                        reload();
                    })
                    .catch(e => displayError(notification, "Failed to clone diagram", e));

            }}
    ];

    function reload() {
        const promises = [
            loadFlowDiagrams(true),
            loadEntitySvgDiagrams(false)
        ];
        return $q
            .all(promises)
            .then(([flowDiagrams = [], svgDiagrams = []]) => {
                vm.diagrams = combineDiagrams(flowDiagrams, svgDiagrams, flowActions);
                vm.selectedDiagram = selectInitialDiagram(vm.diagrams, vm.selectedDiagram);
                return vm.diagrams;
            });
    }

    vm.$onInit = () => {
        reload();
        vm.visibility.makeNew = determineIfCreateAllowed(vm.parentEntityRef.kind);
    };

    vm.$onChanges = (changes) => {
    };

    vm.onDiagramSelect = (diagram) => {
        vm.selectedDiagram = diagram;
        vm.visibility.flowDiagramMode = "VIEW";

        if(diagram.type === 'Flow'){
            $state.go(kindToViewState("FLOW_DIAGRAM"), {id: diagram.ref.id});
        }
    };

    vm.onDiagramDismiss = () => {
        vm.selectedDiagram = null;
    };

    vm.onEditorClose = () => {
        vm.selectedDiagram = null;
        reload();
    };

    vm.onDiagramEdit = () => {
        vm.visibility.flowDiagramMode = "EDIT";
    };

    vm.onMakeNewFlowDiagram = () => {
        const name = prompt("Please enter a name for the new diagram ?");
        if (name == null) {
            notification.warning("Create cancelled");
            return;
        }
        if (_.isEmpty(name.trim())) {
            notification.warning("Create cancelled, no name given");
            return;
        }

        let newDiagramId = null;
        serviceBroker
            .execute(CORE_API.FlowDiagramStore.makeNewForEntityReference, [vm.parentEntityRef, name])
            .then(r => {
                reload();
                return r.data;
            })
            .then(diagramId => {
                notification.success("Diagram created, click edit if you wish to make changes");
                $state.go(kindToViewState("FLOW_DIAGRAM"), {id: diagramId});
            })
            .catch(e => displayError(notification, "Failed to create new diagram", e));
    };
}


controller.$inject = [
    "$q",
    "$state",
    "ServiceBroker",
    "Notification"
];


const component = {
    template,
    bindings,
    controller
};


export default {
    component,
    id: "waltzEntityDiagramsSection"
};
