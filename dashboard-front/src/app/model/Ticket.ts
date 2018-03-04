import {LazyUser} from './lazy/LazyUser';

export class Ticket {
    public id: number;
    public label: string;
    public description: string;
    public estimatedTime: string;
    public author: LazyUser;
    public affectedUser: LazyUser;
}
