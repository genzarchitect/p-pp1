import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import{UserService} from '../services/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  userForm!: FormGroup;
  constructor(private formBuilder: FormBuilder,private userService: UserService) {}

  ngOnInit(): void {
    this.userForm = this.formBuilder.group({});
  }

  user = { userName: 'jai', userEmail: 'ab',userMobile: '232',userGender: 'm',userAddress: 'bangalore', };
  isEditing = false;

  

  editDetails() {
    
    this.isEditing = true;
  }

  saveDetails() {
    if (this.userForm.valid) {
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
