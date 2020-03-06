import { Injectable } from '@angular/core';
import { ConnectionService } from 'src/app/connection/connection.service';
import { User } from 'src/app/models/user.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GroupsService {

  // private url: string = "http://localhost:8080/friendsbets-webservice/";
  private url: string = "http://localhost:8080/"

  constructor(private httpClient: HttpClient) { }

  public findAllFriends(u: User): Observable<User[]> {
    // TODO: Get all frinds for one user
    return this.httpClient.get<User[]>(this.url + "user/");
  }

  public findAllGroup(u: User) {
    
  }


}
