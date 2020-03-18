import { Component, OnInit } from '@angular/core';
import { trigger, state, style, transition, animate } from '@angular/animations';
import { ActivatedRoute, Router, ParamMap } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { GroupsService } from '../group/groups.service';
import { Group } from 'src/app/models/group.model';
import { ConnectionService } from 'src/app/connection/connection.service';
import { Message } from 'src/app/models/message.model';
import { MessageService } from './message.service';
import { User } from 'src/app/models/user.model';
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

  constructor(private router: Router
    , private aRoute: ActivatedRoute
    , private gs: GroupsService
    , private cs: ConnectionService
    , private ms: MessageService) { }

    /**
     *     this.group = this.aRoute.paramMap.pipe(
            switchMap((params: ParamMap) =>
            this.gs.findById(params.get('id')))
    );
     */
  ngOnInit() {
    let id = this.aRoute.snapshot.paramMap.get('group-id');
    this.gs.findById(id).subscribe(x => {
      console.log(Serializer.addUnderscore(x));
      console.log(typeof Serializer.addUnderscore(x));
      console.log(Serializer.toTypeScriptObject(x));
      console.log(typeof Serializer.toTypeScriptObject(x));
      console.log("putain");
      

      
      this.group = x;
      this.message = new Message(-1, this.cs.connectedUser, this.group, ""); 
    });
  }

  sendMessage() {
    this.ms.saveMessage(this.message);
  }
}
