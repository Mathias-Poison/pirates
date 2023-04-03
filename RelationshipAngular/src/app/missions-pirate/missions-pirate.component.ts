import { Component } from '@angular/core';
import { Mission } from '../models/models';

@Component({
  selector: 'app-missions-pirate',
  templateUrl: './missions-pirate.component.html',
  styleUrls: ['./missions-pirate.component.css']
})
export class MissionsPirateComponent {
  

  m1=new Mission(3,"Retrouver Maurice",2,"Chez Mathias",1,null,null,null)
  missions: Array<Mission> = new Array<Mission>(this.m1);
}
