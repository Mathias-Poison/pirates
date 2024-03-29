import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Compte } from '../models/models';
import { CompteHttpService } from '../compte-http.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css'],
  providers:[CompteHttpService]
})
export class InscriptionComponent implements OnInit {

  //capitaineInscriptionForm: Capitaine =null;

  capitaineInscriptionForm: FormGroup;
  capitaineLoginCtrl: FormControl;
  capitaineEmailCtrl: FormControl;
  capitainePasswordCtrl: FormControl;
  capitainePasswordConfirmCtrl: FormControl;
  capitainePseudonymeCtrl: FormControl;
  capitaineAgeCtrl: FormControl;

  clientInscriptionForm: FormGroup;
  clientLoginCtrl: FormControl;
  clientEmailCtrl: FormControl;
  clientPasswordCtrl: FormControl;
  clientPasswordConfirmCtrl: FormControl;
  clientNomCtrl: FormControl;
  clientPrenomCtrl: FormControl;
  clientAgeCtrl: FormControl;
  

  constructor(private formBuilder: FormBuilder, private compteHttpService: CompteHttpService, private router: Router) {

  }

  ngOnInit(): void {
    this.capitaineLoginCtrl = this.formBuilder.control('', Validators.required);
    this.capitaineEmailCtrl = this.formBuilder.control('', [Validators.required, Validators.email]);
    this.capitainePasswordCtrl = this.formBuilder.control('', [Validators.required, Validators.minLength(8), Validators.pattern('^.*[A-Z]+.*$')]);
    this.capitainePasswordConfirmCtrl = this.formBuilder.control('',);
    this.capitainePseudonymeCtrl = this.formBuilder.control('', Validators.required);
    this.capitaineAgeCtrl = this.formBuilder.control('', Validators.required);

    this.clientLoginCtrl = this.formBuilder.control('', Validators.required);
    this.clientEmailCtrl = this.formBuilder.control('', [Validators.required, Validators.email]);
    this.clientPasswordCtrl = this.formBuilder.control('', [Validators.required, Validators.minLength(8), Validators.pattern('^.*[A-Z]+.*$')]);
    this.clientPasswordConfirmCtrl = this.formBuilder.control('',);
    this.clientNomCtrl = this.formBuilder.control('', Validators.required);
    this.clientPrenomCtrl = this.formBuilder.control('', Validators.required);
    this.clientAgeCtrl = this.formBuilder.control('', Validators.required);

    this.capitaineInscriptionForm = this.formBuilder.group({
      login: this.capitaineLoginCtrl,
      email: this.capitaineEmailCtrl,
      password: this.capitainePasswordCtrl,
      passwordConfirm: this.capitainePasswordConfirmCtrl,
      pseudonyme: this.capitainePseudonymeCtrl,
      age: this.capitaineAgeCtrl

    });

    this.clientInscriptionForm = this.formBuilder.group({
      login: this.clientLoginCtrl,
      email: this.clientEmailCtrl,
      password: this.clientPasswordCtrl,
      passwordConfirm: this.clientPasswordConfirmCtrl,
      nom: this.clientNomCtrl,
      prenom: this.clientPrenomCtrl,
      age: this.clientAgeCtrl
      
    });

    this.changeTypeCompte("Capitaine")
  }


  inscription(type : string) {
    if (type === "Capitaine"){
      console.log(this.capitaineInscriptionForm.value)

      let cap : Compte = new Compte();
      
          cap.login = this.capitaineInscriptionForm.value.login;
          cap.password = this.capitaineInscriptionForm.value.password;
          cap.age = this.capitaineInscriptionForm.value.age;
          cap.pseudonyme = this.capitaineInscriptionForm.value.pseudonyme;
          cap.email = this.capitaineInscriptionForm.value.email;
          cap.type_compte = "capitaine";
          this.compteHttpService.create(cap);
          this.router.navigate(['/connexion']);
    }
    else if (type === "Client"){
      console.log(this.clientInscriptionForm.value)

      let cli : Compte = new Compte();

      cli.login = this.clientInscriptionForm.value.login;
      cli.password = this.clientInscriptionForm.value.password;
      cli.age = this.clientInscriptionForm.value.age;
      cli.nom = this.clientInscriptionForm.value.nom;
      cli.prenom = this.clientInscriptionForm.value.prenom;
      cli.email = this.clientInscriptionForm.value.email;
      cli.type_compte = "client";
      this.compteHttpService.create(cli);
      this.router.navigate(['/connexion']);

    }
  }

  changeTypeCompte(type: string) {
    let capitaineForm = document.getElementById("capitaineForm")
    let clientForm = document.getElementById("clientForm")

    if (type === "Capitaine") {
      capitaineForm.style.display = "block";
      clientForm.style.display = "none"
    }

    else if (type === "Client") {
      capitaineForm.style.display = "none";
      clientForm.style.display = "block";
    }

  }
}