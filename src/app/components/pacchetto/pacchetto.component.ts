import { Component } from '@angular/core';
import { Pacchetto } from 'src/app/models/pacchetto';
import { PacchettoService } from 'src/app/services/pacchetto/pacchetto.service';

@Component({
  selector: 'app-pacchetto',
  templateUrl: './pacchetto.component.html',
  styleUrls: ['./pacchetto.component.css']
})
export class PacchettoComponent {
  constructor(private catalogo: PacchettoService) {}
  pacchetto!: Pacchetto
  async crea(id : number): Promise<Pacchetto> {
    return this.pacchetto = await this.catalogo
    .getPacchettoById(id);
    console.log(this.pacchetto);
}
}