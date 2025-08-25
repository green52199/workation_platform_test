import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { WorkationTableComponent } from './workation-table/workation-table';
import { HttpClient } from '@angular/common/http';
import { HttpClientModule } from '@angular/common/http';
@Component({
  selector: 'app-root',
  imports: [ RouterOutlet, CommonModule, WorkationTableComponent, HttpClientModule],
  templateUrl: './app.html',
  styleUrls: ['./app.css']
})
export class App {
  protected readonly title = signal('Workation Platform');
  showFetchData = signal(false);

  toggleFetchData = () => {
    this.showFetchData.update(value => !value);
  };
}
