import { Component, OnInit } from '@angular/core';
import { Enchere } from '../models/models';
import { EncheresHttpService } from './encheres-http.service';
import { Router } from '@angular/router';
import { NgFor } from '@angular/common';
import { LoginService } from '../login.service';
import { MissionsPirateHttpService } from '../missions-pirate/missions-pirate-http.service';

@Component({
  selector: 'app-encheres',
  templateUrl: './encheres.component.html',
  styleUrls: ['./encheres.component.css']
})
export class EncheresComponent{


  
  

  constructor(private encheresService: EncheresHttpService, private router: Router, private loginService : LoginService, private missionService: MissionsPirateHttpService) {
  
  }
 
  list(): Array<Enchere> {

    console.log( this.loginService.getCompte);


    return this.encheresService.findAll().filter(e => e.capitaine.id == this.loginService.getCompte().id);

  }
  remove(id : number): void{
    this.encheresService.remove(id);
  }
  rencherir(enchId : number, missId: number): void {
    this.remove(enchId);
    this.router.navigate(['/encherir', missId]);
  }
}