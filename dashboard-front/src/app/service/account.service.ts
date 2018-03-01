import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from 'rxjs/Rx';

import {Account} from '../model/Account';
import {AuthenticationService} from './authentication.service';
import {environment} from '../../environments/environment';
import {catchError} from 'rxjs/operators';
import {HttpUtil} from '../util/HttpUtil';

@Injectable()
export class AccountService {

    private headers = new HttpHeaders({
        'Content-Type': 'application/json',
        'Accept' : 'application/json',
        'Authorization': 'Bearer ' + this.authenticationService.getToken()
    });
    private options = { headers: this.headers };

    constructor(private http:HttpClient, private authenticationService:AuthenticationService) {}

    update(account: Account) : Observable<boolean> {
        return this
            .http
            .put(environment.apiHost+`/account`, account, this.options)
            .pipe(catchError(HttpUtil.handleError));
    }
}
