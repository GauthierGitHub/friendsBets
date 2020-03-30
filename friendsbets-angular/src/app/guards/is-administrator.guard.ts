import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { ConnectionService } from '../connection/connection.service';

@Injectable({
  providedIn: 'root'
})
export class IsAdministratorGuard implements CanActivate {

  constructor(private cs: ConnectionService) {
    this.cs = cs;
  }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    // return this.cs.isConnected() && this.cs.connectedUser.hasRole("Administrator");
    return null;
  }
  
}
