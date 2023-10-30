import { Pacchetto } from 'src/app/models/pacchetto';
import { BackofficeService } from './../../../services/backoffice/backoffice.service';
import { Component, OnInit } from '@angular/core';
import { Meta } from 'src/app/models/meta';
import {NgForm} from '@angular/forms'
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-backoffice',
  templateUrl: './backoffice.component.html',
  styleUrls: ['./backoffice.component.css']
})
export class BackofficeComponent implements OnInit {
  nome!: string;
  descrizione!: string;
  meta!: string;
  costo!: number;
  disponibilita!: number;
  vaccino!: boolean;
  passaporto!: boolean;
  giornoPartenza!: Date;
  giornoRitorno!: Date;
  img!: string;
  mete: any;
  meto! : Meta;
  constructor(private backOfficeService: BackofficeService, private router : Router) {}
  ngOnInit(): void {
    this.backOfficeService.getMete().subscribe((meteList) => (this.mete = meteList));
    console.log(this.backOfficeService.getMete())
  }
  async addPacchetto() {
    this.meto = await this.backOfficeService.getMetaByCitta(this.meta)
    const nuovoPacchetto: Pacchetto = new Pacchetto(
      this.nome,
      this.descrizione,
      this.meto,
      this.costo,
      this.disponibilita,
      this.vaccino,
      this.passaporto,
      this.giornoPartenza,
      this.giornoRitorno,
      this.img
    );
    this.backOfficeService
      .addPacchetto(nuovoPacchetto)
      .subscribe((dati) => console.log(dati));
      console.log(this.meta)
      console.log(this.meto);
      this.router.navigateByUrl("catalogo");
      
  }
}
