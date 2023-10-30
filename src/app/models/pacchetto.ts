import { Meta } from "./meta";

export class Pacchetto{
     id! : number;
	 nome!: String; 
     descrizione!: String; 
	 costo!: number;
	 disponibilita!: number;
	 passaporto!: boolean;
     vaccino!: boolean;
	 giornoPartenza!: Date;
     giornoRitorno!: Date;
	 meta!: Meta;
   img!:string
     constructor(
        nome: string,
        descrizione: string,
        meta: Meta,
        costo: number,
        disponibilita: number,
        vaccino: boolean,
        passaporto: boolean,
        giornoPartenza: Date,
        giornoRitorno: Date,
        img: string
      ){
        this.nome = nome;
        this.descrizione = descrizione;
        this.meta = meta;
        this.costo = costo;
        this.disponibilita = disponibilita;
        this.vaccino = vaccino;
        this.passaporto = passaporto;
        this.giornoPartenza = giornoPartenza;
        this.giornoRitorno = giornoRitorno;
        this.img = img;
      }
}