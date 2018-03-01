import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import {environment} from '../../environments/environment';
import {catchError} from 'rxjs/operators';
import {HttpUtil} from '../util/HttpUtil';

@Injectable()
export class AuthenticationService {
    private authUrl = environment.apiHost+'/auth';
    private headers = new HttpHeaders({'Content-Type': 'application/json', 'Accept' : 'application/json'});

    constructor(private http: HttpClient) {}

    login(username: string, password: string): Observable<boolean> {
        return this
            .http
            .post(`${this.authUrl}/login`, JSON.stringify({username: username, password: password}), { headers: this.headers })
            .map((response: HttpResponse<any>) => {
                // login successful if there's a jwt token in the response
                let token = response.body.json() && response.body.json().token;
                if (token) {
                    // store username and jwt token in local storage to keep user logged in between page refreshes
                    localStorage.setItem('authentication_user', JSON.stringify({ username: username, token: token }));

                    // return true to indicate successful login
                    return true;
                } else {
                    // return false to indicate failed login
                    return false;
                }
            })
            .pipe(catchError(HttpUtil.handleError));
    }

    signup(username: string, password: string): Observable<boolean> {
        return this
            .http
            .post(`${this.authUrl}/signup`, JSON.stringify({username: username, password: password}), { headers: this.headers })
            .map((response: HttpResponse<any>) => {
                // login successful if there's a jwt token in the response
                let token = response.body.json() && response.body.json().token;
                if (token) {
                    // store username and jwt token in local storage to keep user logged in between page refreshes
                    localStorage.setItem('authentication_user', JSON.stringify({ username: username, token: token }));

                    // return true to indicate successful signup + login
                    return true;
                } else {
                    // return false to indicate that registration has failed
                    return false;
                }
            })
            .pipe(catchError(HttpUtil.handleError));
    }

    getToken(): string {
        let currentUser = JSON.parse(localStorage.getItem('authentication_user'));
        let token = currentUser && currentUser.token;
        return token ? token : '';
    }

    logout(): void {
        // clear token remove user from local storage to log user out
        localStorage.removeItem('authentication_user');
    }

    isLoggedIn(): boolean {
        let token: string = this.getToken();
        return true || token && token.length > 0; // TODO: remove bypass
    }
}
