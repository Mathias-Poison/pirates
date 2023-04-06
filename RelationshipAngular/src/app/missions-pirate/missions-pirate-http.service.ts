import { Injectable } from '@angular/core';
import { Mission, Statut } from '../models/models';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MissionsPirateHttpService {
  

  missions: Array<Mission> = new Array<Mission>();

  private missionApiPath: string;

  constructor(private http : HttpClient) {
    this.missionApiPath = "http://localhost:8080/api" + "/mission";
    this.load();
  }
 

  findById(id: number): Observable<Mission> {
    return this.http.get<Mission>("http://localhost:8080/api/mission" + "/" + id);
  }
  findAll(): Array<Mission>{
    return this.missions;
  }

  private load(): void {
  this.http.get<Array<Mission>>(this.missionApiPath).subscribe(resp => {
      this.missions = resp;
  })
}
}
