import {event, mouse, select} from "d3-selection";
import {scaleBand, scaleLinear, scaleOrdinal, scaleTime, schemeCategory20c} from "d3-scale";
import {extent} from "d3-array";
import {axisBottom, axisLeft} from "d3-axis";
import {timeFormat} from "d3-time-format";
import {easeCubic, easeLinear} from "d3-ease";
import {transition} from "d3-transition";
import {mkArcData, mkCurvedLine, mkNodeData} from "./utils";
import {symbol, symbolCross} from "d3-shape";

// viz
const ANIMATION_DURATION = 200;
const MAX_NODE_SIZE = 10;
const MIN_NODE_SIZE = 2;


const margins = {
    top: 30,
    left: 80,
    right: 10,
    bottom: 50
};


const dimensions = {
    w: 1000,
    h: 800
};


const colors = {
    arc: {
        highlight: "#d65050",
        normal: "#eee"
    }
};


const classes = {
    nodeGlyph: "nodeGlyph",
    removalGlyph: "removalGlyph",
    nodes: "nodes",
    node: "node",
    arcs: "arcs",
    arc: "arc"
};


function showTooltip(tooltip, d, x, y) {
    tooltip
        .html(`
            <b>${d.app.name}</b>
            <p>
                ${d.milestone.category.name}
                -
                ${timeFormat("%-m/%-d/%Y")(d.milestone.date)}
            </p>
        `)
        .style("left", `${x}px`)
        .style("top", `${y}px`)
        .transition(transition()
            .ease(easeLinear)
            .duration(ANIMATION_DURATION))
        .style("opacity", 1);
}


function hideTooltip(tooltip) {
    tooltip
        .transition(transition()
            .ease(easeLinear)
            .duration(ANIMATION_DURATION))
        .style("opacity", 0);
}


function drawNodeRemovalGlyph(allNodes) {
    const crossPath = symbol().type(symbolCross).size(100);

    const crosses = allNodes
        .selectAll(`path.${classes.removalGlyph}`)
        .data(x => _.get(x, ["dynProps", "isRemoved"], false) ? [x.index] : [], d => d);

    const newCrosses = crosses
        .enter()
        .append("path")
        .classed(classes.removalGlyph, true)
        .style("transform", "rotate(0deg) scale(0)")
        .attr("d", crossPath)
        .attr("stroke", "white")
        .attr("fill", "red")
        .attr("opacity", 0.9)
        .transition(transition()
            .ease(easeCubic)
            .duration(ANIMATION_DURATION * 2))
        .style("transform", "rotate(45deg) scale(1.5)");

    crosses
        .exit()
        .transition(transition()
            .ease(easeCubic)
            .duration(ANIMATION_DURATION * 2))
        .style("transform", "rotate(0deg) scale(0)")
        .remove();
}


function drawNodes(scales,
                   containers,
                   nodeData = [],
                   allArcs) {
    const nodes = containers.nodes
        .selectAll(`g.${classes.node}`)
        .data(nodeData, d => `${d.app.id}_${d.milestone.id}`);

    const newNodes = nodes
        .enter()
        .append("g")
        .classed(classes.node, true)
        .attr("pointer-events", "bounding-box");

    newNodes
        .append("circle")
        .classed(classes.nodeGlyph, true)
        .attr("fill", d => scales.color(d.app.id))
        .attr("r", 1)
        .attr("stroke", d => scales.color(d.app.id));


    nodes.exit()
        .select(`circle.${classes.nodeGlyph}`)
        .transition(transition()
            .ease(easeLinear)
            .duration(ANIMATION_DURATION))
        .attr("r", 0);

    nodes.exit()
        .select(`path.${classes.removalGlyph}`)
        .transition(transition()
            .ease(easeLinear)
            .duration(ANIMATION_DURATION))
        .attr("opacity", 0);

    nodes.exit()
        .transition()
        .delay(ANIMATION_DURATION)
        .remove();

    const allNodes = nodes
        .merge(newNodes)
        .attr("transform", d => `translate(${scales.x(d.milestone.date)}, ${d.y + scales.y.bandwidth() / 2})`)

    allNodes
        .call(setupInteractivity, allArcs, containers)
        .select(`circle.${classes.nodeGlyph}`)
        .transition(transition()
            .ease(easeLinear)
            .duration(ANIMATION_DURATION))
        .attr("r", d => scales.nodeSize(d.app.size));

    drawNodeRemovalGlyph(allNodes);

    return allNodes;
}


function drawArcs(scales,
                  containers,
                  arcData = []) {
    const arcs = containers.arcs
        .selectAll("path.arc")
        .data(arcData, d => d.id);

    const newArcs = arcs
        .enter()
        .append("path")
        .classed(classes.arc, true)
        .attr("fill", "none")
        .attr("stroke", colors.arc.normal);

    arcs.exit()
        .transition(transition()
            .ease(easeLinear)
            .duration(ANIMATION_DURATION))
        .style("opacity", 0)
        .remove();

    return arcs
        .merge(newArcs)
        .attr("d", d => mkCurvedLine(
            scales.x(d.m1.date),
            d.y1 + scales.y.bandwidth() / 2,
            scales.x(d.m2.date),
            d.y2 + scales.y.bandwidth() / 2,
            2
        ))
        .attr("opacity", 1);
}


function setupContainers(elemSelector = "#viz") {
    const svg = select(elemSelector)
        .append("svg")
        .attr("width", dimensions.w)
        .attr("height", dimensions.h);

    const graph = svg
        .append("g")
        .attr("transform", `translate(${margins.left}, ${margins.top})`);

    const arcs = graph
        .append("g")
        .classed(classes.arcs, true);

    const nodes = graph
        .append("g")
        .classed(classes.nodes, true);

    const tooltip = select(elemSelector)
        .append("div")
        .style("font-size", "x-small")
        .style("opacity", 0)
        .style("position", "absolute")
        .style("background-color", "white")
        .style("border", "solid")
        .style("border-color", "#aaa")
        .style("border-width", "1px")
        .style("border-radius", "3px")
        .style("padding", "5px")
        .style("pointer-events", "none");  // stops the popover intercepting other mouseovers

    return {
        svg,
        arcs,
        nodes,
        tooltip
    };
}


function mkScaleY(categories = []) {
    const orderedCategories = _
        .chain(categories)
        .orderBy(d => d.position * -1)
        .value();

    return scaleBand()
        .domain(_.map(
            orderedCategories,
            d => d.id))
        .range([0, dimensions.h - (margins.top + margins.bottom)]);
}


function mkScaleX(data) {
    const dateExtent = extent(_.flatMap(
        data,
        d => _.map(d.milestones, m => m.date)));

    return scaleTime()
        .domain(dateExtent)
        .range([0, dimensions.w - (margins.left + margins.right)])
        .nice();
}


function mkScaleNodeSize(data) {
    const sizeExtent = extent(
        data,
        d => d.app.size);

    return scaleLinear()
        .domain(sizeExtent)
        .range([MIN_NODE_SIZE, MAX_NODE_SIZE]);
}


function mkScales(rawData,
                  categories) {
    return {
        x: mkScaleX(rawData),
        y: mkScaleY(categories),
        nodeSize: mkScaleNodeSize(rawData),
        color: scaleOrdinal(schemeCategory20c)
    };
}


function drawAxes(scales,
                  svg,
                  categories) {
    const categoriesById = _.keyBy(
        categories,
        d => d.id);

    svg.append("g")
        .attr("transform", `translate(${margins.left} ${dimensions.h - (margins.bottom)})`)
        .call(axisBottom(scales.x)
            .tickFormat(timeFormat("%d %b %Y"))
            .ticks(6));

    svg.append("g")
        .attr("transform", `translate(${margins.left} ${margins.top})`)
        .call(axisLeft(scales.y)
            .tickFormat(d => categoriesById[d].name));
}


function prepareData(scales, rawData, categories) {
    const nodeData = mkNodeData(scales, rawData);
    const arcData = mkArcData(nodeData);
    return {
        rawData,
        nodeData,
        arcData,
        categories
    };
}


function highlightNodes(allApps, allArcs, node) {
    allApps
        .transition(transition()
            .ease(easeLinear)
            .duration(ANIMATION_DURATION))
        .style("opacity", x => (x.app.id === node.app.id) ? 1 : 0.2)
        .attr("stroke-width", x => (x.app.id === node.app.id) ? 2 : 1);

    allArcs
        .transition(transition()
            .ease(easeLinear)
            .duration(ANIMATION_DURATION))
        .style("opacity", x => x.app.id === node.app.id ? 1 : 0.2)
        .attr("stroke", x => x.app.id === node.app.id ? colors.arc.highlight : colors.arc.normal)
        .attr("stroke-width", x => x.app.id === node.app.id ? 2 : 1);
}


function removeHighlights(allApps, allArcs) {
    allApps
        .transition(transition()
            .ease(easeLinear)
            .duration(ANIMATION_DURATION))
        .style("opacity", 1)
        .attr("stroke-width", 1);
    allArcs
        .transition(transition()
            .ease(easeLinear)
            .duration(ANIMATION_DURATION))
        .style("opacity", 1)
        .attr("stroke", colors.arc.normal)
        .attr("stroke-width", 1);
}


function setupInteractivity(allApps, allArcs, containers) {
    allApps
        .on("mouseover.node.debug", (d) => console.log(
            d.app.name,
            d))
        .on("mouseover.node.highlight", (d) => highlightNodes(allApps, allArcs, d))
        .on("mouseleave.node.removeHighlight", () => removeHighlights(allApps, allArcs))
        .on("mouseover.node.popover", (d) => showTooltip(containers.tooltip, d, event.pageX + 20, event.pageY - 20))
        .on("mouseleave.node.popover", () => hideTooltip(containers.tooltip));
}


export function draw(elemSelector,
                     rawData = [],
                     categories = []) {
    const scales = mkScales(rawData, categories);
    const containers = setupContainers(elemSelector);

    const data = prepareData(scales, rawData, categories);

    drawAxes(scales, containers.svg, categories);

    const redraw = (filterFn = () => true,
                    dynPropProviderFn = d => {}) => {
        const arcData = _
            .chain(data.arcData)
            .filter(filterFn)
            .map(d => Object.assign({}, d, { dynProps: dynPropProviderFn(d) }))
            .value();

        const nodeData = _
            .chain(data.nodeData)
            .filter(filterFn)
            .map(d => Object.assign({}, d, { dynProps: dynPropProviderFn(d) }))
            .value();

        const allArcs = drawArcs(scales, containers, arcData);
        const allNodes = drawNodes(scales, containers, nodeData, allArcs);

        return {
            allNodesSelection: allNodes,
            allArcsSelection: allArcs
        };
    };

    redraw();

    return redraw;
}
