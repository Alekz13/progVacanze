import { Pacchetto } from "./pacchetto";
import { Utente } from "./utente";

export class Prenotazione{
 id:number;
 numPartecipanti : number;
 utente : Utente;
 pacchetto: Pacchetto;
 convalida: boolean;
 prezzoFinale: number;
 giornoPrenotazione: Date;
 assicurazione : boolean;
 constructor(
    numPartecipanti : number,
    utente : Utente,
    pacchetto: Pacchetto,
    convalida: boolean,
    assicurazione : boolean,
 ){
    this.numPartecipanti=numPartecipanti;
    this.utente=utente;
    this.pacchetto=pacchetto;
    this.convalida=convalida;
    this.prezzoFinale=pacchetto.costo*numPartecipanti;
    this.assicurazione=assicurazione
 }
}