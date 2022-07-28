import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AutencicacionModuloComponent } from './autencicacion-modulo.component';

describe('AutencicacionModuloComponent', () => {
  let component: AutencicacionModuloComponent;
  let fixture: ComponentFixture<AutencicacionModuloComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AutencicacionModuloComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AutencicacionModuloComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
