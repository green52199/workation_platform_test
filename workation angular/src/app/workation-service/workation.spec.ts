import { TestBed } from '@angular/core/testing';

import { Workation } from './workation';

describe('Workation', () => {
  let service: Workation;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Workation);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
