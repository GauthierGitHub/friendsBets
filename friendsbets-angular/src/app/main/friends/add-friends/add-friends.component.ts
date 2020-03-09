import { Component, OnInit } from '@angular/core';
import { FriendsService } from '../friends.service';
import { User } from 'src/app/models/user.model';
import { ConnectionService } from 'src/app/connection/connection.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-friends',
  templateUrl: './add-friends.component.html',
  styleUrls: ['./add-friends.component.scss']
})
export class AddFriendsComponent implements OnInit {

  users: User[];

  constructor(private fs: FriendsService
      , private cs : ConnectionService
      , private router: Router) { }

  ngOnInit(): void {
    this.fs.findAllOthers(this.cs.connectedUser).subscribe( x => this.users = x);
  }

  onFormSubmit() {
    this.fs.addFriends(this.users, this.cs.connectedUser).subscribe( x => {
      this.cs.connectedUser.friends = this.users;
      this.router.navigateByUrl("main");
    }) //! TODO: ERROR & COMPLETE
  }

}
