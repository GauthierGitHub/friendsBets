import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ConnectionService } from 'src/app/connection/connection.service';
import { Group } from 'src/app/models/Group.model';
import { Message } from 'src/app/models/Message.model';
import { Serializer } from 'src/app/models/serializer/Serializer';
import { GroupsService } from '../../group/groups.service';
import { MessageService } from '../message.service';

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.scss'],
})
export class MessageComponent implements OnInit {

  group: Group;
  messageToSend: Message;
  messages: Message[];
  bottom: HTMLElement;

  constructor(private aRoute: ActivatedRoute
    , private gs: GroupsService
    , public cs: ConnectionService
    , private ms: MessageService) { }

  ngOnInit() {
    // Place a "hook" at the bottom of DOM.
    this.bottom = document.getElementById("bottom");
    // Initialize attributes.
    this.group = new Group(-1); // TODO: remove me ? Avoid log error
    this.messageToSend = new Message(-1); // TODO: remove me ? Avoid log error
    let id = this.aRoute.snapshot.paramMap.get('group-id');
    // Find group.
    this.gs.findById(id).subscribe(x => {
      this.group = Serializer.toTypeScriptObject<Group>(x, Group);
      this.messageToSend = new Message(-1, this.cs.connectedUser, this.group, "");
    });
    // Find messages.
    this.ms.findTwenty(id).subscribe(x => {
      // Serialize all messages if they exist.
      if (x) {
        x.forEach(mess => { Serializer.toTypeScriptObject<Message>(mess, Message); });
        // Json sent with inversed order.
        this.messages = x.reverse();
        // Reconstruct users.
        this.ms.rebuildMessagesUsers(this.messages, () => console.log("rebuild succed"));
      }
      else {// TODO: else
        console.log("No messages for this group");
      }
    }, () => console.log("error fonction") // error() // TODO: error
      , () => setTimeout(() => this.scroll(this.bottom), 50)); // succed(), has to wait DOM writting
  }

  /**
   * Scroll to an html element. 
   */
  scroll(el: HTMLElement) {
    el.scrollIntoView({ behavior: 'smooth' });
  }

  /**
   * Writte message in database.
   * If writting is succeed push the sended message to displayed messages then
   * create a new empty message.
   */
  sendMessage() {
    this.ms.saveMessage(this.messageToSend, () => {
      // Succed :
      this.messages.push(this.messageToSend);
      this.messageToSend = new Message(-1, this.cs.connectedUser, this.group, "");
      setTimeout(() => this.scroll(this.bottom), 50); // has to wait DOM writting
    });
  }
}
