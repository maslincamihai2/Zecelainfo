import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { TokenService } from '../token.service'; // Import your token service

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private loginUrl = 'http://localhost:8080/api/users/login'; // Adjust the URL based on your API

  constructor(private http: HttpClient, private tokenService: TokenService) { }

  login(credentials: { email: string; parola: string; }): Observable<any> {
    return this.http.post(this.loginUrl, credentials).pipe(
      tap((response: any) => {console.log(response);this.tokenService.saveToken(response.token)}) // Assuming the token is in the 'token' field
    );
  }

  private registerUrl = 'http://localhost:8080/api/users/register'; // Adjust the URL based on your API

  register(user: { email: string; parola: string; nume: string; prenume: string; rol: string; }): Observable<any> {
    console.log(user)
    return this.http.post(this.registerUrl, user);
  }
}
