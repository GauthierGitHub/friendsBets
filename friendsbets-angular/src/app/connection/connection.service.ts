import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/User.model';
import { Serializer } from '../models/serializer/Serializer';
import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class ConnectionService {

  private _connectedUser: User;
  private url: string = "http://localhost:8080/"

  constructor(private httpClient: HttpClient, private cookieServ: CookieService) {
    // TODO: Remove me !
    if (!this.connectedUser) this.login("Email8", "Password8");
    
  }

  /**
    * webservice return the user in database
    * @param m 
    * @param success 
    */
  public addUser(m: User, success?: () => void): void {
    m.id = undefined;
    let u = Serializer.serializeToJSON(m);
    this.httpClient.post<User>(this.url + "user/", u).subscribe(x => {
      this._connectedUser = x;
      success();
    });
  }

  public update(m: User): void {
    // TODO: Verify if serializer is needed
    let url2 = this.url + "user/" + m.id;
    this.httpClient.put(url2, m).subscribe(x => this._connectedUser = m);
  }

  public delete(m: User): void {
    this.httpClient.delete<User>(this.url + "user/" + m.id).subscribe(x => console.log("delete ok"));
  }

  public login(email: string, password: string, success?: () => void, error?: () => void) {
    // TODO: token
    // let token: string = this.cookieServ.get("token");
    return this.httpClient.post<User>(this.url + "authentication/login", {}, {
      params: {
        "email": email,
        "password": password,
      }
    }).subscribe(x => {
      if (x) { // server found and return right user
        this.connectedUser = x;
        this.cookieServ.set("token", x.token, 10);
        if (success) success();
      }
      else { // server has returned null
        // TODO: error
        console.log("server has returned null");
        console.log("user not found");
      }
    }, error); // no server response
  }

  // version André
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
    return this.httpClient.get<User[]>(this.url + "user/");
  }

  public findById(id: number): Observable<User> {
    let url = this.url + "user/" + id;
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


}