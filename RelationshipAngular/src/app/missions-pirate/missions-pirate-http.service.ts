import { Injectable } from '@angular/core';
import { Mission } from '../models/models';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MissionsPirateHttpService {
  missions : Array<Mission>= new Array<Mission>();

  constructor(private http : HttpClient) {
  
  }
 
  findAll(): Array<Mission>{
    return this.missions;
  }
}
