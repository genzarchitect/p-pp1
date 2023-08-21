import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Booking } from './model/booking';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BookingserviceService {
  private booking_api_url:string="http://localhost:8003/booking/getplemail";
  constructor(private httpClient:HttpClient) { }

  getAllBookings(playerEmail:string):Observable<Booking>{
    
    return this.httpClient.get<Booking>(`${this.booking_api_url}/${playerEmail}`);
  }

}

