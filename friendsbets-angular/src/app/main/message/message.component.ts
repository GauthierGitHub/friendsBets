import { Component, OnInit } from '@angular/core';
import { trigger, state, style, transition, animate } from '@angular/animations';
import { ActivatedRoute, Router, ParamMap } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { GroupsService } from '../group/groups.service';
import { Group } from 'src/app/models/group.model';

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.scss'],
  animations: [
    trigger('Grow', [
      state('inactive', style({
        transform: 'scale(0.1)'
      })),
      state('active', style({
        transform: 'scale(1)'
      })),
      transition('inactive => active', animate('800ms ease-in')),
    ])
  ]
})
export class MessageComponent implements OnInit {

  group: Group;

  constructor(private router: Router
    , private aRoute: ActivatedRoute
    , private gs: GroupsService) { }

  ngOnInit() {
    let id = this.aRoute.snapshot.paramMap.get('group-id');
    this.gs.findById(id).subscribe(x => this.group = x);
    // this.group = this.aRoute.paramMap.pipe(
    //   switchMap((params: ParamMap) =>
    //     this.gs.findById(params.get('id')))
    // );
  }

}
