import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { User } from 'src/app/models/User.model';
import { ConnectionService } from '../connection.service';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.scss']
})
export class UserFormComponent implements OnInit {

  // TODO: REMOVE VAR I, SINGLETON CONNECTIONSERVICE AND MAGIG BUTTON

  @Input()
  title: string;
  @Input()
  label: string;
  @Input()
  user: User;
  @Output("formSubmited")
  submited: EventEmitter<User> = new EventEmitter<User>();
  //! TODO: remove me !
  i: number = 1;

  constructor(private cs: ConnectionService) { }

  ngOnInit(): void {
    // this.user = new User(-1, "defaultAlias", "defaultEmail", "defaultPassword");
    
  }

  userSending() {
    this.submited.emit(this.user);
  }

  /**
   * ! TODO: remove me !
   * Recursivity for keep order in asynchrone register.
   */
  fillingDb() {
    if(this.i<15) {
      let user : User = new User(0, "User"+this.i, "Email"+this.i, "Password"+this.i);
      user.id = undefined;
      this.cs.register(user, () => {
        this.i++;
        this.fillingDb();
      });
    }
  }

}
