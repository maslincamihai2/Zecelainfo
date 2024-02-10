import { Component, OnInit } from '@angular/core';
import { Problema } from './shared/problema.model';
import { ProblemaService } from './shared/problema.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-probleme',
  templateUrl: './probleme.component.html',
  styleUrls: ['./probleme.component.css']
})
export class ProblemeComponent implements OnInit {

    probleme: Problema[];

    constructor(private problemaService: ProblemaService, private router: Router) {this.probleme = [] }
  
    ngOnInit(): void {
      this.problemaService.getProbleme().subscribe(
        probleme => this.probleme = probleme
      );
    }

    navigateToProblem(id: string | number): void { // Define the navigation function
        this.router.navigate(['/problema', id]);
    }

}
