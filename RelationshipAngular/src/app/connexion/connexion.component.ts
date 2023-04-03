import { Component, OnInit } from '@angular/core';
import { CompteHttpService } from '../compte-http.service';
import { Compte } from '../models/models';
import { LoginService } from '../login.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css']
})
export class ConnexionComponent implements OnInit{

  
  loginForm: FormGroup;
  submitted: boolean=false;
  loading: boolean=false;
  constructor(private loginService : LoginService, private formBuilder: FormBuilder){
    
  } 

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
        username: ['', Validators.required],
        password: ['', Validators.required]
    });
  }
  seConnecter() {
    this.loginService.authentifier(this.loginForm.value.username,this.loginForm.value.password);
    }
  
    onSubmit() {
      this.submitted = true
      if (this.loginForm.invalid) {
          return;
      }
      this.loading = true;
    }
}
