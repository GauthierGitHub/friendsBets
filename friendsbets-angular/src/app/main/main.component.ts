import { Component, OnInit } from '@angular/core';
import { User } from '../models/User.model';
import { ConnectionService } from '../connection/connection.service';
import { Group } from '../models/Group.model';
import { GroupsService } from './group/groups.service';
import { trigger, state, style, transition, animate } from '@angular/animations';
import { timer } from 'rxjs';
@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss'],
  animations: [
    trigger('Grow', [
      state('inactive', style({
        transform: 'scale(0.8)'
      })),
      state('active', style({
        transform: 'scale(1)'
      })),
      transition('inactive => active', animate('800ms ease-in')),
    ])
  ]
})
export class MainComponent implements OnInit {

  user: User;
  groups: Group[];
  // anim
  stateGrow : string = "inactive"; 

  constructor(private cs: ConnectionService, private gs: GroupsService) { }

  ngOnInit(): void {
    this.user = this.cs.connectedUser;
    this.gs.findAllForOneUser(this.user).subscribe(x => this.groups = x);

    // anim
    let timer2 = timer(300);
    timer2.subscribe(t=> {
      this.stateGrow = "active";
    });

  }

}
