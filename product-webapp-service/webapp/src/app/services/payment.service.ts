import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PaymentService {
  private baseURL = 'http://localhost:8089/api/v1';

  constructor(private http: HttpClient) {}

  createPayment(amount: number): Observable<any> {
    const url = `${this.baseURL}/payment?amount=${amount}`;
    return this.http.post<any>(url, null);
  }
}
