import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Problema } from '../shared/problema.model';
import { ProblemaService } from '../shared/problema.service';
import { SolutieService } from '../../shared/solution.service';
import { Solution } from '../../shared/solution.model';

@Component({
  selector: 'app-probleme',
  templateUrl: './probleme-detail.component.html',
  styleUrls: ['./probleme-detail.component.css']
})
export class ProblemaDetailComponent implements OnInit {

    problema: Problema = {
        categorie: '',
        subcategorie: '',
        nume: '',
        cerinta: '',
        id: 0,
        dificultate: ''
    };

    sourceCode = ""
    userSolutions: Solution[] = []

    constructor(
        private problemaService: ProblemaService, 
        private router: Router, 
        private route: ActivatedRoute,
        private solutionService: SolutieService) {}
  
    ngOnInit(): void {
        this.route.paramMap.subscribe(params => {
            const id: string = params.get('id')!;
            this.problemaService.getProblema(id).subscribe(
                problema => this.problema = problema
            );

            this.solutionService.getSolutii().subscribe(
                solutions => this.userSolutions = solutions.filter(solution => solution.problema.id == this.problema.id)
            )
        });

    }

    submitSolution(): void {
        this.solutionService.saveSolutie({idProblema: this.problema.id, codSursa: this.sourceCode}).subscribe({
        next: (response) => {
            console.log('Solution submitted successfully', response);
            // Handle successful submission, e.g., clear the textarea, show a success message, etc.
            this.sourceCode = '';
        },
        error: (error) => {
            console.error('Failed to submit solution', error);
            // Handle submission error, e.g., show an error message
        }
        });
        
      }

    deleteProblem(): void { // Define the navigation function
        this.problemaService.deleteProblema(this.problema.id.toString()).subscribe();
        this.router.navigate(['/probleme']);
    }
}
