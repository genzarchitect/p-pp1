import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { LoginformService } from '../loginform.service';
import { Login } from '../model/login';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  type:string="password";
  isText:boolean=false;
  eyeIcon:string="fa-eye-slash";
  
  public newLogin : Login;
  constructor(private loginformService:LoginformService){
    this.newLogin = new Login();

  }
  ngOnInit(): void {
        
  }

  save(data:Login){
    this.loginformService.save(data).subscribe(d=>console.log("Details saved"));

  }

  hideShowPass(){
    this.isText=!this.isText;
    this.isText ? this.eyeIcon = "fa-eye" : this.eyeIcon = "fa-eye-slash";
    this.isText ? this.type = "text" : this.type = "password";

  }



}
