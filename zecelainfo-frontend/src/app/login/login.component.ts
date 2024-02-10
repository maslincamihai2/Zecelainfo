import { Component } from '@angular/core';
import { AuthenticationService } from '../shared/authentication.service'; // Import your authentication service
import { Router } from '@angular/router';
import { TokenService } from '../token.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  email: string = '';
  parola: string = '';

  constructor(private authService: AuthenticationService, private router: Router, private tokenSerivce: TokenService) { }

  onLogin(): void {
    const credentials = { email: this.email, parola: this.parola };
    this.authService.login(credentials).subscribe({
      next: (response) => {
        console.log('Login successful', response);
        this.tokenSerivce.saveToken(response);
        this.router.navigate(['/probleme']);
        // The token should be saved inside the authService.login method
      },
      error: (error) => {
        console.error('Login failed', error);
      }
    });
  }
}
