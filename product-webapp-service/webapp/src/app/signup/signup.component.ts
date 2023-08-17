import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { SignupformService } from '../signupform.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit{
  type:string="password";
  isText:boolean=false;
  eyeIcon:string="fa-eye-slash";

  public newUser : User;
  constructor(private signupformService:SignupformService){
    this.newUser = new User();

  }

  ngOnInit(): void {
    
  }

  save(data:User){
    this.signupformService.save(data).subscribe(d=>console.log("Details saved"));

  }
  hideShowPass(){
    this.isText=!this.isText;
    this.isText ? this.eyeIcon = "fa-eye" : this.eyeIcon = "fa-eye-slash";
    this.isText ? this.type = "text" : this.type = "password";

  }

  addUser (ngform : any){
    console.log(ngform);
  }



}
