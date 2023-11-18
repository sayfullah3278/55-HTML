import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AbouteusComponent } from './abouteus.component';

describe('AbouteusComponent', () => {
  let component: AbouteusComponent;
  let fixture: ComponentFixture<AbouteusComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AbouteusComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AbouteusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
