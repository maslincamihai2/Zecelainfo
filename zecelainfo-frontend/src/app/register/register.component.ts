import { Component } from '@angular/core';
import { AuthenticationService } from '../shared/authentication.service'; // Adjust the path as necessary
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  email: string = '';
  password: string = '';
  firstName: string = '';
  lastName: string = '';
  role: string = '';

  constructor(private authService: AuthenticationService, private router: Router) { }

  onRegister(): void {
    const user = {
      email: this.email,
      parola: this.password,
      nume: this.firstName,
      prenume: this.lastName,
      rol: this.role
    };
    this.authService.register(user).subscribe({
      next: (response) => {
        console.log('Registration successful', response);
        this.router.navigate(['/login']);
        // Optional: Redirect after successful registration or handle as needed
      },
      error: (error) => {
        console.error('Registration failed', error);
      }
    });
  }
}
