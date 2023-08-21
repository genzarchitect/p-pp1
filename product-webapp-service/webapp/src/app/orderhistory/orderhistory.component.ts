import { Component } from '@angular/core';
import { Booking } from '../model/booking';
import { BookingserviceService } from '../bookingservice.service';

@Component({
  selector: 'app-orderhistory',
  templateUrl: './orderhistory.component.html',
  styleUrls: ['./orderhistory.component.css']
})
export class OrderhistoryComponent {

  public allbookings:Booking;
 constructor(private bookingService:BookingserviceService){
  this.allbookings = new Booking(); 
  
  this.getBooking();

  
 }

 getBooking(){
  this.bookingService.getAllBookings("annanya@gmail.com").subscribe(
    (data)=>{
      console.log(data);
      this.allbookings=data;
    },
    (error)=>{
      console.log("error");
    },
  );
 }


}
