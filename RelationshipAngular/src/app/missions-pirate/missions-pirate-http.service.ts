import { Injectable } from '@angular/core';
import { Mission, Statut } from '../models/models';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MissionsPirateHttpService {
  

  m1=new Mission(3,"Retrouver Maurice",2,"Chez Mathias",1,null,null)
  m2=new Mission(4,"Retrouver Maurice",2,"Chez Mathias",1,null,Statut.EnCours)
  m3=new Mission(5,"Retrouver Maurice",2,"Chez Mathias",1,null,Statut.EnCours)

  missions: Array<Mission> = new Array<Mission>(this.m1, this.m2, this.m3);

  constructor(private http : HttpClient) {
  
  }
 
  findAll(): Array<Mission>{
    return this.missions;
  }
}
