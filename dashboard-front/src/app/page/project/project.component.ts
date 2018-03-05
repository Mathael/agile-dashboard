import {Component, OnInit} from '@angular/core';
import {ProjectService} from '../../service/project.service';
import {Project} from '../../model/Project';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {ProjectMock} from '../../mock/ProjectMock';

@Component({
    selector: 'app-project',
    templateUrl: './project.component.html',
    styleUrls: ['./project.component.css'],
    providers: [ProjectService]
})
export class ProjectComponent implements OnInit {

    private project: Project;

    constructor(private projectService: ProjectService, private route: ActivatedRoute) {}

    ngOnInit() {
        let failure = ProjectMock.getData()[1];
        this.route.paramMap.subscribe((params:ParamMap) => {
            let id = parseInt(params.get('id'));
            this.projectService
                .find(id)
                .subscribe(
                    next => this.project = next,
                    error => this.project = failure
                );
        });
    }
}
