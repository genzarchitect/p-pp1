import { Component, OnInit } from '@angular/core';
import { GroundService } from '../services/ground.service';
import { ActivatedRoute } from '@angular/router';
import { Ground } from '../model/ground';
import { Slot } from '../model/slot'; // Include the slot model you've created
import { PaymentService } from '../services/payment.service';
import { PaymentDetails } from '../model/paymentDetails';
declare var Razorpay: any;
@Component({
  selector: 'app-arena-details',
  templateUrl: './arena-details.component.html',
  styleUrls: ['./arena-details.component.css'],
})
export class ArenaDetailsComponent implements OnInit {
  groundId: string | null = null;
  ground: Ground | null = null;
  allSlots: Slot[] = [];
  selectedSlot: Slot | null = null;
  selectedDate: Date = new Date();

  constructor(
    private route: ActivatedRoute,
    private groundService: GroundService,
    private paymentService: PaymentService
  ) {}

  ngOnInit(): void {
    this.groundId = this.route.snapshot.paramMap.get('id')!;
    this.loadGroundDetails();
    this.selectedDate = new Date();
    this.loadAvailableSlots();
  }

  loadGroundDetails(): void {
    if (this.groundId !== null) {
      this.groundService.getGroundById(this.groundId).subscribe((data) => {
        this.ground = data;
      });
    }
  }

  onDateChange(event: any) {
    if (event.value) {
      this.selectedDate = event.value;
      this.selectedSlot = null;
      this.loadAvailableSlots();
    }
  }

  loadAvailableSlots(): void {
    if (this.groundId && this.selectedDate) {
      const formattedDate = this.selectedDate.toLocaleDateString('en-CA');
      console.log(formattedDate);
      this.groundService
        .getSlotsByDateForGround(this.groundId, formattedDate)
        .subscribe(
          (slots: Slot[]) => {
            this.allSlots = slots.length ? slots : [];
          },
          (error) => {
            console.error('Error fetching slots:', error);
            this.allSlots = [];
          }
        );
    }
  }

  public getImageUrl(groundId?: string): string {
    return this.groundService.getGroundImageUrl(groundId);
  }

  selectSlot(slot: Slot): void {
    if (slot.numberOfPlayers && slot.numberOfPlayers > 0) {
      this.selectedSlot = slot;
    } else {
      alert('This slot is fully booked.');
    }
  }

  bookSlot(): void {
    if (this.selectedSlot && this.selectedSlot.slotId) {
      this.groundService.bookSlot(this.selectedSlot.slotId).subscribe(
        (response) => {
          // alert('Slot booked successfully!');
          const amount = this.ground?.pricePerSlot
            ? this.ground.pricePerSlot
            : 0;
          this.initiatePayment(amount);
          this.loadAvailableSlots();
        },
        (error) => {
          alert('Failed to book slot. Try again later.');
        }
      );
    }
  }
  isSlotBooked(slot: Slot): boolean {
    return slot.numberOfPlayers === 0;
  }
  initiatePayment(amount: number): void {
    this.paymentService.createPayment(amount).subscribe(
      (response) => {
        console.log(response);
        if (response && response.id) {
          console.log(response.amount);
          const options = {
            key: 'rzp_test_Ga4sXAOK2JGGgr',
            amount: response.amount,
            currency: response.currency,
            name: 'Ground Arena Name',
            description: 'Booking Payment',
            order_id: response.id,
            handler: (res: any) => {
              let paymentDetails: PaymentDetails = {
                paymentId: res.razorpay_payment_id,
                amount: res.amount / 100,
                currency: res.currency,
                status: res.status,
                orderId: res.razorpay_order_id,
                paymentMethod: res.method,
                customerEmail: res.email,
                customerName: res.name,
                paymentCreatedAt: new Date(),
                transactionTime: new Date(),
              };
              this.paymentService.savePaymentDetails(paymentDetails).subscribe(
                (success) => console.log('Payment details saved.'),
                (error) => console.error('Error saving payment details:', error)
              );
            },
            prefill: {
              name: '', //details from user or your app's session
              email: '',
            },
            theme: {
              color: '#F37254',
            },
          };
          const rzp1 = new Razorpay(options);
          rzp1.open();
        }
      },
      (error) => {
        console.error('Error initiating payment:', error);
      }
    );
  }
}
