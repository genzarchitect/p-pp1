import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import{UserService} from '../services/user.service';
import { User } from '../model/user';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  userForm!: FormGroup;
  public  user: User= new User();
  public newUser : any[]=[];
  userEmail:String| null = null;
  
  isEditing = false;

  constructor(private formBuilder: FormBuilder,private userService: UserService) {}
  


  ngOnInit(): void {
    
    this.userForm = this.formBuilder.group({
      userName: ['', Validators.required],
      userEmail: ['', Validators.email],
      userMobile: ['', Validators.required],
      userGender: ['', Validators.required],
      userAddress: ['', Validators.required]
    });
  
    this.userService.getUserByEmail("abc@gmail.com").subscribe((data:any)=>{
      console.log(data);
      data.forEach((element:any) => {
        this.newUser.push(element);
        console.log(this.newUser);       
      });
    })
  }
  

  editDetails() {
    
    this.isEditing = true;
  }

  getUserByEmail(UserEmail:String){
  {
    this.userService.getUserByEmail(UserEmail).subscribe((data: any)=>
    console.log("User names",data));
  }
  }
  
  saveDetails(data:User) {
    this.userService.saveDetails(data).subscribe((d: any)=>
    console.log("Details saved",d));

    
  }
  

}


