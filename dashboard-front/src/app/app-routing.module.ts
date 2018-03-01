import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AuthenticationComponent} from "./page/authentication/authentication.component";

const routes: Routes = [
    // path: '', redirectTo: '/', pathMatch: 'full' },
    { path: '', component: AuthenticationComponent },
    //{ path: 'login', component: LoginComponent },
    //{ path: 'account',  component: AccountComponent, canActivate: [CanActivateAuthGuard] },
];

@NgModule({
    imports: [ RouterModule.forRoot(routes) ],
    exports: [ RouterModule ]
})
export class AppRoutingModule {}
