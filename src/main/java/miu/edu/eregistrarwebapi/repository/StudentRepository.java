package miu.edu.eregistrarwebapi.repository;

import miu.edu.eregistrarwebapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
