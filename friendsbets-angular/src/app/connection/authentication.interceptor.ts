import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ConnectionService } from './connection.service';

@Injectable()
export class AuthenticationInterceptor implements HttpInterceptor {

  //cs : ConnectionService;

    constructor(private cs: ConnectionService) {
    //   this.cs = cs;
     }

    /**
     * Add map Authorization: <token>
     * @param request 
     * @param next 
     */
    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        if (this.cs.isConnected()) {
            request = request.clone({
                setHeaders: { 
                    Authorization: this.cs.connectedUser.token
                }
            });
        }
        return next.handle(request);
    }
}