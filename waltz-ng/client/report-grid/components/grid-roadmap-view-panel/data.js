import {getRandomDate, randomPick} from "./utils";

let ctr = 0;


function mkDate(phase) {
    const approx = getRandomDate(phase.start, phase.end);
    approx.setDate(approx.getDate() + (5 + 7 - approx.getDay()) % 7);
    approx.setHours(0);
    approx.setMinutes(0);
    approx.setSeconds(0);
    approx.setMilliseconds(0);
    return approx;

}


const phases = {
    p1: {
        start: new Date(2020, 10),
        end: new Date(2021, 3),
    },
    p2: {
        start: new Date(2021, 2),
        end: new Date(2022, 7),
    },
    p3: {
        start: new Date(2021, 7),
        end: new Date(2024, 7),
    }
};



const mkMilestone= (category, phase, name="foo") => ({
    id: ctr++,
    name,
    date: mkDate(phase),
    category
})

const examplePaths = [
    (xs) => [ mkMilestone(randomPick(xs), phases.p1) ],
    (xs) => [ mkMilestone(randomPick(xs), phases.p1) ],
    (xs) => [ mkMilestone(randomPick(xs), phases.p1), mkMilestone(randomPick(xs), phases.p2), mkMilestone(randomPick(xs), phases.p3)],
    (xs) => [ mkMilestone(randomPick(xs), phases.p1), mkMilestone(randomPick(xs), phases.p3)],
    (xs) => [ mkMilestone(randomPick(xs), phases.p1), mkMilestone(randomPick(xs), phases.p3)],
    (xs) => [ mkMilestone(randomPick(xs), phases.p2), mkMilestone(randomPick(xs), phases.p3)],
    (xs) => [ mkMilestone(randomPick(xs), phases.p1), mkMilestone(randomPick(xs), phases.p2)],
    (xs) => [ mkMilestone(randomPick(xs), phases.p2)],
    (xs) => [ mkMilestone(randomPick(xs), phases.p2)],
    (xs) => [ mkMilestone(randomPick(xs), phases.p3)],
];


export function mkData(apps = [], categories = []) {
    return _.map(apps, app => ({
        app: Object.assign(app, { size: Math.ceil(Math.random() * 12) }),
        milestones: randomPick(examplePaths)(categories)
    }));
}
