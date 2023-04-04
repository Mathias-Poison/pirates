import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InscriptionComponent } from './inscription/inscription.component';
import { ConnexionComponent } from './connexion/connexion.component';
import { MainMenuComponent } from './main-menu/main-menu.component';
import { MissionsPirateComponent } from './missions-pirate/missions-pirate.component';
import { EncherirComponent } from './encherir/encherir.component';
import { PirateMenuComponent } from './pirate-menu/pirate-menu.component';

const routes: Routes = [  
{path: "inscription", component: InscriptionComponent},
{path: "connexion", component: ConnexionComponent},
{path: "menu", component: MainMenuComponent},
{path: "missions-pirate", component: MissionsPirateComponent},
{path: "encherir/:id", component: EncherirComponent},
{path: "pirate-menu", component: PirateMenuComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
