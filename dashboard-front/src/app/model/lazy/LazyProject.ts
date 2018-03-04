export class LazyProject {
    public id:number;
    public label:string;
    public description:string;
    public backlogCount:number;
    public sprintCount:number;


   constructor(id: number, label: string, description: string, backlogCount: number, sprintCount: number) {
        this.id = id;
        this.label = label;
        this.description = description;
        this.backlogCount = backlogCount;
        this.sprintCount = sprintCount;
    }
}
