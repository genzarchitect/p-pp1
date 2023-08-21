import { Component } from '@angular/core';
import { BookingserviceService } from '../bookingservice.service';
import { Booking } from '../model/booking';

@Component({
  selector: 'app-ownerhistory',
  templateUrl: './ownerhistory.component.html',
  styleUrls: ['./ownerhistory.component.css']
})
export class OwnerhistoryComponent {
  public allbookings:Booking;
  constructor(private bookingService:BookingserviceService){
   this.allbookings = new Booking(); 
   
   this.getBooking();
 
   
  }
 
  getBooking(){
   this.bookingService.getAllBookings("ad@gmail.com").subscribe(
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
 
 
