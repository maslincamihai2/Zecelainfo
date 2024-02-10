import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProblemeComponent } from './probleme/probleme.component';
import { ProblemaDetailComponent } from './probleme/probleme-detail/probleme-detail.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ProblemeNewComponent } from './probleme/probleme-new/probleme-new.component';
import { ClaseComponent } from './clase/clase.component';
import { ClasaDetailComponent } from './clase/clase-detail/clase-detail.component';

const routes: Routes = [
  { path: '', redirectTo: '/probleme', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'probleme', component: ProblemeComponent },
  { path: 'problema/:id', component: ProblemaDetailComponent },
  { path: 'probleme-new', component: ProblemeNewComponent },
  // { path: 'probleme/update/:id', component: ProblemaUpdateCreateComponent },
  { path: 'clase', component: ClaseComponent },
  { path: 'clasa/:id', component: ClasaDetailComponent },
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
