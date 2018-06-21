import { TestBed, inject } from '@angular/core/testing';

import { StewardServiceService } from './steward-service.service';

describe('StewardServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [StewardServiceService]
    });
  });

  it('should be created', inject([StewardServiceService], (service: StewardServiceService) => {
    expect(service).toBeTruthy();
  }));
});
