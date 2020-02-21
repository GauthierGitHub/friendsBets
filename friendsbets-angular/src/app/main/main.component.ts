import { Component, OnInit } from '@angular/core';
import { User } from '../models/user.model';
import { ConnectionService } from '../connection/connection.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss']
})
export class MainComponent implements OnInit {

  u: User;

  constructor(private cs: ConnectionService) { }

  ngOnInit(): void {

    this.u = this.cs.connectedUser == null ?
         new User(-1, "fromMainCompo", "fromMainCompo", "fromMainCompo" ) : this.cs.connectedUser;
  }

}
