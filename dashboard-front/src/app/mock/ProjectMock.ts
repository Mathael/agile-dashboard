import {Project} from "../model/Project";

export class ProjectMock {

    static getData() : Project[] {
        return [
            new Project(1, 'Angular 5 POC', 'Establishing a POC of angular concept applyed to a realworld project for a realworld deploy', [], [], [], []),
            new Project(2, 'Spring', 'Establishing a POC of angular concept applyed to a realworld project for a realworld deploy', [], [{id: 100, label: 'impl authentication', description: null, estimatedTime: 6}, {id: 101, label: 'impl bean validation', description: null, estimatedTime: 16}], [], []),
            new Project(3, 'Spring Security', 'Establishing a POC of angular concept applyed to a realworld project for a realworld deploy', [], [], [], []),
            new Project(4, 'Spring OAuth2', 'Establishing a POC of angular concept applyed to a realworld project for a realworld deploy', [], [], [], []),
            new Project(5, 'Spring Cache', 'Establishing a POC of angular concept applyed to a realworld project for a realworld deploy', [], [], [], []),
            new Project(6, 'Spring Shell', 'Establishing a POC of angular concept applyed to a realworld project for a realworld deploy', [], [], [], []),
            new Project(7, 'Spring Data JPA', 'Establishing a POC of angular concept applyed to a realworld project for a realworld deploy', [], [], [], []),
            new Project(8, 'Spring ', 'Establishing a POC of angular concept applyed to a realworld project for a realworld deploy', [], [], [], []),
            new Project(9, 'Angular 5 POC', 'Establishing a POC of angular concept applyed to a realworld project for a realworld deploy', [], [], [], []),
            new Project(10, 'Angular 5 POC', 'Establishing a POC of angular concept applyed to a realworld project for a realworld deploy', [], [], [], []),
            new Project(11, 'Angular 5 POC', 'Establishing a POC of angular concept applyed to a realworld project for a realworld deploy', [], [], [], []),
            new Project(12, 'Angular 5 POC', 'Establishing a POC of angular concept applyed to a realworld project for a realworld deploy', [], [], [], []),
            new Project(13, 'Angular 5 POC', 'Establishing a POC of angular concept applyed to a realworld project for a realworld deploy', [], [], [], []),
            new Project(14, 'Angular 5 POC', 'Establishing a POC of angular concept applyed to a realworld project for a realworld deploy', [], [], [], []),
        ]
    }
}
