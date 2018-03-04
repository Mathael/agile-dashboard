import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {catchError} from 'rxjs/operators';
import {HttpUtil} from '../util/HttpUtil';
import {Observable} from 'rxjs/Rx';
import {Project} from '../model/Project';
import {LazyProject} from '../model/lazy/LazyProject';

@Injectable()
export class ProjectService {

    private baseUrl = environment.apiHost+'/project';
    private headers = new HttpHeaders({'Content-Type': 'application/json', 'Accept' : 'application/json'});

    constructor(private http: HttpClient) {}

    findAll(): Observable<LazyProject[]> {
        return this
            .http
            .get(`${this.baseUrl}`, { headers: this.headers })
            .pipe(catchError(HttpUtil.handleError));
    }

    find(id:number): Observable<Project> {
        return this
            .http
            .get(`${this.baseUrl}/${id}`, { headers: this.headers })
            .pipe(catchError(HttpUtil.handleError));
    }
}
