import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { GroundService } from '../services/ground.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-ground-owner',
  templateUrl: './ground-owner.component.html',
  styleUrls: ['./ground-owner.component.css'],
})
export class GroundOwnerComponent implements OnInit {
  groundForm: FormGroup | undefined;
  selectedImage: File | null = null;

  constructor(private groundService: GroundService) {}

  ngOnInit() {
    this.initForm();
  }

  initForm() {
    this.groundForm = new FormGroup({
      groundName: new FormControl(null, Validators.required),

      groundEquipments: new FormControl(null, Validators.required),
      groundOwnerEmail: new FormControl(null, [
        Validators.required,
        Validators.email,
      ]),
      status: new FormControl('OPEN', Validators.required),
      categories: new FormControl(null, Validators.required),
      openingTime: new FormControl(null, Validators.required),
      closingTime: new FormControl(null, Validators.required),
      pricePerSlot: new FormControl(null, Validators.required),
    });
  }

  onImageSelected(event: Event) {
    const input = event.target as HTMLInputElement;

    if (input.files && input.files[0]) {
      this.selectedImage = input.files[0];
    }
  }

  addGround() {
    if (this.groundForm?.valid) {
      this.groundService.addGround(this.groundForm.value).subscribe(
        (response) => {
          console.log(response);
          
          if (response && response.groundId && this.selectedImage) {
            this.groundService
              .uploadImage(response.groundId, this.selectedImage)
              .subscribe(
                () => {
                  console.log('Image uploaded successfully');
                  alert('Ground added successfully!');
                },
                (error:any) => console.error('Error uploading image', error)
              );
          } else if (response && response.groundId) {
            alert('Ground added successfully, but no image was uploaded.');
          }
        },
        (error) => {
          console.error('Error adding ground:', error);
        }
      );
    }
  }
}
