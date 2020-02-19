import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user.model';

/**
 *
!!!!!!!!!!!!!! httpClient.subscribe is Asynchrone !!!!!!!!!!!
 *
 *
 * lamda can avoid ?
 *********** json format for UserS in webService
    {
      "jsonType": "User",
      "alias": "jsonPostRestTest",
      "image": null,
      "password": "jsonPostRestTest",
      "email": "jsonPostRestTest@qsdf"
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
  private url: string = "http://localhost:8080/friendsbets-webservice/user/";

  constructor(private httpClient: HttpClient) { }

  public addUser(m: User): void {
    // TODO: Make a serializer
    let s = 
      {
        "jsonType": "User",
        "alias": m.alias,
        //! "picturePath": m.picturePath,
        "password": m.password,
        "email": m.email,
      };
    this.httpClient.post(this.url, s).subscribe();
    
  }

  public update(m: User): void {
    // TODO: Make a serializer
    // TODO: Verify if serializer is needed
    let url2 = this.url + m.id;
    let s = 
    {
      "jsonType": "User",
      "alias": m.alias,
      //! "picturePath": m.picturePath,
      "password": m.password,
      "email": m.email,
    };
    this.httpClient.put(url2, s).subscribe();
  }

  public delete(m: User): void {
    this.httpClient.delete<User>(this.url+m.id).subscribe(x => console.log("delete ok"));
  }

  public findAll():  Observable<User[]> {
    return this.httpClient.get<User[]>(this.url);
  }

  public findById(id: number): Observable<User> {
    let url = this.url + id;
    return this.httpClient.get<User>(url);
  }

  public findByAliasOrEmailLike(search: string): Observable<User[]> {
    return this.httpClient.get<User[]>(this.url+"search/"+search);
  }

  // TODO: Validator
  /*
  	public static final transient Validator<User> VALIDATOR = new Validator<User>()
			.addRule("alias", "Alias \"Pierre\" is not allowed !", 
					me -> !me.getAlias().toLowerCase().equals("pierre"))
			.addRule("alias", "Alias must be at least 8 characters long", 
					me -> me.getAlias().length() >= 8)
			.addRule("email", "invalid email format", 
					me -> me.getEmail().contains("@"))
			.addRule("password", "Password must be at least 8 characters long", 
					me -> me.getPassword().length() >= 8); 
  */

}