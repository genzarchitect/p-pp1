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
  
  
  constructor(private formBuilder: FormBuilder,private userService: UserService) {}
  // user = { userName: 'jai', userEmail: 'abcde',userMobile: '232',userGender: 'm',userAddress: 'bangalore', };
  user: User = new User();
  isEditing = false;

  ngOnInit(): void {
    
    this.userForm = this.formBuilder.group({
      userName: ['', Validators.required],
      userEmail: ['', Validators.email],
      userMobile: ['', Validators.required],
      userGender: ['', Validators.required],
      userAddress: ['', Validators.required]
    });

this.fetchUserDetails();
  }
  fetchUserDetails():void{
    this.userService.getUsers().subscribe(
      (users)=>{
        this.user=users[0];
        this.userForm.patchValue(this.user);
      },
      (error)=>{
        console.error('Error fething user details:',error);
      }
    );
  }
  

  editDetails() {
    
    this.isEditing = true;
  }

  saveDetails() {
    if (this.userForm.valid) {
      this.user={...this.user,...this.userForm.value};
      this.userService.updateUserDetails(this.user).subscribe(
        () => {
          console.log('User details saved:', this.user);
          this.isEditing = false;
        },
        (error: any) => {
          console.error('Error saving user details:', error);
          
        }
      );
    }
  }
  

}

