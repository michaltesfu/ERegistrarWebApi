package miu.edu.eregistrarwebapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.eregistrarwebapi.Enum.IsInternational;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @Column(nullable = false)
    private String studentNumber;
    @Column(nullable = false)
    private String firstName;
    private String middleName;
    @Column(nullable = false)
    private String lastName;
    private Double cgpa;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private LocalDate enrollmentDate;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private IsInternational isInternational;


}

