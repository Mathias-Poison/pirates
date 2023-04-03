import { Injectable } from '@angular/core';
import { CompteHttpService } from './compte-http.service';
import { Compte } from './models/models';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  compte:Compte | undefined;
  connected: Compte | undefined;
  constructor(private httpCompte : CompteHttpService, private router: Router) { }

  authentifier(login:string, password:string)  {
    this.httpCompte.findByLoginAndPassword(login, password).subscribe((compte: Compte) => {
      if(compte){
        this.connected = compte;
        this.router.navigate(['/pirate']);
      }
      else {
        console.error("Erreur : compte introuvable. Veuillez vérifier votre login et votre mot de passe et réessayer.");
      }
      });
  }

}
