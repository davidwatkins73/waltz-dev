import _ from "lodash";

export function calcOnlyUsedDomainItems(domainItems, inData, outData) {
    const usedDomainIds = _
        .chain(inData.values)
        .concat(outData.values)
        .map(d => d.k)
        .uniq()
        .value();

    return _.filter(
        domainItems,
        d => _.includes(usedDomainIds, d.id));
}


export function peek(msg, data) {
    console.log(`[Peek] ${msg}: `, data);
    return data;
}
