import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Message } from 'src/app/models/Message.model';
import { Serializer } from 'src/app/models/serializer/Serializer';
import { User } from 'src/app/models/User.model';
import { Group } from 'src/app/models/Group.model';

@Injectable({
  providedIn: 'root'
})
export class MessageService {
  
  private url: string = "http://localhost:8080/message";

  constructor(private httpClient: HttpClient) { }

  public saveMessage(m: Message) {
    m.id = undefined;
    // simplify author
    m.author = new User(m.author.id);
    // simplify group
    m.group = new Group(m.group.id);
    m.date= new Date();
    console.log(m);
    
    m = Serializer.serializeToJSON(m);
    console.log(m);
    console.log(JSON.stringify(m));
    
    this.httpClient.post(this.url, m).subscribe();
  }
}
// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idDistrito")     
// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idEntidade")  
// @JsonIdentityInfo(scope = Distritos.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "idDistrito")
// @JsonIdentityInfo(scope = Entidades.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "idEntidade")