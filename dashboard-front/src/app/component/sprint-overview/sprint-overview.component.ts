import {Component, Input, OnInit} from '@angular/core';
import {Sprint} from '../../model/Sprint';

@Component({
    selector: 'app-sprint-overview',
    templateUrl: './sprint-overview.component.html',
    styleUrls: ['./sprint-overview.component.css']
})
export class SprintOverviewComponent implements OnInit {

    @Input()
    private sprint: Sprint;

    constructor() {}

    ngOnInit() {}

}
