package aptecht2008m.demospring.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/students")
public class StudentApi {
    @Autowired
      StudentService studentService;
 @RequestMapping(method = RequestMethod.GET)
 public ResponseEntity<List<Student>> getList(@RequestParam(defaultValue = "1") int page,
                                            @RequestParam(defaultValue = "10")int limit){
     return ResponseEntity.ok(studentService.findAll());
 }
 @RequestMapping(method = RequestMethod.GET, path = "/{rollNumber}")
    public ResponseEntity<?> getDetail(@PathVariable String rollNumber){
     Optional<Student> optionalStudent = studentService.findById(rollNumber);
     if (!optionalStudent.isPresent()){
         ResponseEntity.badRequest().build();
     }
     return ResponseEntity.ok(optionalStudent.get());
 }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Student> save(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.save(student));
    }
    @RequestMapping(method = RequestMethod.PUT, path = "/{rollNumber}")
    public ResponseEntity<Student> update(@PathVariable String rollNumber, @RequestBody Student updateStudent) {
     Optional<Student> optionalStudent = studentService.findById(rollNumber);
     if (!optionalStudent.isPresent()){
         ResponseEntity.badRequest().build();
     }
     Student existStudent = optionalStudent.get();
     existStudent.setFullName(updateStudent.getFullName());
       return  ResponseEntity.ok(studentService.save(existStudent));
    }
    @RequestMapping(method = RequestMethod.DELETE, path = "/{rollNumber}")
    public ResponseEntity<?>  delete(@PathVariable String rollNumber) {
     if (!studentService.findById(rollNumber).isPresent()){
         ResponseEntity.badRequest().build();
     }
     studentService.deleteById(rollNumber);
     return ResponseEntity.ok().build();
    }
}
