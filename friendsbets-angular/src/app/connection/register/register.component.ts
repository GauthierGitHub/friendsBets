import { Component, OnInit, Input, Output } from '@angular/core';
import { User } from 'src/app/models/User.model';
import { ConnectionService } from '../connection.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  user: User;
  title: string = "Register"
  label: string = "Register !"

  constructor(private cs: ConnectionService, private router: Router) { }

  ngOnInit(): void {
    // hydrating object
    // this.u = new User(-1, "defaultAlias", "defaultEmail", "defaultPassword");
    // this.u = this.cs.connectedUser;
    // TODO: Remove me !
    this.user = this.cs.connectedUser == null ? new User(-1, "MADEBYREGISTER", "defaultEmail", "defautlPassword") : this.cs.connectedUser;

  }
  
  registerUser() {
    this.cs.register(this.user, () => this.router.navigateByUrl("main"));
  }
}
