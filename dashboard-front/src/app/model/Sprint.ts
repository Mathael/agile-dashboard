import {Ticket} from './Ticket';

export class Sprint {
    public id:number;
    public label:string;
    public description:string;
    public tickets:Ticket[];
}
