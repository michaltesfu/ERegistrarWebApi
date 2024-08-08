package miu.edu.eregistrarwebapi.service;

import miu.edu.eregistrarwebapi.dto.StudentResponse;
import miu.edu.eregistrarwebapi.model.Student;

import java.util.List;

public interface StudentService {

    void saveStudent(Student student);

    List<StudentResponse> findAllStudent();

    void deleteStudentById(Long id);

    StudentResponse findStudentById(Long id);

    void updateStudent(Student student, Long id);

}
