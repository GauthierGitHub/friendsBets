import { Component, OnInit } from '@angular/core';
import { ConnectionService } from 'src/app/connection/connection.service';
import { User } from 'src/app/models/User.model';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  user: User;

  constructor(private cs: ConnectionService) {
    //! remove me !
    this.user = this.cs.connectedUser == null ?
         new User(-1, "MadeByHeader", "fromMainCompo", "fromMainCompo" ) : this.cs.connectedUser;
   }

  ngOnInit(): void {
  }

}
