import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user.model';
import { ConnectionService } from 'src/app/connection/connection.service';
import { Group } from 'src/app/models/group.model';
import { FriendsService } from '../../friends/friends.service';
import { GroupsService } from '../groups.service';
import { Router } from '@angular/router';

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

  ngOnInit(): void {
    this.g = new Group(-1, this.cs.connectedUser.nickname + " Group", null)
    this.checkedFriends = [this.cs.connectedUser];
    this.us.findFriends(this.cs.connectedUser).subscribe( x => this.friends = x);
  }

  onCheckboxClicked(u: User): void {
    console.log("onCheckboxClicked()");
    
    if (this.checkedFriends.includes(u)) {
      let pos = this.checkedFriends.findIndex(x => x == u);
      this.checkedFriends.splice(pos, 1);
      console.log(this.checkedFriends);
      
    } else {
      this.checkedFriends.push(u);
      console.log(this.checkedFriends);
    }
  }

  onFormSubmit(): void {
    this.g.userList = this.checkedFriends;
    this.gs.createGroup(this.g).subscribe(x=>{
      console.log("request OK");
      this.router.navigateByUrl("main"); 
    });
    console.log("form group submited");
  }
}
