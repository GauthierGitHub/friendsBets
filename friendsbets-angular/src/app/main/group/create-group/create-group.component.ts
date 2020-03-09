import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user.model';
import { ConnectionService } from 'src/app/connection/connection.service';
import { Group } from 'src/app/models/group.model';
import { FriendsService } from '../../friends/friends.service';

@Component({
  selector: 'app-create-group',
  templateUrl: './create-group.component.html',
  styleUrls: ['./create-group.component.scss']
})
export class CreateGroupComponent implements OnInit {

  friends: User[];
  g: Group;

  constructor(private us: FriendsService, private cs: ConnectionService) { }

  ngOnInit(): void {
    this.g = new Group(-1, this.cs.connectedUser.nickname + " Group", this.cs.connectedUser)
    this.us.findFriends(this.cs.connectedUser).subscribe( x => {
      this.friends = x;
      }
    )
  }

}
