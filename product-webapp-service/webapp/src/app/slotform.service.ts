import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Slot } from './model/slot';

@Injectable({
  providedIn: 'root'
})
export class SlotformService {

  constructor(private http:HttpClient) { }

  public save(slot:Slot){
    return this.http.post("http://localhost:8003/slot/addslot",slot);
  }

  public getGroundByEmail(groundOwnerEmail:string)
  {
    return this.http.get("http://localhost:8001/api/v1/ground/"+groundOwnerEmail);
  }

}
