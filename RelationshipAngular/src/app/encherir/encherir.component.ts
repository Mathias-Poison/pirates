import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Enchere, Mission } from '../models/models';
import { MissionsPirateHttpService } from '../missions-pirate/missions-pirate-http.service';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-encherir',
  templateUrl: './encherir.component.html',
  styleUrls: ['./encherir.component.css']
})
export class EncherirComponent implements OnInit{
  constructor(private route: ActivatedRoute, private missionHttpservice : MissionsPirateHttpService, private loginService : LoginService) {}
  mission: Mission=null;
  enchere: Enchere=null;
  enchereForm: number;
  private id:number;
  

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.id = params['id'];
      this.mission = this.missionHttpservice.missions.find(m => m.id == this.id);
      console.log(this.id);
      console.log(this.mission);
    }); 
  }
  encherir(){
    this.enchere.prix=this.enchereForm;
    this.enchere.date=new Date(Date.now());
    this.enchere.capitaine=this.loginService.cap;
    this.enchere.mission=this.mission;
    
  }

}
