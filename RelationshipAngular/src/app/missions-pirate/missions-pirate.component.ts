import { Component } from '@angular/core';
import { Mission } from '../models/models';
import { Statut } from '../models/models';
import { MissionsPirateHttpService } from './missions-pirate-http.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-missions-pirate',
  templateUrl: './missions-pirate.component.html',
  styleUrls: ['./missions-pirate.component.css']
})
export class MissionsPirateComponent {
  

  m1=new Mission(3,"Retrouver Maurice",2,"Chez Mathias",1,null,null)
  m2=new Mission(4,"Retrouver Maurice",2,"Chez Mathias",1,null,Statut.EnCours)
  m3=new Mission(5,"Retrouver Maurice",2,"Chez Mathias",1,null,Statut.EnCours)

  missions: Array<Mission> = new Array<Mission>(this.m1, this.m2, this.m3);

  constructor(private missionService: MissionsPirateHttpService, private router: Router) {
  
  }
  list(): Array<Mission> {
    return this.missionService.findAll();
  }

  encherir(id: number){
    this.router.navigate(['/encherir/', id]);
  }
}
