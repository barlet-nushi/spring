package mk.edu.seeu.java.Project.Controller.Rest;



import mk.edu.seeu.java.Project.Controller.Exception.StudentNotFoundException;
import mk.edu.seeu.java.Project.Repositories.StudentRepo;
import mk.edu.seeu.java.Project.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/rest/student")
public class RestStudentController {

    @Autowired
    private StudentRepo studentRepo;

    @GetMapping
    public Iterable findAll() {
        return studentRepo.findAll();
    }


    @GetMapping("/{id}")
    public Student findOne(@PathVariable long id) {
        return studentRepo.findById(id)
                .orElseGet(() -> {
                    throw new StudentNotFoundException("Student not found", null);
                });
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable long id) {
        studentRepo.findById(id)
                .orElseGet(() -> {
                    throw new StudentNotFoundException("Student not found", null);
                });
        studentRepo.deleteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
            return studentRepo.save(student);
    }
//
//    @PutMapping("/update/{id}")
//    public Student updateStudent(@RequestBody Student student, @PathVariable long sid) {
//        if (student.getSid() != sid) {
//            throw new StudentIdMismatchException("The id did not match", null);
//        }
//        studentRepo.findById(sid)
//                .orElseGet(() -> {
//                    throw new StudentNotFoundException("Student not found", null);
//                });
//        return studentRepo.save(student);
//    }
}
