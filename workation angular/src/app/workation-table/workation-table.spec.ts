import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WorkationTableComponent } from './workation-table';

describe('WorkationTable', () => {
  let component: WorkationTableComponent;
  let fixture: ComponentFixture<WorkationTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [WorkationTableComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WorkationTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
