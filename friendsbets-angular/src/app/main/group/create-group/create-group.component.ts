import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/User.model';
import { ConnectionService } from 'src/app/connection/connection.service';
import { Group } from 'src/app/models/Group.model';
import { FriendsService } from '../../friends/friends.service';
import { GroupsService } from '../groups.service';
import { Router } from '@angular/router';
import { Serializer } from 'src/app/models/serializer/Serializer';

@Component({
  selector: 'app-create-group',
  templateUrl: './create-group.component.html',
  styleUrls: ['./create-group.component.scss']
})
export class CreateGroupComponent implements OnInit {

  // TODO: string for name of group
  friends: User[];
  checkedFriends: User[];
  g: Group;

  constructor(
    private gs: GroupsService
    , private us: FriendsService
    , private cs: ConnectionService
    , private router: Router
    ) { }

  /**
   * Find all friends of connected user.
   * Serialize them to typeScript object.
   */
  ngOnInit(): void {
    this.g = new Group(-1, this.cs.connectedUser.nickname + " Group")
    this.checkedFriends = [this.cs.connectedUser];
    this.us.findFriends(this.cs.connectedUser).subscribe( x => {
      x.forEach(y => Serializer.toTypeScriptObject(y, User));
      this.friends = x;
    });
  }

  /**
   * Control checked user and push/remove them to an array.
   * Keep connected User at the first array's index for stay admin of group.
   * @param u 
   */
  onCheckboxClicked(u: User): void {
    if (this.checkedFriends.includes(u)) {
      let pos = this.checkedFriends.findIndex(x => x == u);
      this.checkedFriends.splice(pos, 1);
    } else
    this.checkedFriends.push(u);
  }

  /**
   * Send to db and redirect to main.
   */
  onFormSubmit(): void {
    this.g.userList = this.checkedFriends;
    this.gs.createGroup(this.g).subscribe(x=>{
      this.router.navigateByUrl("main"); 
    });
  }
}
