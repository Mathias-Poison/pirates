import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Mission } from '../models/models';
import { MissionsPirateHttpService } from '../missions-pirate/missions-pirate-http.service';

@Component({
  selector: 'app-encherir',
  templateUrl: './encherir.component.html',
  styleUrls: ['./encherir.component.css']
})
export class EncherirComponent {
  constructor(private route: ActivatedRoute, private missionHttpservice : MissionsPirateHttpService) {
    this.route.params.subscribe(params => {
      console.log(params);
    
      });      
  }
  mission= new Mission();

  findById(id: number): Mission {
    return this.missionHttpservice.missions.find(t => t.id == id);
   }
}
