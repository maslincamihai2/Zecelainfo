import {Injectable} from '@angular/core';

import {HttpClient} from '@angular/common/http';


import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {SolutieCreate, Solution} from './solution.model';
import { Tema, TemaCreate } from './tema.model';

@Injectable({ providedIn: 'root' })
export class UserClasaService {
  private apiUrl = 'http://localhost:8080/api/user-clasa';

  constructor(private httpClient: HttpClient) {
  }

  save(entity: {idUser: number, idClasa: number}): Observable<{idUser: number, idClasa: number}> {
    return this.httpClient.post<{idUser: number, idClasa: number}>(this.apiUrl, entity);
  }
}
