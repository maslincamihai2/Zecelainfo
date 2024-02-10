import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TokenService } from './token.service'; // Import your token service

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private tokenService: TokenService) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const authToken = this.tokenService.getToken();
    console.log("AUTH TOKEN " + authToken)
    if (authToken) {
      // Clone the request and replace the original headers with
      // cloned headers, updated with the authorization.
      const authReq = request.clone({
        headers: request.headers.set('Authorization', `${authToken}`)
      });

      // send cloned request with header to the next handler.
      return next.handle(authReq);
    }

    return next.handle(request);
  }
}
