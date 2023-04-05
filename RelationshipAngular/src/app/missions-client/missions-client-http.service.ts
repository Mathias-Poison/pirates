import { Injectable } from '@angular/core';
import { Mission, Statut } from '../models/models';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MissionsClientHttpService {
  
  missions: Array<Mission> = new Array<Mission>();

  private missionApiPath: string;

  constructor(private http : HttpClient) {
    this.missionApiPath = "http://localhost:8080/api" + "/mission";
    this.load();
  }
 
  findAll(): Array<Mission>{
    return this.missions;
  }

  create(mission: Mission): void {
    this.http.post<Mission>(this.missionApiPath, mission).subscribe(resp => {
      this.load();
   }); 
  }

private load(): void {
  this.http.get<Array<Mission>>(this.missionApiPath).subscribe(resp => {
      this.missions = resp;
  })
}
}
