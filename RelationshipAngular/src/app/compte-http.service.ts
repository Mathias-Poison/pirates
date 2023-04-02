import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Capitaine, Compte } from './models/models';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CompteHttpService {
  private comptes: Array<Compte> = new Array<Compte>();
  private capitaines: Array<Capitaine> = new Array<Capitaine>();
  compte:any;
  // private clients: Array<Client> = new Array<Client>();
  constructor(private http: HttpClient) { }

  findAll(): Array<Compte>{
    return this.comptes;
  }

  
  findByLoginAndPassword(login: string, password:string){
    return this.http.post<Compte>("http://localhost:8080/api/compte", {login,password})
  }

}
