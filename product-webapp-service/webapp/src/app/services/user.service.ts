import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private apiUrl = 'http://localhost:8002/User'; 
  constructor(private http: HttpClient) { }

  saveDetails(email:String,user: User) :Observable<any[]>{
    return this.http.put<any[]>(`${this.apiUrl}/userList/${email}`, user);
    }
  
  getUserByEmail(UserEmail: String) : Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/userList/${UserEmail}`);
  }

  // updateUserDetails(user: User): Observable<any> {
  //     return this.http.put<any>(`${this.apiUrl}/userList/{userEmail}/${user.userEmail}`, user);
  //   }
  // }
}