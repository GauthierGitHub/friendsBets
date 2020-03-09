import { Component, OnInit } from '@angular/core';
import { ConnectionService } from 'src/app/connection/connection.service';
import { User } from 'src/app/models/user.model';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  u: User;

  constructor(private cs: ConnectionService) {
    this.u = this.cs.connectedUser == null ?
         new User(-1, "createdByHeaderComponent", "fromMainCompo", "fromMainCompo" ) : this.cs.connectedUser;
   }

  ngOnInit(): void {
  }

}
