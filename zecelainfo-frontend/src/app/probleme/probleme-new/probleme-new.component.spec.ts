import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProblemeNewComponent } from './probleme-new.component';

describe('ProblemeNewComponent', () => {
  let component: ProblemeNewComponent;
  let fixture: ComponentFixture<ProblemeNewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProblemeNewComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ProblemeNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
