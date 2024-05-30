import { Component } from '@angular/core';
import { ConfigService } from '../service/service';
import { Course } from '../Entity/course';
import {  Router } from '@angular/router';
import { LoginSetData } from '../utility/utility';

@Component({
  selector: 'app-root',
  templateUrl: './dash-board.component.html',
  styleUrl: './dash-board.component.css'
})
export class DashBoardComponent {
  courseImgPath : String = "";
  courses : Course[] = [];
  constructor(private configService: ConfigService ,private router: Router ) {
    if(!window.isLogin){
      this.router.navigate(['/']);
    }
   }

  ngOnInit(): void {
    this.configService.getData("http://localhost:8080/course/test").subscribe(
      response => {
        this.courseImgPath = window.course_img_path;
        this.courses = response.course;
        console.log( this.courses);
        
      },
      error => {
        console.log(error);
        // Handle error
      }
    )
  }

  
}
