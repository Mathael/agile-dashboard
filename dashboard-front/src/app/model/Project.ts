export class Project {
    public id:number;
    public label:string;
    public description:string;
    public backlog:any[];
    public sprints:any[];
    public ticketSeverities:any[];
    public userGroups:any[];


    constructor(id: number, label: string, description: string, backlog: any[], sprints: any[], ticketSeverities: any[], userGroups: any[]) {
        this.id = id;
        this.label = label;
        this.description = description;
        this.backlog = backlog;
        this.sprints = sprints;
        this.ticketSeverities = ticketSeverities;
        this.userGroups = userGroups;
    }
}
