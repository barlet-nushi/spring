package mk.edu.seeu.java.Project.controller.rest;



import mk.edu.seeu.java.Project.controller.exception.StudentIdMismatchException;
import mk.edu.seeu.java.Project.controller.exception.StudentNotFoundException;
import mk.edu.seeu.java.Project.model.Course;
import mk.edu.seeu.java.Project.repositories.CourseRepo;
import mk.edu.seeu.java.Project.repositories.StudentRepo;
import mk.edu.seeu.java.Project.model.Student;
import org.apache.tomcat.jni.Address;
import org.apache.tomcat.jni.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/update/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable long id) {
        if (student.getSid() != id) {
            throw new StudentIdMismatchException("The id did not match", null);
        }
        studentRepo.findById(id)
                .orElseGet(() -> {
                    throw new StudentNotFoundException("Student not found", null);
                });
        return studentRepo.save(student);
    }



}
