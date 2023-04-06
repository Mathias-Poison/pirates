import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Compte, Mission } from '../models/models';
import { MissionsClientHttpService } from './missions-client-http.service';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-missions-client',
  templateUrl: './missions-client.component.html',
  styleUrls: ['./missions-client.component.css']
})
export class MissionsClientComponent {
  missions: Array<Mission> = new Array<Mission>();
  
  compte = new Compte;

  constructor(private missionService: MissionsClientHttpService, private router: Router, private loginService : LoginService) {
    if(sessionStorage.getItem("connected")){

    let compteobjet = JSON.parse(sessionStorage.getItem("connected"));
    this.compte.prenom= compteobjet["prenom"];
    this.compte.nom= compteobjet["nom"];
  }
  }
  
  list(): Array<Mission> {
    return this.missionService.findAll().filter(m => m.client.id == this.loginService.getCompte().id);;
  }

    remove (id : number):void {
      this.missionService.remove(id);
    }

  cancel(): void {
    this.missions = null;
  }



}
