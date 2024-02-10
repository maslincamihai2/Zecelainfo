export class Problema {
    id: number;
    nume: string;
    cerinta: string;
    dificultate: string;
    categorie: string;
    subcategorie: string;

    constructor(id: number, nume: string, cerinta: string, dificultate: string, categorie: string, subcategorie: string){
        this.id = id
        this.nume = nume
        this.cerinta = cerinta
        this.dificultate = dificultate
        this.categorie = categorie
        this.subcategorie = subcategorie
    }
  }

  export class ProblemaCreate {
    nume: string;
    cerinta: string;
    dificultate: string;
    categorie: string;
    subcategorie: string;

    constructor(nume: string, cerinta: string, dificultate: string, categorie: string, subcategorie: string){
        this.nume = nume
        this.cerinta = cerinta
        this.dificultate = dificultate
        this.categorie = categorie
        this.subcategorie = subcategorie
    }
  }
  