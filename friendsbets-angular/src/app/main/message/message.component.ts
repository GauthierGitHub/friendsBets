import { Component, OnInit } from '@angular/core';
import { trigger, state, style, transition, animate } from '@angular/animations';
import { ActivatedRoute, Router, ParamMap } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { GroupsService } from '../group/groups.service';
import { Group } from 'src/app/models/Group.model';
import { ConnectionService } from 'src/app/connection/connection.service';
import { Message } from 'src/app/models/Message.model';
import { MessageService } from './message.service';
import { User } from 'src/app/models/User.model';
import { Serializer } from 'src/app/models/serializer/Serializer';

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.scss'],
  animations: [
    trigger('Grow', [
      state('inactive', style({
        transform: 'scale(0.1)'
      })),
      state('active', style({
        transform: 'scale(1)'
      })),
      transition('inactive => active', animate('800ms ease-in')),
    ])
  ]
})
export class MessageComponent implements OnInit {

  group: Group;
  message: Message;
  messages: Message[];


  constructor(private aRoute: ActivatedRoute
    , private gs: GroupsService
    , private cs: ConnectionService
    , private ms: MessageService) { }


  ngOnInit() {
    this.group = new Group(-1); // TODO: remove me ? Avoid log error
    this.message = new Message(-1); // TODO: remove me ? Avoid log error
    let id = this.aRoute.snapshot.paramMap.get('group-id');
    this.gs.findById(id).subscribe(x => {  
      this.group = Serializer.toTypeScriptObject<Group>(x, Group);      
      this.message = new Message(-1, this.cs.connectedUser, this.group, ""); 
    });
  }

  sendMessage() {
    this.ms.saveMessage(this.message);
  }
}
