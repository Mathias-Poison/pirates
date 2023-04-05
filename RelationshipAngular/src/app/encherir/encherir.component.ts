import { Component, OnInit } from '@angular/core';
import { NgModule } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Enchere, Mission } from '../models/models';
import { MissionsPirateHttpService } from '../missions-pirate/missions-pirate-http.service';
import { LoginService } from '../login.service';
import { EncheresHttpService } from '../encheres/encheres-http.service';


@Component({
  selector: 'app-encherir',
  templateUrl: './encherir.component.html',
  styleUrls: ['./encherir.component.css']
})
export class EncherirComponent implements OnInit{
  constructor(
    private route: ActivatedRoute, 
    private missionHttpservice : MissionsPirateHttpService, 
    private loginService : LoginService,
    private encheresService: EncheresHttpService,
    private router : Router,

    ) {}
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
    let enchere : Enchere = new Enchere();
    enchere.prix=this.enchereForm;
    enchere.date=new Date(Date.now());
    enchere.capitaine=this.loginService.compte;
    enchere.mission=this.mission;
    this.encheresService.create(enchere);
    console.log(enchere);
    this.router.navigate(['/encheres']);
  }

}
