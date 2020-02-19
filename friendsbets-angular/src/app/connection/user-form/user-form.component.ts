import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { User } from 'src/app/models/user.model';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.scss']
})
export class UserFormComponent implements OnInit {

  @Input()
  title: string;
  @Input()
  label: string;
  @Input()
  u: User;
  @Output("formSubmited")
  submited: EventEmitter<User> = new EventEmitter<User>();

  constructor() { }

  ngOnInit(): void {
    this.u.alias = "defaultAlias";
    this.u.email = "defaultEmail";
    this.u.password = "defaultPassword";
  }

  onSubmit() {
    this.submited.emit(this.u);
  }

}