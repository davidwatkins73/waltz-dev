/*
 * Waltz - Enterprise Architecture
 * Copyright (C) 2016, 2017 Waltz open source project
 * See README.md for more information
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import {CORE_API} from "../../common/services/core-api-utils";
import {nest} from "d3-collection";
import * as _ from "lodash";

export function service(serviceBroker) {

    const loadPromise = serviceBroker
        .loadAppData(CORE_API.ConstraintsStore.findStringConstraints)
        .then(r => r.data);

    const indexPromise = loadPromise
        .then(xs => nest()
                .key(d => _.camelCase(d.objectName))
                .key(d => _.camelCase(d.fieldName))
                .rollup(ds => ds[0].length)
                .object(xs));

    const lookupFieldLength = (objName, fieldName, dflt = 8) => {
        return indexPromise
            .then(m => {
                const length = _.get(m, [objName, fieldName], null)
                if (length == null) {
                    console.warn("ConstraintsService:lookupFieldLength cannot find entry for ", objName, fieldName)
                    return dflt;
                } else {
                    return length;
                }
            });
    };

    return {
        lookupFieldLength
    };
};


service.$inject = [
    'ServiceBroker'
];


export const serviceName = 'ConstraintsService';

