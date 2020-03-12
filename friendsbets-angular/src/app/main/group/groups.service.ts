import { Injectable } from '@angular/core';
import { ConnectionService } from 'src/app/connection/connection.service';
import { User } from 'src/app/models/user.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Group } from 'src/app/models/group.model';
import { Serializer } from '../../models/serializer/Serializer'

@Injectable({
  providedIn: 'root'
})
export class GroupsService {

  // private url: string = "http://localhost:8080/friendsbets-webservice/";
  private url: string = "http://localhost:8080/";

  constructor(private httpClient: HttpClient) { }

  // public findAllFriends(u: User): Observable<User[]> {
  //   // TODO: Get all friends for one user
  //   return this.httpClient.get<User[]>(this.url + "friends/" + u.id);
  // }

  // public findAllGroup(u: User) {
    
  // }

  public createGroup(g: Group): Observable<Group> {
    console.log(g);
    return this.httpClient.post<Group>(this.url + "group", Serializer.serializeToJSON(g));
  }

}
