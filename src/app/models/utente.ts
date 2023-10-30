import { Prenotazione } from "./prenotazione";

export class Utente{
    id: number;
    nome : string;
    cognome: string;
    emailAddress: string;
    password: string;
    phoneNumber: number;
    promoCounter: number;
    admin: boolean;
    enabled: boolean;
    dataDiNascita: Date;
    prenotazioni: Array<Prenotazione>

    constructor(
    nome : string,
    cognome: string,
    emailAddress: string,
    password: string,
    phoneNumber: number,
    promoCounter: number,
    admin: boolean,
    enabled: boolean,
    dataDiNascita: Date,
    ){
        this.nome=nome;
        this.cognome=cognome;
        this.emailAddress=emailAddress;
        this.password=password;
        this.phoneNumber=phoneNumber;
        this.promoCounter=promoCounter;
        this.admin=admin;
        this.enabled=enabled;
        this.dataDiNascita=dataDiNascita;
    }
}