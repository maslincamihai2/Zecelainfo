import {Injectable} from '@angular/core';

import {HttpClient} from '@angular/common/http';


import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {SolutieCreate, Solution} from './solution.model';
import { Tema, TemaCreate } from './tema.model';

@Injectable({ providedIn: 'root' })
export class TemaService {
  private apiUrl = 'http://localhost:8080/api/tema';

  constructor(private httpClient: HttpClient) {
  }

  getTeme(): Observable<Tema[]>{
    return this.httpClient.get<Array<Tema>>(this.apiUrl);
  }

  getSolutie(id: string): Observable<Tema>{
    return this.httpClient.get<Tema>(this.apiUrl + '/' + id);
  }

  saveSolutie(tema: TemaCreate): Observable<Tema> {
    return this.httpClient.post<Tema>(this.apiUrl, tema);
  }
}
