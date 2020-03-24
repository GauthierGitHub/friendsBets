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

  public saveMessage(m: Message, success?: () => void) {
    m.id = undefined;
    // Simplify author.
    m.author = new User(m.author.id);
    // Simplify group.
    m.group = new Group(m.group.id);
    // Date stamp.
    m.date = new Date();
    m = Serializer.serializeToJSON(m);
    return this.httpClient.post(this.url, m).subscribe(() => success());
  }

  findMessageForOneGroup(id: string, offset?: string): Observable<Message[]> {
    if (offset)
      return this.httpClient.get<Message[]>(this.url + id + "/" + offset);
    else
      return this.httpClient.get<Message[]>(this.url + id);
  }
}