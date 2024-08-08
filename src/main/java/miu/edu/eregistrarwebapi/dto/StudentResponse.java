package miu.edu.eregistrarwebapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.eregistrarwebapi.Enum.IsInternational;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentResponse {
    private Long studentId;
    String studentNumber;
    String firstName;
    String lastName;
    IsInternational isInternational;
}
