import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PacchettoComponent } from './pacchetto.component';

describe('PacchettoComponent', () => {
  let component: PacchettoComponent;
  let fixture: ComponentFixture<PacchettoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PacchettoComponent]
    });
    fixture = TestBed.createComponent(PacchettoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
