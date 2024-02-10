import {Injectable} from '@angular/core';

import {HttpClient} from '@angular/common/http';


import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {SolutieCreate, Solution} from './solution.model';

@Injectable({ providedIn: 'root' })
export class SolutieService {
  private apiUrl = 'http://localhost:8080/api/solutie';

  constructor(private httpClient: HttpClient) {
  }

  getSolutii(): Observable<Solution[]>{
    return this.httpClient.get<Array<Solution>>(this.apiUrl);
  }

  getSolutie(id: string): Observable<Solution>{
    return this.httpClient.get<Solution>(this.apiUrl + '/' + id);
  }

  saveSolutie(solutie: SolutieCreate): Observable<Solution> {
    return this.httpClient.post<Solution>(this.apiUrl, solutie);
  }
}
