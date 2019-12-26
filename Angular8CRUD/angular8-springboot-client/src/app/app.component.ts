import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Students Service';

  constructor(private router:Router){}

  StudentList(){
    this.router.navigate(["students"])
  }
  AddStudent(){
    this.router.navigate(["add"]);
  }
}


