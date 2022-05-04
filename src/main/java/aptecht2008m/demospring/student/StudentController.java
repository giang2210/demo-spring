package aptecht2008m.demospring.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @PostMapping(path ="/student")
    public String PostData(){
        return "Hello Post";
    }
    @GetMapping(path = "/student")
    public  Student hiStudent(){
        return new Student("A001","dao minh giang","ghasgda", 1);
    }
}
