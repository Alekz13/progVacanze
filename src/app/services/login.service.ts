import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Utente } from '../models/utente';


@Injectable({
  providedIn: 'root',
})
export class LoginService {
  utenti: Utente[] = [];
  url =
    'https://projectvacanze-default-rtdb.europe-west1.firebasedatabase.app/users.json';
  constructor(private http: HttpClient) {}

  addClienti(body: {}) {
    return this.http.post(this.url, body);
  }

  allClienti() {
    return this.http.get(this.url);
  }
}