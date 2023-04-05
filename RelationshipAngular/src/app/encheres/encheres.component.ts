import { Component } from '@angular/core';
import { Enchere } from '../models/models';
import { EncheresHttpService } from './encheres-http.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-encheres',
  templateUrl: './encheres.component.html',
  styleUrls: ['./encheres.component.css']
})
export class EncheresComponent {


  
  encheres: Array<Enchere> = new Array<Enchere>();

  constructor(private encheresService: EncheresHttpService, private router: Router) {
  
  }
  ngOnInit() {
    this.encheres= this.encheresService.findAll();
  }
}
