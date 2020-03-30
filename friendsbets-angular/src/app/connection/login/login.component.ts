import { Component, OnInit, Input } from '@angular/core';
import { ConnectionService } from '../connection.service';
import { User } from 'src/app/models/User.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  user: User;
  title: string = "Login"
  label: string = "Go !"

  constructor(private cs: ConnectionService, private router: Router) { }

  ngOnInit() {
    // Needed by user-form component
    this.user = new User(-1);
  }

  logUser() { 
    this.cs.login(
      this.user.email, this.user.password
      , () => this.router.navigateByUrl("main") // success
      , () => console.log("login error") // error //TODO: error
    );
  }
}
