import { CompteHttpService } from "./compte-http.service";
import { Compte } from "./models/models"

export class Crud {

    compteForm: Compte = null;
  
    constructor(private compteService: CompteHttpService) {
  
    }

list(): Array<Compte> {
    return this.compteService.findAll();
  }

  add(): void {
    this.compteForm = new Compte();
  }

  edit(id: number): void {
    this.compteService.findById(id).subscribe(resp => {
      this.compteForm = resp;
    });
  }

  remove(id: number): void {
    this.compteService.remove(id);
  }

  save(): void {
    if(this.compteForm.id) {
      this.compteService.update(this.compteForm);
    } else {
      this.compteService.create(this.compteForm);
    }
    this.cancel();
  }

  cancel(): void {
    this.compteForm = null;
  }
}
