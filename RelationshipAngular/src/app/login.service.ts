import { Injectable } from '@angular/core';
import { CompteHttpService } from './compte-http.service';
import { Capitaine, Compte } from './models/models';
import { BehaviorSubject, Observable, map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private currentUserSubject: BehaviorSubject<Compte> = new BehaviorSubject<Compte>(null);
  public connected: Observable<Compte> = this.currentUserSubject.asObservable();
  public cap: Capitaine=null;
  // public cli:Client:null;
  constructor(private httpCompte : CompteHttpService) { }

  authentifier(username:string, password:string) : Observable<Compte> {
    return this.httpCompte.findByLoginAndPassword(username, password).pipe(map(compte => {

      localStorage.setItem('connected', JSON.stringify(compte));
      this.currentUserSubject.next(compte);
      if(compte.type_compte=="capitaine"){
        this.cap.id=compte.id;
      };
      // else if(compte.type_compte=="client"){
      //   this.cli.id=compte.id;
      // };
      return compte;
    }));
  }

}
