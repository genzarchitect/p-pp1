import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dropdown',
  templateUrl: './dropdown.component.html',
  styleUrls: ['./dropdown.component.css']
})


export class DropdownComponent implements OnInit{
  options: any[] = [];
  selectedOption: any;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchData();
  }
  
  fetchData(): void {
    this.http.get<any[]>('http://localhost:8087/api/v1/allgrounds').subscribe(
      (data) => {
        this.options = data;
      },
      (error) => {
        console.error('Error fetching data:', error);
      }
    );
  }

}
