import { Component, OnInit, Input } from '@angular/core';
import { ConnectionService } from '../connection.service';
import { User } from 'src/app/models/user.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  
  u: User;
  title: string = "Login"
  label: string = "Go !"

  constructor(private cs: ConnectionService, private router: Router) { }

  ngOnInit(): void {
    // this.u = new User(-1, "defaultAlias", "defaultEmail", "defaultPassword");
    this.u = this.cs.connectedUser;
  }

  logUser() {
    this.cs.login(
      this.u.email
      , this.u.password
      , () => {
            console.log("redirect to main");
            this.router.navigateByUrl("main");
          }
      , () => console.log("login error") //TODO: verify error
      
    );      
  }
}
