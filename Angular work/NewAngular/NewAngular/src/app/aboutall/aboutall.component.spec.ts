import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AboutallComponent } from './aboutall.component';

describe('AboutallComponent', () => {
  let component: AboutallComponent;
  let fixture: ComponentFixture<AboutallComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AboutallComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AboutallComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
