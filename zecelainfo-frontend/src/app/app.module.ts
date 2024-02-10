import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';

import { HttpClientInMemoryWebApiModule } from 'angular-in-memory-web-api';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { ProblemeComponent } from './probleme/probleme.component';
import { ProblemaDetailComponent } from './probleme/probleme-detail/probleme-detail.component';
import { LoginComponent } from './login/login.component';
import { AuthInterceptor } from './auth.interceptor';
import { RegisterComponent } from './register/register.component';
import { ProblemeNewComponent } from './probleme/probleme-new/probleme-new.component';
import { ClaseComponent } from './clase/clase.component';
import { ClasaDetailComponent } from './clase/clase-detail/clase-detail.component';

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [ { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },],
  declarations: [
    AppComponent,
    ProblemeComponent,
    ProblemaDetailComponent,
    LoginComponent,
    RegisterComponent,
    ProblemeNewComponent,
    ClaseComponent,
    ClasaDetailComponent
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
