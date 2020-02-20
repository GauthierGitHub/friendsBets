import { Component, OnInit, Input } from '@angular/core';
import { ConnectionService } from '../connection.service';
import { User } from 'src/app/models/user.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  
  u: User;
  title: string = "Login"
  label: string = "Go !"

  constructor(private cs: ConnectionService) { }

  ngOnInit(): void {
    this.u = new User(-1, "defaultAlias", "defaultEmail", "defaultPassword");
  }

  logUser() {
    console.log(this.u);
  }
}
