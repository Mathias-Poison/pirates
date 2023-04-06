import { Component, OnInit } from '@angular/core';
import { Enchere } from '../models/models';
import { EncheresHttpService } from './encheres-http.service';
import { Router } from '@angular/router';
import { NgFor } from '@angular/common';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-encheres',
  templateUrl: './encheres.component.html',
  styleUrls: ['./encheres.component.css']
})
export class EncheresComponent implements OnInit{


  
  encheres: Array<Enchere> = new Array<Enchere>();

  constructor(private encheresService: EncheresHttpService, private router: Router, private loginService : LoginService) {
  
  }
  ngOnInit() {
    this.encheres= this.encheresService.findAll();
    console.log(this.encheres);
  }

  list(): Array<Enchere> {
    this.encheres.length = 0; 
    let varEnchere: Array<Enchere> = this.encheresService.findAll();
    for (let e of varEnchere) {
      if (e.capitaine.id == this.loginService.compte.id) {
        this.encheres.push(e);
      }
    }
    return this.encheres;

  }

}