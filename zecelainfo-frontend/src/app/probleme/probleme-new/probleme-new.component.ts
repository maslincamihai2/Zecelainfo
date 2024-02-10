import { Component } from '@angular/core';
import { ProblemaService } from '../shared/problema.service';
import { Router } from '@angular/router';
// Import any services you need to submit the problema data

@Component({
  selector: 'app-probleme-new',
  templateUrl: './probleme-new.component.html',
  styleUrls: ['./probleme-new.component.css']
})
export class ProblemeNewComponent {
  problema = {
    nume: '',
    cerinta: '',
    dificultate: '',
    categorie: '',
    subcategorie: ''
  };

  constructor(private problemaService: ProblemaService, private router: Router) {}


  onSubmit(): void {

    this.problemaService.saveProblema(this.problema).subscribe();
    this.router.navigate(['/probleme']);
    // Logic to submit the 'problema' data, e.g., call a service method
    console.log(this.problema);
    // After successful creation, you might want to navigate away or give feedback
  }
}
