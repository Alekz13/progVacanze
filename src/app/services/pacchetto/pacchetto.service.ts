import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, firstValueFrom } from 'rxjs';
import { Pacchetto } from 'src/app/models/pacchetto';

@Injectable({
  providedIn: 'root'
})
export class PacchettoService {
  pacchettoById= "http://localhost:8080/pacchetti/";
  pacchettoByContinente= "http://localhost:8080/pacchetti/continente="
  constructor(private http: HttpClient){ }
  findPacchettoById(id: number): Observable<Pacchetto> {
    const url = this.pacchettoById + id;
    return this.http.get<Pacchetto>(url);
  }
  async getPacchettoById(id: number): Promise<Pacchetto> {
    const url = this.pacchettoById + id;
    const observable = this.http.get<Pacchetto>(url);
    return firstValueFrom(observable);
  }
  findPacchettoByContinente(continente : string): Observable<Pacchetto> {
    const url = this.pacchettoByContinente + continente;
    return this.http.get<Pacchetto>(url);
  }
  async getPacchettoByContinente(continente : string): Promise<Pacchetto> {
    const url = this.pacchettoByContinente + continente;
    const observable = this.http.get<Pacchetto>(url);
    return firstValueFrom(observable);
  }
}
