import {Injectable} from '@angular/core';

import {HttpClient} from '@angular/common/http';


import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {Problema, ProblemaCreate} from './problema.model';

@Injectable({ providedIn: 'root' })
export class ProblemaService {
  private apiUrl = 'http://localhost:8080/api/problema';

  constructor(private httpClient: HttpClient) {
  }

  getProbleme(): Observable<Problema[]>{
    return this.httpClient.get<Array<Problema>>(this.apiUrl);
  }

  getProblema(id: string): Observable<Problema>{
    return this.httpClient.get<Problema>(this.apiUrl + '/' + id);
  }

  saveProblema(problema: ProblemaCreate): Observable<Problema> {
    return this.httpClient.post<Problema>(this.apiUrl, problema);
  }

  updateProblema(problema: Problema, id: string): Observable<Problema> {
    return this.httpClient.put<Problema>(this.apiUrl + '/' + id, problema);
  }

  deleteProblema(id: string){
    const url = this.apiUrl + '/' + id;
    console.log(url);
    return this.httpClient.request('delete', url, {});
  }
}
