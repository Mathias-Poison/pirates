import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Enchere } from '../models/models';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EncheresHttpService {

 
  constructor(private http: HttpClient) { 
    this.load();
  }
  
  encheres: Array<Enchere> = new Array<Enchere>();
  enchere:any;

  findAll(): Array<Enchere>{
    return this.encheres;
  }

  findById(id: number): Observable<Enchere> {
    return this.http.get<Enchere>("http://localhost:8080/api/enchere" + "/" + id);
  }

  create(enchere: Enchere): void {
    this.http.post<Enchere>("http://localhost:8080/api/enchere", enchere).subscribe(resp => {
      this.load();
    });
  }

  update(enchere: Enchere): void {
    this.http.put<Enchere>("http://localhost:8080/api/enchere" + "/" +  enchere.id, enchere).subscribe(resp => {
      this.load();
    });
  }

  remove(id: number): void {
    this.http.delete<boolean>("http://localhost:8080/api/enchere" + "/" + id).subscribe(resp => {
      this.load();
    });
  }

  private load(): void {
    this.http.get<Array<Enchere>>("http://localhost:8080/api/enchere").subscribe(resp => {
        this.encheres = resp;
    })
  }
}
