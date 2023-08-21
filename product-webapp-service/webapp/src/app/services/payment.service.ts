import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PaymentDetails } from '../model/paymentDetails';

@Injectable({
  providedIn: 'root',
})
export class PaymentService {
  private baseURL = 'http://localhost:8054/api/v1';

  constructor(private http: HttpClient) {}

  createPayment(amount: number): Observable<any> {
    return this.http.post(`${this.baseURL}/payment/${amount}`, null);
  }

  savePaymentDetails(paymentDetails: PaymentDetails): Observable<any> {
    return this.http.post(
      `${this.baseURL}/savepaymentresponse`,
      paymentDetails
    );
  }
}
