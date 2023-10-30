import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Pacchetto } from 'src/app/models/pacchetto';
import { CatalogoService } from 'src/app/services/catalogo/catalogo.service';

@Component({
  selector: 'app-destinazioni',
  templateUrl: './destinazioni.component.html',
  styleUrls: ['./destinazioni.component.css'],
})
export class DestinazioniComponent implements OnInit {
  constructor(private catalogService: CatalogoService, private route: ActivatedRoute, private router : Router) {}
  continenti = [
    { nome: 'Asia', img: './assets/destinazioni-vid/AsiaVid.mp4' },
    { nome: 'America', img: './assets/destinazioni-vid/AmericaVid.mp4' },
    { nome: 'Africa', img: './assets/destinazioni-vid/AfricaVid.mp4' },
    { nome: 'Europa', img: './assets/destinazioni-vid/EuropaVid.mp4' },
    { nome: 'Oceania', img: './assets/destinazioni-vid/OceaniaVid.mp4' }
  ];
  pacchetti!:any
  pacchettiContinente!: any;
  ngOnInit(): void {
      this.catalogService.getPacchetti().subscribe((dati) => (this.pacchetti = dati));
  }
  pacchettiByContinente(continente : string){
    return this.pacchettiContinente = this.catalogService.getPacchettiByContinente(continente);
  }
}
