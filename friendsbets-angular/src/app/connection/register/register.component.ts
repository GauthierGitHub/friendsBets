import { Component, OnInit, Input, Output } from '@angular/core';
import { User } from 'src/app/models/user.model';
import { ConnectionService } from '../connection.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  u: User;
  title: string = "Register"
  label: string = "Register !"

  constructor(private cs: ConnectionService) { }

  ngOnInit(): void {
    this.u = new User(-1, "defaultAlias", "defaultEmail", "defaultPassword");

  }
  registerUser() {
    this.cs.addUser(this.u);
  }
}
