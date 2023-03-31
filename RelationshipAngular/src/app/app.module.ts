import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ConnexionComponent } from './connexion/connexion.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { MainMenuComponent } from './main-menu/main-menu.component';
import { PirateMenuComponent } from './pirate-menu/pirate-menu.component';
import { MissionsPirateComponent } from './missions-pirate/missions-pirate.component';
import { EncherePirateComponent } from './enchere-pirate/enchere-pirate.component';
import { EncherirComponent } from './encherir/encherir.component';

@NgModule({
  declarations: [
    AppComponent,
    ConnexionComponent,
    InscriptionComponent,
    MainMenuComponent,
    PirateMenuComponent,
    MissionsPirateComponent,
    EncherePirateComponent,
    EncherirComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
