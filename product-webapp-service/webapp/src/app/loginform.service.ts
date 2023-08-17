import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Login } from './model/login';

@Injectable({
  providedIn: 'root'
})
export class LoginformService {

  constructor(private http:HttpClient) { }

  public save(login:Login){
    return this.http.post("http://localhost:8000/arena/login",login);
  }

}
