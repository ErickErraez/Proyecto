import { TestBed } from '@angular/core/testing';

import { EnterateService } from './enterate.service';

describe('EnterateService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: EnterateService = TestBed.get(EnterateService);
    expect(service).toBeTruthy();
  });
});
