import { Component, OnInit, Input } from '@angular/core';
import { Student } from '../student';
import { StudentService } from '../student.service';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentListComponent } from '../student-list/student-list.component';
@Component({
  selector: 'app-students-details',
  templateUrl: './students-details.component.html',
  styleUrls: ['./students-details.component.css']
})
export class StudentsDetailsComponent implements OnInit {

  id: number;
  student: Student;

  constructor(private route: ActivatedRoute,private router: Router,
    private studentService: StudentService) { }

  ngOnInit() {
    this.student = new Student();

    this.id = this.route.snapshot.params['id'];
    
    this.studentService.getStudent(this.id)
      .subscribe(data => {
        console.log(data)
        this.student = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['students']);
  }
}