import { Component, OnInit, OnChanges } from '@angular/core';
import { FriendsService } from '../friends.service';
import { User } from 'src/app/models/User.model';
import { ConnectionService } from 'src/app/connection/connection.service';
import { Router } from '@angular/router';
import { trigger, state, style, transition, animate } from '@angular/animations';
import { Serializer } from 'src/app/models/serializer/Serializer';

@Component({
  selector: 'app-add-friends',
  templateUrl: './add-friends.component.html',
  styleUrls: ['./add-friends.component.scss'],
  
})
export class AddFriendsComponent implements OnInit {

  allUsers: User[];
  checkedUsers: User[];

  constructor(private fs: FriendsService
    , private cs: ConnectionService
    , private router: Router) { }

  /**
   * Find all users who are not the user or his friends.
   * Transfom them to typeScript objects.
   */
  ngOnInit(): void {
    this.fs.findAllOthers(this.cs.connectedUser).subscribe(x => {
      x.forEach(y => Serializer.toTypeScriptObject(y, User));  
      this.allUsers = x;
    });
    this.checkedUsers = [];
  }

  /**
   * Toggle checked user in checkedUsers array.
   * @param u
   */
  onCheckboxClicked(u: User): void {
    if (this.checkedUsers.includes(u)) {
      let pos = this.checkedUsers.findIndex(x => x == u);
      this.checkedUsers.splice(pos, 1);
    } else {
      this.checkedUsers.push(u);
    }
  }

  /**
   * Send to db.
   */
  onFormSubmit(): void {
    this.fs.addFriends(this.checkedUsers, this.cs.connectedUser).subscribe(x => {
      this.cs.connectedUser.friends = this.checkedUsers;
      this.router.navigateByUrl("main");
    }) //! TODO: ERROR & COMPLETE
  }


}
