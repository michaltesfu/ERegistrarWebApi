package miu.edu.eregistrarwebapi.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.eregistrarwebapi.dto.StudentResponse;
import miu.edu.eregistrarwebapi.model.Student;
import miu.edu.eregistrarwebapi.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        System.out.println("Students is created successfully!");
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StudentResponse> findAllStudent(){
        return studentService.findAllStudent();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentResponse findStudentById(@PathVariable("id") Long id){
        return studentService.findStudentById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateStudent(@RequestBody Student student, @PathVariable("id") Long id){
        studentService.updateStudent(student, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudentById(@PathVariable("id") Long id){
        studentService.deleteStudentById(id);
        System.out.printf("Student with id: %d is Removed.%n", id);
    }
}
