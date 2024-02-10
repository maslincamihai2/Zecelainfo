import { Problema } from "../probleme/shared/problema.model";

export class Solution {
  id: number;
  user: User;
  problema: Problema;
  punctaj: number;
  cod_sursa: string;

  constructor(id: number, user: User, problema: Problema, punctaj: number, cod_sursa: string){
      this.id = id
      this.user = user
      this.problema = problema
      this.punctaj = punctaj
      this.cod_sursa = cod_sursa

  }
}

export class SolutieCreate {
  idProblema: number;
  codSursa: string;

  constructor(idProblema: number, codSursa: string){
      this.idProblema = idProblema
      this.codSursa = codSursa
  }
}

export class User {
  id: number;
  email: string;
  parola: string;
  nume: string;
  prenume: string;
  rol: string;

  constructor(id: number, nume: string, email: string, parola: string, prenume: string, rol: string){
    this.id = id
    this.nume = nume
    this.email = email
    this.parola = parola
    this.prenume = prenume
    this.rol = rol
}
}
