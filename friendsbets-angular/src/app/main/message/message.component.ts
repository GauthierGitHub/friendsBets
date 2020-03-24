import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router, ParamMap } from '@angular/router';
import { GroupsService } from '../group/groups.service';
import { Group } from 'src/app/models/Group.model';
import { ConnectionService } from 'src/app/connection/connection.service';
import { Message } from 'src/app/models/Message.model';
import { MessageService } from './message.service';
import { Serializer } from 'src/app/models/serializer/Serializer';

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.scss'],
})
export class MessageComponent implements OnInit {

  group: Group;
  @Input() messageToSend: Message;
  messages: Message[];


  constructor(private aRoute: ActivatedRoute
    , private gs: GroupsService
    , public cs: ConnectionService
    , private ms: MessageService) { }


  ngOnInit() {
    this.group = new Group(-1); // TODO: remove me ? Avoid log error
    this.messageToSend = new Message(-1); // TODO: remove me ? Avoid log error
    let id = this.aRoute.snapshot.paramMap.get('group-id');
    // Find group.
    this.gs.findById(id).subscribe(x => {  
      this.group = Serializer.toTypeScriptObject<Group>(x, Group);      
      this.messageToSend = new Message(-1, this.cs.connectedUser, this.group, ""); 
    });
    // Find messages.
    this.ms.findMessageForOneGroup(id).subscribe(x => {
      // Serialize all messages.
      if(x) {
        x.forEach(mess => { Serializer.toTypeScriptObject<Message>(mess, Message);});
        this.messages = x;
      }
      else {
        console.log("No messages for this group");
        
        // TODO: else
      }
    })
  }

  /**
   * Writte message in database.
   * If writting is succeed push the sended message to displayed messages then
   * create a new empty message.
   */
  sendMessage() {
    // this.ms.saveMessage(this.messageToSend, () => this.messages.push(this.messageToSend));
    this.ms.saveMessage(this.messageToSend, () => {
      this.messages.push(this.messageToSend);
      this.messageToSend = new Message(-1, this.cs.connectedUser, this.group, ""); 
    });
  }
}
