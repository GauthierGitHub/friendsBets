import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from 'src/app/models/user.model';

@Injectable({
  providedIn: 'root'
})
export class FriendsService {

  private url: string = "http://localhost:8080/";

  constructor(private httpClient: HttpClient) { }

  public findAllOthers(u: User): Observable<User[]> {
    return this.httpClient.get<User[]>(this.url + "user/friends/" + u.id);
  }
}
