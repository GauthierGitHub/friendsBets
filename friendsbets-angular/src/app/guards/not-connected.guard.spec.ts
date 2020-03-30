import { TestBed, async, inject } from '@angular/core/testing';

import { NotConnectedGuard } from './not-connected.guard';

describe('NotConnectedGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [NotConnectedGuard]
    });
  });

  it('should ...', inject([NotConnectedGuard], (guard: NotConnectedGuard) => {
    expect(guard).toBeTruthy();
  }));
});
