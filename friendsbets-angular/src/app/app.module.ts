import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
// import { HttpClient } from '@angular/common/http';

//anims
// import { OpenCloseComponent } from './open-close.component';


// normals imports
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './connection/login/login.component';
import { RegisterComponent } from './connection/register/register.component';
import { UserFormComponent } from './connection/user-form/user-form.component';
import { MainComponent } from './main/main.component';
import { HeaderComponent } from './structure/header/header.component';
import { CookieService } from 'ngx-cookie-service';
import { CreateGroupComponent } from './main/group/create-group/create-group.component';
import { ManageGroupComponent } from './main/group/manage-group/manage-group.component';
import { AddFriendsComponent } from './main/friends/add-friends/add-friends.component';
import { ManageFriendsComponent } from './main/friends/manage-friends/manage-friends.component';
import { MessageComponent } from './main/message/message-box/message.component';
import { RouterOutlet } from '@angular/router';
import { FooterComponent } from './structure/footer/footer.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    UserFormComponent,
    MainComponent,
    HeaderComponent,
    CreateGroupComponent,
    ManageGroupComponent,
    AddFriendsComponent,
    ManageFriendsComponent,
    MessageComponent,
    FooterComponent,
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BrowserModule,
    BrowserAnimationsModule,
  ],
  providers: [
    CookieService
  ],
  
  bootstrap: [AppComponent]
})
export class AppModule { }
