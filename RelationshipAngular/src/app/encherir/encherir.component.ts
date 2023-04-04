import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Mission } from '../models/models';
import { MissionsPirateHttpService } from '../missions-pirate/missions-pirate-http.service';

@Component({
  selector: 'app-encherir',
  templateUrl: './encherir.component.html',
  styleUrls: ['./encherir.component.css']
})
export class EncherirComponent implements OnInit{
  constructor(private route: ActivatedRoute, private missionHttpservice : MissionsPirateHttpService) {}
  mission: Mission=null;

  private id:number;
  

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.id = params['id'];
      this.mission = this.missionHttpservice.missions.find(m => m.id == this.id);
      console.log(this.id);
      console.log(this.mission);
    }); 
  }

}
