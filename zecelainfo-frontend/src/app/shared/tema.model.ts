import { Clasa } from "../probleme/shared/clasa.model";

export class Tema {
  id: number;
  clasa: Clasa;
  nume: string;
  descriere: string;
  dataInceput: string;
  dataSfarsit: string;

  constructor(id: number, clasa: Clasa, nume: string, descriere: string, dataInceput: string, dataSfarsit: string){
      this.id = id
      this.clasa = clasa
      this.nume = nume
      this.descriere = descriere
      this.dataInceput = dataInceput
      this.dataSfarsit = dataSfarsit

  }
}

export class TemaCreate {
  idClasa: number;
  nume: string;
  descriere: string;
  dataInceput: string;
  dataSfarsit: string;

  constructor(idClasa: number, nume: string, descriere: string, dataInceput: string, dataSfarsit: string){
    this.idClasa = idClasa
    this.nume = nume
    this.descriere = descriere
    this.dataInceput = dataInceput
    this.dataSfarsit = dataSfarsit

}
}
