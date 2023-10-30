
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import{HttpClientModule} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CatalogoComponent } from '../app/components/catalogo/catalogo.component';
import { PacchettoComponent } from '../app/components/pacchetto/pacchetto.component';
import { FormsModule } from '@angular/forms';
import { BackofficeComponent } from './components/backoffice/backoffice/backoffice.component';
import { MenuComponent } from './components/menu/menu/menu.component';
import { SidebarComponent } from './components/side-bar/sidebar/sidebar.component';
import { PrenotazioneComponent } from './components/prenotazione/prenotazione.component';
import { UtenteComponent } from './components/utente/utente/utente.component';
import { HomeComponent } from './components/home/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { DestinazioniComponent } from './components/destinazioni/destinazioni.component';
import { ContattiComponent } from './components/contatti/contatti.component';
import { TransformPipe } from './transform.pipe';

@NgModule({
  declarations: [
    AppComponent,
    CatalogoComponent,
    PacchettoComponent,
    BackofficeComponent,
    MenuComponent,
    SidebarComponent,
    PrenotazioneComponent,
    UtenteComponent,
    HomeComponent,
    DestinazioniComponent,
    ContattiComponent,
    LoginComponent,
    TransformPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
