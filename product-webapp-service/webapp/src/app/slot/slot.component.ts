import { Component, OnInit } from '@angular/core';
import { Ground } from '../model/ground';
import { Slot } from '../model/slot';
import { SlotformService } from '../slotform.service';

@Component({
  selector: 'app-slot',
  templateUrl: './slot.component.html',
  styleUrls: ['./slot.component.css']
})
export class SlotComponent implements OnInit{


  public newSlot : Slot;
  public newGround : any[]=[];
  constructor(private slotformService:SlotformService){
    this.newSlot = new Slot();


  }


  ngOnInit(): void {
    this.slotformService.getGroundByEmail("shiksha@gmail.com").subscribe((data:any)=>{
      console.log(data);
      data.forEach((element:any) => {
        this.newGround.push(element);
        console.log(this.newGround);       
      });
    })


    
  }

  save(data:Slot){
    this.slotformService.save(data).subscribe(d=>console.log("Details saved",d));

  }

  getGroundByEmail(groundOwnerEmail:string){
    this.slotformService.getGroundByEmail(groundOwnerEmail).subscribe(data=>console.log("Ground names",data));
  }
  

}
