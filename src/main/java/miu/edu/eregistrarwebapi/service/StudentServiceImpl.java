package miu.edu.eregistrarwebapi.service;

import lombok.RequiredArgsConstructor;
import miu.edu.eregistrarwebapi.dto.StudentResponse;
import miu.edu.eregistrarwebapi.model.Student;
import miu.edu.eregistrarwebapi.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    private final ModelMapper modelMapper;


    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<StudentResponse> findAllStudent() {
        List<Student> students =  studentRepository.findAll();
        return students.stream()
                       .map(s -> modelMapper.map(s, StudentResponse.class))
                       .collect(Collectors.toList());
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentResponse findStudentById(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            return modelMapper.map(student, StudentResponse.class);
        } else {
            return null;
        }
    }

    @Override
    public void updateStudent(Student student, Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()){
            Student existingStudent = optionalStudent.get();
            existingStudent.setStudentId(student.getStudentId());
            existingStudent.setStudentNumber(student.getStudentNumber());
            existingStudent.setFirstName(student.getFirstName());
            existingStudent.setLastName(student.getLastName());
            studentRepository.save(existingStudent);
        }else System.out.println("Student does not exist.");;
    }

}

