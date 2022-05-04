package aptecht2008m.demospring.student;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Student {
    @Id
    private String rollNumber;
    private String fullName;
    private String gender;
    private int status;

    public Student(String rollNumber, String fullName) {
        this.rollNumber = rollNumber;
        this.fullName = fullName;
    }
}
