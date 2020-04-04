import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Message } from 'src/app/models/Message.model';
import { Serializer } from 'src/app/models/serializer/Serializer';
import { User } from 'src/app/models/User.model';
import { Group } from 'src/app/models/Group.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  private url: string = "http://localhost:8080/message/";

  constructor(private httpClient: HttpClient) { }

  /**
   * Lighten a message and writte it in db.
   * @param m 
   * @param success function if subscribe succeed
   */
  public saveMessage(m: Message, success?: () => void) {
    m.id = undefined;
    // Simplify author.
    m.author = new User(m.author.id);
    // Simplify group.
    m.group = new Group(m.group.id);
    // Date stamp.
    m.date = new Date();
    m = Serializer.serializeToJSON(m);
    return this.httpClient.post(this.url, m).subscribe(() => {if(success) success()});
  }

  /**
   * Find twenty messages, with an offset or not.
   * 
   * @param id Group id.
   * @param offset 
   */
  public findTwenty(id: string, offset?: string): Observable<Message[]> {
    if (offset)
      return this.httpClient.get<Message[]>(this.url + id + "/" + offset);
    else
      return this.httpClient.get<Message[]>(this.url + id);
  }

  public rebuildMessagesUsers(lm: Message[], success?: () => void): void {
    let users: User[] = new Array();
    // Push all user in array.
    lm.forEach(x => {
      if (typeof(x.author) == "object")
        users.push(x.author);
    })
    // Then fill the message array.
    lm.forEach( x => {
      if (typeof(x.author) == "number") {
        for (let i = 0; i < users.length; i++) {
          let a: any = x.author; // needed for comparaison
          if ( users[i].id == a) {
            x.author = users[i];
            continue;
          }
        }
      }
    })
    if(success) success();
  }
}