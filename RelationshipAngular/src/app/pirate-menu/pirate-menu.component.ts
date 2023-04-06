import { Component, Input } from '@angular/core';
import { LoginService } from '../login.service';
import { Compte } from '../models/models';

@Component({
  selector: 'app-pirate-menu',
  templateUrl: './pirate-menu.component.html',
  styleUrls: ['./pirate-menu.component.css']
})
export class PirateMenuComponent {

  compte = new Compte;

  constructor() {

    if(sessionStorage.getItem("connected")){

      let compteobjet = JSON.parse(sessionStorage.getItem("connected"));
      this.compte.age= compteobjet["age"];
      this.compte.pseudonyme= compteobjet["pseudonyme"];
      

    }
  
  }

}
