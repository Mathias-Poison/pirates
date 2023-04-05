import { Component } from '@angular/core';
import { Mission } from '../models/models';
import { MissionsPirateHttpService } from './missions-pirate-http.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-missions-pirate',
  templateUrl: './missions-pirate.component.html',
  styleUrls: ['./missions-pirate.component.css']
})
export class MissionsPirateComponent {
  missions: Array<Mission> = new Array<Mission>();

  constructor(private missionService: MissionsPirateHttpService, private router: Router) {
  
  }
  ngOnInit() {
    this.missions= this.missionService.findAll();
  }

 
}
