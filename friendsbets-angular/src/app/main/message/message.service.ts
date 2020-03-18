import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Message } from 'src/app/models/message.model';
import { Serializer } from 'src/app/models/serializer/Serializer';

@Injectable({
  providedIn: 'root'
})
export class MessageService {
  
  private url: string = "http://localhost:8080/message";

  constructor(private httpClient: HttpClient) { }

  public saveMessage(m: Message) {
    m.id = undefined;
    m.date= new Date();
    m = Serializer.serializeToJSON(m);
    this.httpClient.post(this.url, m).subscribe();
  }
}
