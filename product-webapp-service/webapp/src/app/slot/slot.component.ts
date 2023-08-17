import { Component } from '@angular/core';
import { Slot } from '../model/slot';
import { SlotformService } from '../slotform.service';

@Component({
  selector: 'app-slot',
  templateUrl: './slot.component.html',
  styleUrls: ['./slot.component.css']
})
export class SlotComponent {


  public newSlot : Slot;
  constructor(private slotformService:SlotformService){
    this.newSlot = new Slot();

  }

  save(data:Slot){
    this.slotformService.save(data).subscribe(d=>console.log("Details saved",d));

  }
  

}
