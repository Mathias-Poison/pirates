import { Component } from '@angular/core';
import { CompteHttpService } from '../compte-http.service';
import { Compte } from '../models/models';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css']
})
export class ConnexionComponent {
  login: string;
  password: string;
 
  constructor(private loginService : LoginService){
    
  } 

  seConnecter() {
    this.loginService.authentifier(this.login,this.password);
    }
}
