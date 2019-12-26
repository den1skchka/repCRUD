package com.example.demo.Controller;

import com.example.demo.Exception.StudentNotFoundException;
import com.example.demo.Model.Student;
import com.example.demo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") int studentId)
            throws StudentNotFoundException {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException(studentId));
        return ResponseEntity.ok().body(student);
    }

    @PostMapping("/students")
    public Student createStudent(@Valid @RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") int studentId,
                                                   @Valid @RequestBody Student studentDetails) throws StudentNotFoundException {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException(studentId));


        student.setName(studentDetails.getName());
        student.setSurname(studentDetails.getSurname());
        student.setMathMark((int) studentDetails.getMathMark());
        student.setEngMark((int) studentDetails.getEngMark());
        student.setHistMark((int) studentDetails.getHistMark());
        student.setAvgCount((int) studentDetails.getAvgCount());
        final Student updatedStudent = studentRepository.save(student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/students/{id}")
    public Map<String, Boolean> deleteStudent(@PathVariable(value = "id") int studentId)
            throws StudentNotFoundException {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException(studentId));

        studentRepository.delete(student);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
//    @GetMapping("/students/{id}")
//    public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") int studentId) throws StudentNotFoundException {
//        return studentRepository.findById(studentId)
//                .orElseThrow(() -> new StudentNotFoundException(studentId));
//    }
//
//    @PostMapping("/students")
//    public Student createStudent(@Valid @RequestBody Student student){
//        return studentRepository.save(student);
//    }
//
//
//
//    @DeleteMapping("/students/{id}")
//    public ResponseEntity deleteStudent(@PathVariable(value = "id") int studentId) throws StudentNotFoundException {
//        Student student = studentRepository.findById(studentId)
//                .orElseThrow(() -> new StudentNotFoundException(studentId));
//
//        studentRepository.delete(student);
//        return ResponseEntity.ok().build();
//    }

