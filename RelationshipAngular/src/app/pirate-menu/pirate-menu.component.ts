import { Component, Input } from '@angular/core';
import { LoginService } from '../login.service';
import { Compte } from '../models/models';

@Component({
  selector: 'app-pirate-menu',
  templateUrl: './pirate-menu.component.html',
  styleUrls: ['./pirate-menu.component.css']
})
export class PirateMenuComponent {
  constructor(private loginService : LoginService) {

  }
capitaine: Compte = this.loginService.compte;

}
