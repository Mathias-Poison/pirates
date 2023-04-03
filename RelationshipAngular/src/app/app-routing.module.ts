import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InscriptionComponent } from './inscription/inscription.component';
import { ConnexionComponent } from './connexion/connexion.component';
import { MainMenuComponent } from './main-menu/main-menu.component';
import { MissionsPirateComponent } from './missions-pirate/missions-pirate.component';

const routes: Routes = [  
{path: "inscription", component: InscriptionComponent},
{path: "connexion", component: ConnexionComponent},
{path: "pirate", component: MainMenuComponent},
{path: "missions-pirate", component: MissionsPirateComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
