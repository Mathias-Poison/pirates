import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Mission } from '../models/models';
import { MissionsClientHttpService } from './missions-client-http.service';

@Component({
  selector: 'app-missions-client',
  templateUrl: './missions-client.component.html',
  styleUrls: ['./missions-client.component.css']
})
export class MissionsClientComponent {
  missions: Array<Mission> = new Array<Mission>();

  constructor(private missionService: MissionsClientHttpService, private router: Router) {
  
  }
  ngOnInit() {
    this.missions= this.missionService.findAll();
  }

  list(): Array<Mission> {
    return this.missionService.findAll();
  }

  // add(): void {
  //   this.missions = new Mission()
    
  // }

  // save(): void {
  //     this.missionService.create(this.missions);
  //   this.cancel();
  // }

  cancel(): void {
    this.missions = null;
  }
}
