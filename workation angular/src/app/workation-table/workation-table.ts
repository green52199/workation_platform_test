import { Component, OnInit } from '@angular/core';
import { Workation } from '../workation-service/workation';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-workation-table',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './workation-table.html',
  styleUrls: ['./workation-table.css']
})
export class WorkationTableComponent implements OnInit {
  workations : any = [];
  displayedColumns: string[] = ['workationId','employee', 'origin', 'destination', 'start', 'end', 'workingDays', 'risk'];

  constructor(private workationService: Workation) {}

  ngOnInit(): void {
    this.workationService.getWorkations().subscribe((data) => {
      this.workations = data;
    });
  }

  // Sorting function
  sortBy(column: string): void {
    this.workations = [...this.workations].sort((a, b) => {
      if (a[column] < b[column]) return -1;
      if (a[column] > b[column]) return 1;
      return 0;
    });
  }
}
