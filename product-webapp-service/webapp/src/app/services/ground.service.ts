import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Ground } from '../model/ground';
import { Slot } from '../model/slot';

@Injectable({
  providedIn: 'root',
})
export class GroundService {
  private baseURL = 'http://localhost:8087/api/v1';
  private slotbaseURL = 'http://localhost:8090/slot';

  constructor(private http: HttpClient) {}

  getAllGrounds(): Observable<Ground[]> {
    return this.http.get<Ground[]>(`${this.baseURL}/allgrounds`);
  }

  // in ground.service.ts
  getGroundImageUrl(groundId?: string): string {
    if (!groundId) return ''; //  empty string if no groundId is provided.
    return `${this.baseURL}/ground/image/${groundId}`;
  }


  getGroundById(groundId: string): Observable<Ground> {
    return this.http.get<Ground>(`${this.baseURL}/groundId/${groundId}`);
  }

  // Add a new ground
  addGround(ground: Ground): Observable<any> {
    return this.http.post<string>(`${this.baseURL}/addground`, ground);
  }

  getSlotsByDateForGround(groundId: string, date: string): Observable<Slot[]> {
    return this.http.get<Slot[]>(
      `${this.slotbaseURL}/ground/${groundId}/date/${date}`
    );
  }

  getAllSlots(): Observable<any> {
    return this.http.get(`${this.slotbaseURL}/slot/slotList`);
  }

  bookSlot(slotId: number): Observable<any> {

    return this.http.post(`${this.slotbaseURL}/slot/book/${slotId}`, {});
  }
}
