import { Injectable } from '@angular/core';
import { CompteHttpService } from './compte-http.service';
import { Compte } from './models/models';
import { BehaviorSubject, Observable, map } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  // private currentUserSubject: BehaviorSubject<Compte> = new BehaviorSubject<Compte>(null);
  // public connected: Observable<Compte> = this.currentUserSubject.asObservable();
  private compte: Compte=null;
  public messageError:string=null;
  constructor(private httpCompte : CompteHttpService, private router: Router) { }

  authentifier(username:string, password:string) {
    
    this.httpCompte.findByLoginAndPassword(username, password).subscribe(
      cmpt => {
        this.compte=cmpt;
        console.log(cmpt); 
        delete cmpt.password;
        sessionStorage.setItem('connected', JSON.stringify(cmpt));
        if(cmpt.type_compte=="capitaine") {
          this.router.navigate(['/pirate-menu']);
        }
        else if (cmpt.type_compte=="client"){
          this.router.navigate(['/missions-client']);
        }
      },
      error => {
        let messageError  = "Aucun compte trouvé avec le login et le password saisis, réessayez !";
       this.messageError=messageError;
       sessionStorage.setItem('error', JSON.stringify(messageError));
      });
    
  }

  public getError(): string {
    if(this.messageError) {
      return this.messageError;
    } else if (sessionStorage.getItem("error")){
      return JSON.parse((sessionStorage.getItem("error")));
    }

    return null;
  }
  
  public getCompte(): Compte {
    if(this.compte) {
      return this.compte;
    } else if (sessionStorage.getItem("connected")){
      return JSON.parse((sessionStorage.getItem("connected")));
    }

    return null;
  }

}
