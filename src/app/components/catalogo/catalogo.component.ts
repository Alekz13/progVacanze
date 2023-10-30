import { Pacchetto } from './../../models/pacchetto';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Prenotazione } from 'src/app/models/prenotazione';
import { Utente } from 'src/app/models/utente';
import { CatalogoService } from 'src/app/services/catalogo/catalogo.service';
@Component({
  selector: 'catalogo',
  templateUrl: './catalogo.component.html',
  styleUrls: ['./catalogo.component.css']
})
export class CatalogoComponent implements OnInit {
  constructor(private catalogo: CatalogoService, private route: ActivatedRoute, private router : Router) {}
  pacchetti: any;
  pacchetto : Pacchetto;
  isPacchetto : boolean;
  numPartecipanti:number = 1;
  utente : Utente = new Utente("Gino", "Rossi", "ginorossi@gmail.com", "123", 333890462, 0,false,true, null);
 convalida!: boolean;
 prezzoFinale!: number;
 giornoPrenotazione!: Date;
 assicurazione! : boolean;
  ngOnInit(): void {
     this.isPacchetto = !this.route.snapshot.paramMap.get('id') ? false : true;
    if (this.route.snapshot.paramMap.get('id')){
      this.isPacchetto = true
      this.catalogo
      .findPacchettoById(parseInt(this.route.snapshot.paramMap.get('id')!)).subscribe((data) =>(this.pacchetto = data));
      console.log(this.pacchetto);
    }else{
      this.isPacchetto = false
      this.catalogo
      .getPacchetti()
      .subscribe((dati) => (this.pacchetti = dati));
    }
    console.log(this.pacchetti);
}
nuovoPacchetto(){
this.router.navigateByUrl("nuovoPacchetto");
}
addPrenotazione(){
  const nuovaPrenotazione : Prenotazione = new Prenotazione(
 this.numPartecipanti,
 this.utente,
 this.pacchetto,
 this.convalida,
 this.assicurazione
  );
  this.catalogo.addPrenotazione(nuovaPrenotazione).subscribe((dati) => console.log(dati));
}
calcolaCostoTotale() {
  let costoBase = this.pacchetto.costo * this.numPartecipanti;
  if (this.assicurazione) {
    costoBase *= 1.05;
  }
  return costoBase.toFixed(2);
}

}

