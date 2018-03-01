import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Account} from '../../model/Account';
import {AuthenticationService} from '../../service/authentication.service';

@Component({
    selector: 'app-authentication',
    templateUrl: './authentication.component.html',
    styleUrls: ['./authentication.component.css'],
    providers: [AuthenticationService]
})
export class AuthenticationComponent implements OnInit {

    account:Account = { email: '', password: '' };

    showLoginForm: boolean = true;
    form: FormGroup;

    constructor(private authenticationService:AuthenticationService) {}

    ngOnInit() {
        this.form = new FormGroup({
            'email' : new FormControl(this.account.email, [
                Validators.required,
                Validators.email,
                Validators.minLength(7),
                Validators.maxLength(100),
            ]),
            'password' : new FormControl('', [
                Validators.required,
                Validators.minLength(8),
                Validators.maxLength(30),
            ])
        });
    }

    toggleShowLoginForm() {
        this.showLoginForm = !this.showLoginForm;
    }

    submitLogin() {
        this.authenticationService.login(this.account.email, this.account.password);
    }

    submitSignup() {
        this.authenticationService.signup(this.account.email, this.account.password);
    }
}
