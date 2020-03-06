import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user.model';
import { GroupsService } from '../groups.service';
import { ConnectionService } from 'src/app/connection/connection.service';
import { Group } from 'src/app/models/group.model';

@Component({
  selector: 'app-create-group',
  templateUrl: './create-group.component.html',
  styleUrls: ['./create-group.component.scss']
})
export class CreateGroupComponent implements OnInit {

  friends: User[];
  g: Group;

  constructor(private gs: GroupsService, private cs: ConnectionService) { }

  ngOnInit(): void {
    this.g = new Group(-1, this.cs.connectedUser.nickname + " Group", this.cs.connectedUser)
    this.gs.findAllFriends(this.cs.connectedUser).subscribe( x => {
      this.friends = x;
      }
    )
  }

}
