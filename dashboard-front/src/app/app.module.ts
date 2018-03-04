import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';

import {AppComponent} from './app.component';
import {MaterialModule} from './material/material.module';
import { AuthenticationComponent } from './page/authentication/authentication.component';
import {AppRoutingModule} from './app-routing.module';
import {CanActivateAuthGuard} from './guard/can-activate-auth.guard';
import { HomeComponent } from './page/home/home.component';

@NgModule({
    declarations: [
        AppComponent,
        AuthenticationComponent,
        HomeComponent
    ],
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        FormsModule,
        ReactiveFormsModule,
        HttpClientModule,
        MaterialModule,
        AppRoutingModule
    ],
    providers: [CanActivateAuthGuard],
    bootstrap: [AppComponent],
    entryComponents: []
})
export class AppModule {}
