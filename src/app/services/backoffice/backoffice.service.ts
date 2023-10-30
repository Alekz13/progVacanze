import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { firstValueFrom } from 'rxjs';
import { Meta } from 'src/app/models/meta';
import { Pacchetto } from 'src/app/models/pacchetto';

@Injectable({
  providedIn: 'root'
})
export class BackofficeService {
  apiGetUrl = "http://localhost:8080/pacchetti";
  urlMete= "http://localhost:8080/mete/all"
  urlMeteByCitta= "http://localhost:8080/mete/citta="
  constructor(private http: HttpClient){ }
  addPacchetto(pacchetto: Pacchetto){
    return this.http.post(this.apiGetUrl, pacchetto);
  }
  getMete(){
    return this.http.get(this.urlMete);
  }
  findMetaByCitta(citta: string): Observable<Meta> {
    const url = this.urlMeteByCitta + citta;
    return this.http.get<Meta>(url);
  }
  async getMetaByCitta(citta: string): Promise<Meta> {
    const url = this.urlMeteByCitta + citta;
    const observable = this.http.get<Meta>(url);
    return firstValueFrom(observable);
  }
}
