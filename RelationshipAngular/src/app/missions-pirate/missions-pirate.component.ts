import { Component } from '@angular/core';
import { Compte, Mission } from '../models/models';
import { MissionsPirateHttpService } from './missions-pirate-http.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-missions-pirate',
  templateUrl: './missions-pirate.component.html',
  styleUrls: ['./missions-pirate.component.css']
})
export class MissionsPirateComponent {
  
  missions: Array<Mission> = new Array<Mission>();

  compte = new Compte;

  constructor(private missionService: MissionsPirateHttpService, private router: Router) {
  
    if(sessionStorage.getItem("connected")){

      let compteobjet = JSON.parse(sessionStorage.getItem("connected"));
      this.compte.pseudonyme= compteobjet["pseudonyme"];
      

    }
    
  }
  ngOnInit() {
    this.missions= this.missionService.findAll();
  }

  list(): Array<Mission> {
    return this.missionService.findAll();
  }
  
}
