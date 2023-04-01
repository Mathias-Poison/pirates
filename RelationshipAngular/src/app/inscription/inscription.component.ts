import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent implements OnInit {

  pirateInscriptionForm: FormGroup;
  pirateLoginCtrl: FormControl;
  pirateEmailCtrl: FormControl;
  piratePasswordCtrl: FormControl;
  piratePasswordConfirmCtrl: FormControl;
  piratePseudonymeCtrl: FormControl;
  pirateDateCtrl: FormControl;

  clientInscriptionForm: FormGroup;
  clientLoginCtrl: FormControl;
  clientEmailCtrl: FormControl;
  clientPasswordCtrl: FormControl;
  clientPasswordConfirmCtrl: FormControl;
  clientNomCtrl: FormControl;
  clientPrenomCtrl: FormControl;
  clientDateCtrl: FormControl;

  constructor(private formBuilder: FormBuilder) {

  }

  ngOnInit(): void {
    this.pirateLoginCtrl = this.formBuilder.control('', Validators.required);
    this.pirateEmailCtrl = this.formBuilder.control('', [Validators.required, Validators.email]);
    this.piratePasswordCtrl = this.formBuilder.control('', [Validators.required, Validators.minLength(8), Validators.pattern('^.*[A-Z]+.*$')]);
    this.piratePasswordConfirmCtrl = this.formBuilder.control('',);
    this.piratePseudonymeCtrl = this.formBuilder.control('', Validators.required);
    this.pirateDateCtrl = this.formBuilder.control('', Validators.required);

    this.clientLoginCtrl = this.formBuilder.control('', Validators.required);
    this.clientEmailCtrl = this.formBuilder.control('', [Validators.required, Validators.email]);
    this.clientPasswordCtrl = this.formBuilder.control('', [Validators.required, Validators.minLength(8), Validators.pattern('^.*[A-Z]+.*$')]);
    this.clientPasswordConfirmCtrl = this.formBuilder.control('',);
    this.clientNomCtrl = this.formBuilder.control('', Validators.required);
    this.clientPrenomCtrl = this.formBuilder.control('', Validators.required);
    this.clientDateCtrl = this.formBuilder.control('', Validators.required);

    this.pirateInscriptionForm = this.formBuilder.group({
      login: this.pirateLoginCtrl,
      email: this.pirateEmailCtrl,
      password: this.piratePasswordCtrl,
      passwordConfirm: this.piratePasswordConfirmCtrl,
      pseudonyme: this.piratePseudonymeCtrl,
      date: this.pirateDateCtrl

    });

    this.clientInscriptionForm = this.formBuilder.group({
      login: this.clientLoginCtrl,
      email: this.clientEmailCtrl,
      password: this.clientPasswordCtrl,
      passwordConfirm: this.clientPasswordConfirmCtrl,
      nom: this.clientNomCtrl,
      prenom: this.clientPrenomCtrl,
      date: this.clientDateCtrl
      
    });

    this.changeTypeCompte("Pirate")
  }


  inscription(type : string) {
    if (type === "Pirate"){
      console.log(this.pirateInscriptionForm.value) //todo send this to db
    }
    else{
      console.log(this.clientInscriptionForm.value)
    }
  }

  changeTypeCompte(type: string) {
    let pirateForm = document.getElementById("pirateForm")
    let clientForm = document.getElementById("clientForm")

    if (type === "Pirate") {
      pirateForm.style.display = "block";
      clientForm.style.display = "none"
    }

    else if (type === "Client") {
      pirateForm.style.display = "none";
      clientForm.style.display = "block";
    }

  }
}