import { Component, Injectable, OnInit } from '@angular/core';
import { CompteHttpService } from '../compte-http.service';
import { Compte } from '../models/models';
import { LoginService } from '../login.service';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { Router } from '@angular/router';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css'],
})


export class ConnexionComponent implements OnInit{



  loginForm: FormGroup;
  usernameCtrl:FormControl;
  passwordCtrl: FormControl;
  submitted: boolean=false;
  constructor(private loginService : LoginService, private formBuilder: FormBuilder, private router: Router){

  } 

  ngOnInit() {

    this.usernameCtrl=this.formBuilder.control('', Validators.required);
    this.passwordCtrl=this.formBuilder.control('', Validators.required);
    this.loginForm = this.formBuilder.group({
        username: this.usernameCtrl,
        password: this.passwordCtrl
    });
    }


  onSubmit() {
      this.submitted = true
      if (this.loginForm.invalid) {
          return;
      }

      this.loginService.authentifier(this.loginForm.get('username').value,this.loginForm.get('password').value);
     
    }
}