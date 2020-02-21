import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HttpClient } from '@angular/common/http';
// import { HttpClient } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './connection/login/login.component';
import { RegisterComponent } from './connection/register/register.component';
import { UserFormComponent } from './connection/user-form/user-form.component';
import { MainComponent } from './main/main.component';
import { HeaderComponent } from './main/header/header.component';
import { CookieService } from 'ngx-cookie-service';
import { CreateGroupComponent } from './main/create-group/create-group.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    UserFormComponent,
    MainComponent,
    HeaderComponent,
    CreateGroupComponent,
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
  ],
  providers: [
    CookieService
  ],
  
  bootstrap: [AppComponent]
})
export class AppModule { }
