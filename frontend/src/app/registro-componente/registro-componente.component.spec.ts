import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistroComponenteComponent } from './registro-componente.component';

describe('RegistroComponenteComponent', () => {
  let component: RegistroComponenteComponent;
  let fixture: ComponentFixture<RegistroComponenteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegistroComponenteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegistroComponenteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
