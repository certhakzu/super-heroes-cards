import { TestBed } from '@angular/core/testing';

import { TarjetasServiceService } from './tarjetas-service.service';

describe('TarjetasServiceService', () => {
  let service: TarjetasServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TarjetasServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
