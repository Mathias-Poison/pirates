import { Injectable } from '@angular/core';
import { CompteHttpService } from './compte-http.service';
import { Compte } from './models/models';
import { BehaviorSubject, Observable, map } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  // private currentUserSubject: BehaviorSubject<Compte> = new BehaviorSubject<Compte>(null);
  // public connected: Observable<Compte> = this.currentUserSubject.asObservable();
  public compte: Compte=null;
  // public cli:Client:null;
  constructor(private httpCompte : CompteHttpService, private router: Router) { }

  authentifier(username:string, password:string) {
    this.httpCompte.findByLoginAndPassword(username, password).subscribe(
      cmpt => {
        this.compte=cmpt;
        console.log(cmpt); // Utiliser la valeur de compte ici
        delete cmpt.password;
        sessionStorage.setItem('connected', JSON.stringify(cmpt));
        if(cmpt.type_compte=="capitaine") {
          this.router.navigate(['/missions-pirate']);
        }
        else if (cmpt.type_compte=="client"){
          this.router.navigate(['/missions-client']);
        }
      });
  }

}
