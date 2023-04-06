import { Component, OnInit } from '@angular/core';
import { Enchere } from '../models/models';
import { EncheresHttpService } from './encheres-http.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-encheres',
  templateUrl: './encheres.component.html',
  styleUrls: ['./encheres.component.css']
})
export class EncheresComponent implements OnInit{


  
  encheres: Array<Enchere> = new Array<Enchere>();

  constructor(private encheresService: EncheresHttpService, private router: Router) {
  
  }
  ngOnInit() {
    this.encheres= this.encheresService.findAll();
    console.log(this.encheres);
  }
 
    list(): Array<Enchere> {
      return this.encheresService.findAll();
    }
  }

