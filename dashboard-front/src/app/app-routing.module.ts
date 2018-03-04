import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AuthenticationComponent} from './page/authentication/authentication.component';
import {HomeComponent} from './page/home/home.component';

const routes: Routes = [
    // path: '', redirectTo: '/', pathMatch: 'full' },
    { path: '', component: AuthenticationComponent },
    { path: 'dashboard', component: HomeComponent },
    //{ path: 'login', component: LoginComponent },
    //{ path: 'account',  component: AccountComponent, canActivate: [CanActivateAuthGuard] },
];

@NgModule({
    imports: [ RouterModule.forRoot(routes) ],
    exports: [ RouterModule ]
})
export class AppRoutingModule {}
