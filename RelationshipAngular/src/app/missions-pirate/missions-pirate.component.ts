import { Component } from '@angular/core';
import { Mission } from '../models/models';
import { MissionsPirateHttpService } from './missions-pirate-http.service';

@Component({
  selector: 'app-missions-pirate',
  templateUrl: './missions-pirate.component.html',
  styleUrls: ['./missions-pirate.component.css']
})
export class MissionsPirateComponent {
  

  m1=new Mission(3,"Retrouver Maurice",2,"Chez Mathias",1,null,null,null)
  m2=new Mission(4,"Retrouver Maurice",2,"Chez Mathias",1,null,null,null)
  m3=new Mission(5,"Retrouver Maurice",2,"Chez Mathias",1,null,null,null)

  missions: Array<Mission> = new Array<Mission>(this.m1, this.m2, this.m3);

  constructor(private missionService: MissionsPirateHttpService) {
  
  }
  list(): Array<Mission> {
    return this.missionService.findAll();
  }
}
