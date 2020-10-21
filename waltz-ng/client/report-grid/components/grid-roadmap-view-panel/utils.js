import {pairs} from "d3-array";
import {forceCollide, forceManyBody, forceSimulation, forceY} from "d3-force";


/**
 * Randomly pick an element from the given array
 * @param xs
 * @returns {*}
 */
export function randomPick(xs) {
    if (!xs) {
        throw new Error("Cannot pick from a null set of options");
    }

    const choiceCount = xs.length - 1;
    const idx = Math.round(Math.random() * choiceCount);
    return xs[idx];
}


/**
 * Pick a random date between the two points.
 * @param from
 * @param to
 * @returns {Date}
 */
export function getRandomDate(from, to) {
    const fromTime = from.getTime();
    const toTime = to.getTime();
    return new Date(fromTime + Math.random() * (toTime - fromTime));
}


/**
 * Uses a force simulation to push nodes away from each other
 * on the y axis.  This prevents nodes overlapping and aids
 * in readability.
 *
 * @param scales
 * @param nodeData
 */
function layoutApps(scales, nodeData) {
    const byCategory = _.groupBy(nodeData, d => d.milestone.category.id);

    _.forEach(byCategory, (v, k) => {
        const simulation = forceSimulation(v)
            .force("y", forceY(scales.y(k)))
            .force(
                "collide",
                forceCollide()
                    .radius(d => scales.nodeSize(d.app.size) * 2 + 6))
            .force("manyBody", forceManyBody().strength(-10))
            .stop();

        for (let i = 0; i < 200; ++i) {
            simulation.tick();
        }
    });
}


export function mkNodeData(scales, data = []) {
    const nodeData = _
        .flatMap(
            data,
            d => _.map(
                d.milestones,
                m => ({app: d.app, milestone: m})))
    layoutApps(scales, nodeData);
    return nodeData;
}


export function mkArcData(data = []) {
    return _
        .chain(data)
        .groupBy(d => d.app.id)
        .flatMap(d => pairs(
            _.orderBy(d, m => m.milestone.date),
            (m1, m2) => ({
                id: `${m1.milestone.id}_${m2.milestone.id}`,
                app: m1.app,
                m1: m1.milestone,
                m2: m2.milestone,
                y1: m1.y,
                y2: m2.y
            })))
        .filter()
        .value();
}


/**
 * @param x1
 * @param y1
 * @param x2
 * @param y2
 * @param flatness (higher = flatter, defaults to 3)
 * @returns {string}
 */
export function mkCurvedLine(x1, y1, x2, y2, flatness = 3) {
    const dx = x2 - x1;
    const dy = y2 - y1;
    const dr = Math.sqrt(dx * dx + dy * dy);

    return `M${x2} ${y2}
            A${dr * flatness},${dr * flatness} 0 0,1 ${x1},${y1}`;
}
