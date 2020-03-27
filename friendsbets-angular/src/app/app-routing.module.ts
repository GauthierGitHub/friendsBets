import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from './connection/register/register.component';
import { LoginComponent } from './connection/login/login.component';
import { MainComponent } from './main/main.component';
import { CreateGroupComponent } from './main/group/create-group/create-group.component';
import { MessageComponent } from './main/message/message-box/message.component'
import { AddFriendsComponent } from './main/friends/add-friends/add-friends.component';

const routes: Routes = [
  // exemples
  // { path: "", component: AppComponent},
  // exemple for path variables
  // { path: "members/pv/:prenom/:nom", component: MemberComponent},
  // exemple for modules paths
  // { path: "members", loadChildren: "./members/members.module#MembersModule"}
  // exemple for animation
  // { path: 'heroes',  component: HeroListComponent, data: { animation: 'heroes' } },
  { path: "login", component: LoginComponent},
  { path: "register", component: RegisterComponent},
  { path: "main", component: MainComponent, data: { state: 'main' } },
  { path: "create-group", component: CreateGroupComponent, data: { state: 'create-group' } },
  { path: "add-friends", component: AddFriendsComponent, data: { state: 'add-friends' } },
  { path: "message/:group-id", component: MessageComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
