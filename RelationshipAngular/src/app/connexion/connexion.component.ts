import { Component } from '@angular/core';
import { CompteHttpService } from '../compte-http.service';
import { Compte } from '../models/models';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css']
})
export class ConnexionComponent {
  login: string;
  password: string;
  compte:Compte | undefined;
  constructor(private httpCompte : CompteHttpService){
    
  } 

  seConnecter() {
    this.httpCompte.findByLoginAndPassword(this.login, this.password).subscribe((compte: Compte) => {
    this.compte = compte;
    });
    }
}