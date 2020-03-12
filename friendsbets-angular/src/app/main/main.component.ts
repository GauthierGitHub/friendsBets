import { Component, OnInit } from '@angular/core';
import { User } from '../models/user.model';
import { ConnectionService } from '../connection/connection.service';
import { Group } from '../models/group.model';
import { GroupsService } from './group/groups.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss']
})
export class MainComponent implements OnInit {

  u: User;
  groups: Group[];

  constructor(private cs: ConnectionService, private gs: GroupsService) { }

  ngOnInit(): void {
    this.u = this.cs.connectedUser;
    this.gs.findAllForOneUser(this.u).subscribe(x => this.groups = x);
  }

}
