import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DestinazioniComponent } from './destinazioni.component';

describe('DestinazioniComponent', () => {
  let component: DestinazioniComponent;
  let fixture: ComponentFixture<DestinazioniComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DestinazioniComponent]
    });
    fixture = TestBed.createComponent(DestinazioniComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
