import {Component, OnInit} from '@angular/core';
import {FormControl, Validators} from "@angular/forms";

@Component({
    selector: 'app-authentication',
    templateUrl: './authentication.component.html',
    styleUrls: ['./authentication.component.css']
})
export class AuthenticationComponent implements OnInit {

    loginForm: FormControl;

    constructor() {}

    ngOnInit() {
        this.loginForm = new FormControl('', [
            Validators.required,
            Validators.email,
        ]);
    }

}
