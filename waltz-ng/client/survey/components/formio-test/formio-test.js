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
import {initialiseData} from "../../../common/index";
import {CORE_API} from "../../../common/services/core-api-utils";
import _ from "lodash";
import moment from "moment";
// import Formio from "formiojs/Formio.js";
import FormioForm from "formiojs/form"
// import FormioBuilder from "formiojs/builders";


import template from "./formio-test.html";
import {Components, Form, Formio} from "formiojs";


const bindings = {
};


const initialState = {
};


function controller($q, serviceBroker) {

    const vm = initialiseData(this, initialState);



    vm.$onInit = () => {

        const comp = [
            {
                type: "textfield",
                key: "firstName",
                label: "First Name",
                placeholder: "Enter your first name.",
                input: true
            },
            {
                type: "textfield",
                key: "lastName",
                label: "Last Name",
                placeholder: "Enter your last name",
                input: true
            },
            {
                type: "button",
                action: "submit",
                label: "Submit",
                theme: "primary"
            }];

        global.comp = comp;
        global.fiof = FormioForm;

        setTimeout(() => {
            const elem = document.getElementById("fio-form");
            const ff = new FormioForm(elem, {components: comp});
            const build = ff.build().then(fb => global.fb = fb);


            global.ff = ff;

            build.on('submit')


        }, 1000);



    }
}


controller.$inject = [
    "$q",
    "ServiceBroker"
];


const component = {
    bindings,
    template,
    controller
};


export default {
    component,
    id: "waltzFormioTest"
};



