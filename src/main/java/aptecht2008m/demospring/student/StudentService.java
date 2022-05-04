package aptecht2008m.demospring.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public List<Student> findAll(){
        return studentRepository.findAll();
    }
    public Optional<Student> findById(String rollNumber){
        return studentRepository.findById(rollNumber);
    }
    public Student save(Student student){
        return studentRepository.save(student);
    }
    public void  deleteById(String rollNumber){
        studentRepository.deleteById(rollNumber);
    }
}
