import { Injectable } from '@angular/core';
import { ConnectionService } from 'src/app/connection/connection.service';
import { User } from 'src/app/models/User.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Group } from 'src/app/models/Group.model';
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
    g.id = undefined;
    // substract unecessary datas
    g.userList.forEach(x => x=new User(x.id))
    g = Serializer.serializeToJSON(g);
    console.log(g);
    console.log(JSON.stringify(g));
    return this.httpClient.post<Group>(this.url + "group", Serializer.serializeToJSON(g));
  }

  public findAllForOneUser(u: User): Observable<Group[]> {
    return this.httpClient.get<Group[]>(this.url + "group/mygroups/" + u.id);
  }

  public findById(id: string): Observable<Group> {
    return this.httpClient.get<Group>(this.url + "group/" + id);
  }

}
