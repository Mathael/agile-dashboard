import {Component, Input, OnInit} from '@angular/core';
import {Ticket} from "../../model/Ticket";

@Component({
    selector: 'app-ticket',
    templateUrl: './ticket.component.html',
    styleUrls: ['./ticket.component.css']
})
export class TicketComponent implements OnInit {

    @Input()
    private ticket: Ticket;

    constructor() {}

    ngOnInit() {}
}
