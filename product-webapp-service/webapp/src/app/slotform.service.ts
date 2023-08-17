import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Slot } from './model/slot';

@Injectable({
  providedIn: 'root'
})
export class SlotformService {

  constructor(private http:HttpClient) { }

  public save(slot:Slot){
    return this.http.post("http://localhost:8090/slot/addslot",slot);
  }

}
