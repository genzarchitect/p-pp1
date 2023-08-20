import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private apiUrl = 'http://localhost:8087/User'; // need to add api

  constructor(private http: HttpClient) { }

  getUsers(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/userList`);
  }
    updateUserDetails(user: any): Observable<any> {
      return this.http.put<any>(`${this.apiUrl}/userList/{userEmail}/${user.id}`, user);
    }
  }