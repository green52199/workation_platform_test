import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class Workation {
  private apiUrl = 'http://localhost:8080/workflex/workation/get-data-from-csv';
  constructor(private http: HttpClient) {}
  getWorkations(): Observable<any> {
    return this.http.get<any>(this.apiUrl);
  }
}
