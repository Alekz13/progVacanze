import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PacchettoComponent } from './components/pacchetto/pacchetto.component';
import { CatalogoComponent } from './components/catalogo/catalogo.component';
import { BackofficeComponent } from './components/backoffice/backoffice/backoffice.component';
import { HomeComponent } from './components/home/home/home.component';
import { DestinazioniComponent } from './components/destinazioni/destinazioni.component';
import { ContattiComponent } from './components/contatti/contatti.component';
import { LoginComponent } from './components/login/login.component';
import { MenuComponent } from './components/menu/menu/menu.component';

const routes: Routes = [
  {path: "", redirectTo:"home", pathMatch: 'full'},
  {path: 'pacchetti/:id', component: CatalogoComponent},
  {path: 'catalogo', component: CatalogoComponent},
  {path: 'nuovoPacchetto', component: BackofficeComponent},
  {path: 'home', component: HomeComponent},
  {path: 'destinazioni', component: DestinazioniComponent},
  {path: 'contatti', component: ContattiComponent},
  {path:'utenti/login', component: LoginComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
