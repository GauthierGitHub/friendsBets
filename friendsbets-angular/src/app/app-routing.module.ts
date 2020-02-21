import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from './connection/register/register.component';
import { LoginComponent } from './connection/login/login.component';
import { MainComponent } from './main/main.component';
import { CreateGroupComponent } from './main/create-group/create-group.component';


const routes: Routes = [
  // exemples
  // { path: "", component: AppComponent},
  // { path: "members/pv/:prenom/:nom", component: MemberComponent},
  // { path: "members", loadChildren: "./members/members.module#MembersModule"}
  { path: "login", component: LoginComponent},
  { path: "register", component: RegisterComponent},
  { path: "main", component: MainComponent},
  { path: "create-group", component: CreateGroupComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
