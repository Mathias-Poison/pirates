import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ConnexionComponent } from './connexion/connexion.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { MainMenuComponent } from './main-menu/main-menu.component';
import { PirateMenuComponent } from './pirate-menu/pirate-menu.component';
import { MissionsPirateComponent } from './missions-pirate/missions-pirate.component';
import { EncherirComponent } from './encherir/encherir.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ConnexionHttpService } from './connexion/connexion-http.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { CompteHttpService } from './compte-http.service';
import { AccueilComponent } from './accueil/accueil.component';
import { ClientMenuComponent } from './client-menu/client-menu.component';
import { MissionsClientComponent } from './missions-client/missions-client.component';
import { EncheresComponent } from './encheres/encheres.component';
import { ErreurComponent } from './erreur/erreur.component';

@NgModule({
  declarations: [
    AppComponent,
    ConnexionComponent,
    InscriptionComponent,
    MainMenuComponent,
    PirateMenuComponent,
    MissionsPirateComponent,
    EncherirComponent,
    AccueilComponent,
    ClientMenuComponent,
    MissionsClientComponent,
    EncheresComponent,
    ErreurComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [ConnexionHttpService,HttpClient,CompteHttpService],
  bootstrap: [AppComponent]
})
export class AppModule { }
