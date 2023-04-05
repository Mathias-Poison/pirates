import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Compte } from './models/models';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CompteHttpService {
  private comptes: Array<Compte> = new Array<Compte>();
  //private capitaines: Array<Capitaine> = new Array<Capitaine>();
  compte:any;
  // private clients: Array<Client> = new Array<Client>();
  constructor(private http: HttpClient) { }

  findAll(): Array<Compte>{
    return this.comptes;
  }

  findByLoginAndPassword(login: string, password:string) : Observable<Compte>{
    return this.http.get<Compte>("http://localhost:8080/api/compte/connexion/"+ login + "/" + password);
  }

  findById(id: number): Observable<Compte> {
    return this.http.get<Compte>("http://localhost:8080/api/compte" + "/" + id);
  }

  create(compte: Compte): void {
    this.http.post<Compte>("http://localhost:8080/api/compte", compte).subscribe(resp => {
      console.log(resp)
      this.load();
    });
  }

  update(compte: Compte): void {
    this.http.put<Compte>("http://localhost:8080/api/compte" + "/" +  compte.id, compte).subscribe(resp => {
      this.load();
    });
  }

  remove(id: number): void {
    this.http.delete<boolean>("http://localhost:8080/api/compte" + "/" + id).subscribe(resp => {
      this.load();
    });
  }

  private load(): void {
    this.http.get<Array<Compte>>("http://localhost:8080/api/compte").subscribe(resp => {
        this.comptes = resp;
    })
  }
}
