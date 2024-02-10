export class Clasa {
    id: number;
    nume: string;
    nivel: string;
    judet: string;
    localitate: string;
    unitateScolara: string;

    constructor(id: number, nume: string, nivel: string, judet: string, localitate: string, unitateScolara: string){
        this.id = id
        this.nume = nume
        this.nivel = nivel
        this.judet = judet
        this.localitate = localitate
        this.unitateScolara = unitateScolara
    }
  }

  export class ClasaCreate {
    nume: string;
    nivel: string;
    judet: string;
    localitate: string;
    unitateScolara: string;

    constructor(nume: string, nivel: string, judet: string, localitate: string, unitateScolara: string){
        this.nume = nume
        this.nivel = nivel
        this.judet = judet
        this.localitate = localitate
        this.unitateScolara = unitateScolara
    }
  }
  