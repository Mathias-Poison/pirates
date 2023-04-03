export class Compte {

    id: number;
    age: number;
    login: string;
    password: string;
    type_compte: string;

    constructor(id?: number, age?: number, login?: string, password?: string, type_compte?: string) {
        this.id = id;
        this.age = age;
        this.login = login;
        this.password = password;
        this.type_compte = type_compte;
    }
}
export class Capitaine extends Compte {

    pseudonyme: string;
    tauxReussite: number;
    missions: Array<Mission>;
    //encheres: Array<Enchere>;

    constructor(id?: number, age?: number, login?: string, password?: string, type_compte?: string, pseudonyme?: string, tauxReussite?: number, missions?: Array<Mission>) {
        super(id, age, login, password, type_compte);

        this.pseudonyme = pseudonyme;
        this.tauxReussite = tauxReussite;
        this.missions = missions;
       // this.encheres = encheres;
    }
}

export class Mission{
    id: number;
    libelle: string;
    duree: number;
    lieu: string;
    difficulte:number;
    date: Date;
    capitaine: Capitaine;
    //client:Client;
    //enchere:Array<Enchere>;
    statut:Statut;
    //bateau:Bateau;

    constructor(id?: number, libelle?: string, duree?: number, lieu?: string, difficulte?:number,date?: Date,capitaine?: Capitaine,statut?:Statut) {
        this.id = id;
        this.libelle = libelle;
        this.duree=duree;
        this.lieu=lieu;
        this.difficulte=difficulte;
        this.date=date;
        this.capitaine=capitaine;
        //this.client=client;
        //this.enchere=enchere;
        this.statut=statut;
        //this.bateau=bateau;

    }
}

export enum Statut{
    EnAttente,EnCours,Termine
}

