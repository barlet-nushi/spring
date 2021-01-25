package mk.edu.seeu.java.Project.controller.rest;


import mk.edu.seeu.java.Project.controller.exception.StudentIdMismatchException;
import mk.edu.seeu.java.Project.controller.exception.StudentNotFoundException;
import mk.edu.seeu.java.Project.controller.exception.TeacherIdMismatchException;
import mk.edu.seeu.java.Project.controller.exception.TeacherNotFoundException;
import mk.edu.seeu.java.Project.model.Course;
import mk.edu.seeu.java.Project.model.Student;
import mk.edu.seeu.java.Project.model.Teacher;
import mk.edu.seeu.java.Project.repositories.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/rest/teacher")
public class RestTeacherController {

    @Autowired
    private TeacherRepo teacherRepo;

    @GetMapping
    public Iterable findAll() {
        return teacherRepo.findAll();
    }


    @GetMapping("/{id}")
    public Teacher findOne(@PathVariable long id) {
        return teacherRepo.findById(id)
                .orElseGet(() -> {
                    throw new TeacherNotFoundException("Teacher not found", null);
                });
    }

    @GetMapping("/find/{name}")
    public Set<Teacher> findByTname(@PathVariable String name) {
        return teacherRepo.findByTname(name);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteTeacher(@PathVariable long id) {
        teacherRepo.findById(id)
                .orElseGet(() -> {
                    throw new TeacherNotFoundException("Teacher not found", null);
                });
        teacherRepo.deleteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    @PutMapping("/update/{id}")
    public Teacher updateTeacher(@RequestBody Teacher teacher, @PathVariable long id) {
        if (teacher.getTid() != id) {
            throw new TeacherIdMismatchException("The id did not match", null);
        }
        teacherRepo.findById(id)
                .orElseGet(() -> {
                    throw new StudentNotFoundException("Student not found", null);
                });
        return teacherRepo.save(teacher);
    }
}
