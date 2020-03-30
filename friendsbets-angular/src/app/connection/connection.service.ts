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
  private url: string = "http://localhost:8080/authentication/"

  constructor(private httpClient: HttpClient, private cookieServ: CookieService) {
    // TODO: Remove me !
    if (!this.connectedUser) this.login("Email8", "Password8");
  }

  /**
    * Webservice return the user who is just writted in database.
    * @param m 
    * @param success 
    */
  public register(m: User, success?: () => void): void {
    m.id = undefined;
    let u = Serializer.serializeToJSON(m);
    this.httpClient.post<User>(this.url + "register", u).subscribe(x => {
      // Delete password
      x.password = undefined;
      // Connect use
      this._connectedUser = Serializer.toTypeScriptObject(x, User); 
      success();
    });
  }

  public update(m: User): void {
    // TODO: Verify if serializer is needed
    this.httpClient.put(this.url + "update", m).subscribe(x => this._connectedUser = m);
  }

  /**
   * Delete a user
   * @param m 
   */
  public delete(m: User): void {
    // TODO: Error and succes
    this.httpClient.delete<User>(this.url + "delete/" + m.id).subscribe(x => console.log("delete ok"));
  }

  /**
   * Webservice add a token, writte user in db and return the user.
   * TODO: token
   * @param email 
   * @param password 
   * @param success 
   * @param error 
   */
  public login(email: string, password: string, success?: () => void, error?: () => void) {
    // TODO: token    
    // let token: string = this.cookieServ.get("token");
    return this.httpClient.post<User>(this.url + "login", {}, {
      params: {
        "email": email,
        "password": password,
      }
    }).subscribe(x => {
      if (x) { // server found and return right user
        this.connectedUser = Serializer.toTypeScriptObject(x, User);
        this.cookieServ.set("token", x.token, 10);
        if (success) success();
        //! Remove me !
        console.log("connectedUser = "); 
        console.log(this.connectedUser);
      
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
  //   }, error, success/* , success(this.connectedMember), error() */);
  // }

  public set connectedUser(connectedUser: User) {
    this._connectedUser = connectedUser;
  }
  public get connectedUser(): User {
    return this._connectedUser;
  }


}