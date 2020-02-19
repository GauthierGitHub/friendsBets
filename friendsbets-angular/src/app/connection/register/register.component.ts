import { Component, OnInit } from '@angular/core';
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
  }

  onSubmit(uFromForm: User) {
    console.log(this.u);
    console.log(uFromForm);
    this.cs.addUser(uFromForm);
    
  }
}
