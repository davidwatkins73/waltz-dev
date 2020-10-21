import {mkName} from "./names";
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


export const categories = {
    liftAndShift: {
        id: ctr++,
        name: "Lift & Shift",
        position: 10
    },
    // tweak: {
    //     id: ctr++,
    //     name: "Tweak",
    //     position: 15
    // },
    easyRefactor: {
        id: ctr++,
        name: "Refactor",
        position: 20
    },
    // rework: {
    //     id: ctr++,
    //     name: "Rework",
    //     position: 25
    // },
    hardRefactor: {
        id: ctr++,
        name: "Hard Refactor",
        position: 30
    },
    replatform: {
        id: ctr++,
        name: "Replatform",
        position: 40
    },
    // repurchase: {
    //     id: ctr++,
    //     name: "Repurchase",
    //     position: 50
    // },
    // retire: {
    //     id: ctr++,
    //     name: "Retire",
    //     position: 60
    // },
};


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
    () => [ mkMilestone(categories.liftAndShift, phases.p1) ],
    () => [ mkMilestone(categories.liftAndShift, phases.p1), mkMilestone(categories.easyRefactor, phases.p2), mkMilestone(categories.replatform, phases.p3)],
    () => [ mkMilestone(categories.liftAndShift, phases.p1), mkMilestone(categories.easyRefactor, phases.p2), mkMilestone(categories.replatform, phases.p3)],
    () => [ mkMilestone(categories.liftAndShift, phases.p1), mkMilestone(categories.easyRefactor, phases.p2), mkMilestone(categories.replatform, phases.p3)],
    () => [ mkMilestone(categories.liftAndShift, phases.p1) ],
    () => [ mkMilestone(categories.liftAndShift, phases.p2) ],
    () => [ mkMilestone(categories.liftAndShift, phases.p2) ],
    () => [ mkMilestone(categories.liftAndShift, phases.p1), mkMilestone(categories.hardRefactor, phases.p2) ],
    () => [ mkMilestone(categories.liftAndShift, phases.p1), mkMilestone(categories.replatform, phases.p3) ],
    () => [ mkMilestone(categories.easyRefactor, phases.p2), mkMilestone(categories.replatform, phases.p3) ],
    () => [ mkMilestone(categories.easyRefactor, phases.p1) ],
    () => [ mkMilestone(categories.easyRefactor, phases.p1) ],
    () => [ mkMilestone(categories.easyRefactor, phases.p2) ],
    () => [ mkMilestone(categories.easyRefactor, phases.p2) ],
    () => [ mkMilestone(categories.easyRefactor, phases.p3) ],
    () => [ mkMilestone(categories.hardRefactor, phases.p1) ],
    // () => [ mkMilestone(categories.tweak, phases.p1) ],
    // () => [ mkMilestone(categories.tweak, phases.p2) ],
    // () => [ mkMilestone(categories.rework, phases.p1) ],
    // () => [ mkMilestone(categories.rework, phases.p2) ],
    () => [ mkMilestone(categories.hardRefactor, phases.p2) ],
    () => [ mkMilestone(categories.hardRefactor, phases.p3) ],
    () => [ mkMilestone(categories.hardRefactor, phases.p3) ],
    // () => [ mkMilestone(categories.repurchase, phases.p2) ],
    // () => [ mkMilestone(categories.repurchase, phases.p3) ],
    () => [ mkMilestone(categories.replatform, phases.p2) ],
    () => [ mkMilestone(categories.replatform, phases.p3) ],
    () => [ mkMilestone(categories.replatform, phases.p3) ],
    // () => [ mkMilestone(categories.retire, phases.p1) ]
];


export function mkData(apps = []) {
    return _.map(apps, app => ({
        app: Object.assign(app, { size: Math.ceil(Math.random() * 12) }),
        milestones: randomPick(examplePaths)()
    }));
}
