import { Component, OnInit } from '@angular/core';
import { FriendsService } from '../friends.service';
import { User } from 'src/app/models/user.model';
import { ConnectionService } from 'src/app/connection/connection.service';

@Component({
  selector: 'app-add-friends',
  templateUrl: './add-friends.component.html',
  styleUrls: ['./add-friends.component.scss']
})
export class AddFriendsComponent implements OnInit {

  users: User[];

  constructor(private fs: FriendsService, private cs : ConnectionService) { }

  ngOnInit(): void {
  //   this.fs.findAllOthers(this.cs.connectedUser).subscribe( x => {
  //     this.users = x;
  //     }
  //   )
    this.fs.findAllOthers(this.cs.connectedUser).subscribe( x => this.users = x);
    console.log(this.fs);
    
  }


}
