import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user.model';
import { UserSerializer } from '../models/serializer/Serializer';
import { CookieService } from 'ngx-cookie-service';

/**
 *
!!!!!!!!!!!!!! httpClient.subscribe is Asynchrone !!!!!!!!!!!
 *
 *
 * lamda can avoid ?
 *********** json format for UserS in webService
{
    "nickname": "Jp",
    "password": "password",
    "email": "jp@gmail.com",
    "picturePath": null
}
 *********** json format for EVENT
    { 
      "producer": {
        "id": 33
      },
      "title": "greve REST put update",
      "description": "greve de la poste REST",
      "score": 1.0,
      "type": "STRIKE"
      }
 */
@Injectable({
  providedIn: 'root'
})
export class ConnectionService {

  // private _Users: User[] = [];

  private _connectedUser: User = null;
  private _cookieServ: CookieService;
  private url: string = "http://localhost:8080/friendsbets-webservice/user/";

  constructor(private httpClient: HttpClient) { }

  public addUser(m: User): void {
    let u = UserSerializer.serializetoJSON(m);
    this.httpClient.post(this.url, u).subscribe();
  }

  public update(m: User): void {
    // TODO: Verify if serializer is needed
    let url2 = this.url + m.id;
    this.httpClient.put(url2, m).subscribe();
  }

  public delete(m: User): void {
    this.httpClient.delete<User>(this.url + m.id).subscribe(x => console.log("delete ok"));
  }

  public login(email: string, password: string) {
    var m: User = new User(-1, "a", email, "a");
    // TODO: success and error
    return this.httpClient.post<User>(this.url + "signin", {}, {
      params: {
        "email": email,
        "password": password
      }
    }).subscribe(x => {
      this.connectedUser = x;
    });
  }

  // public login(email: string, password: string, success?: (/*TypedObject*/) => void, error?: (any) => void) {
  //   var m: User = new User(-1, "a", email, "a");
  //   // TODO: success and error
  //   return this.httpClient.post<User>(this.url + "signin", {}, {
  //     params: {
  //       "email": email,
  //       "password": password
  //     }
  //   }).subscribe(x => {
  //     this.connectedUser = x;
  //     //this.cookieServ = this.cookieServ.set();
  //   }, error, success/** , success(this.connectedMember), error() */);
  // }

  public findAll(): Observable<User[]> {
    return this.httpClient.get<User[]>(this.url);
  }

  public findById(id: number): Observable<User> {
    let url = this.url + id;
    return this.httpClient.get<User>(url);
  }

  public findByAliasOrEmailLike(search: string): Observable<User[]> {
    return this.httpClient.get<User[]>(this.url + "search/" + search);
  }


  public set connectedUser(connectedUser: User) {
    this._connectedUser = connectedUser;
  }
  public get connectedUser(): User {
    return this._connectedUser;
  }

  public set cookieServ(cookieServ: CookieService) {
    this._cookieServ = cookieServ;
  }
  public get cookieServ(): CookieService {
    return this._cookieServ;
  }


}