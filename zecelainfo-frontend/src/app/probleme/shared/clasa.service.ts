import {Injectable} from '@angular/core';

import {HttpClient} from '@angular/common/http';


import {Observable} from 'rxjs';
import { Clasa, ClasaCreate } from './clasa.model';

@Injectable({ providedIn: 'root' })
export class ClasaService {
  private apiUrl = 'http://localhost:8080/api/clasa';

  constructor(private httpClient: HttpClient) {
  }

  getClase(): Observable<Clasa[]>{
    return this.httpClient.get<Array<Clasa>>(this.apiUrl);
  }

  getClasa(id: string): Observable<Clasa>{
    return this.httpClient.get<Clasa>(this.apiUrl + '/' + id);
  }

  saveClasa(clasa: ClasaCreate): Observable<Clasa> {
    return this.httpClient.post<Clasa>(this.apiUrl, clasa);
  }

  updateClasa(clasa: Clasa, id: string): Observable<Clasa> {
    return this.httpClient.put<Clasa>(this.apiUrl + '/' + id, clasa);
  }

  deleteClasa(id: string){
    const url = this.apiUrl + '/' + id;
    console.log(url);
    return this.httpClient.request('delete', url, {});
  }
}
