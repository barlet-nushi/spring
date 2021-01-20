package mk.edu.seeu.java.Project.controller.rest;


import mk.edu.seeu.java.Project.controller.exception.CourseIdMismatchException;
import mk.edu.seeu.java.Project.controller.exception.CourseNotFoundException;
import mk.edu.seeu.java.Project.controller.exception.StudentIdMismatchException;
import mk.edu.seeu.java.Project.controller.exception.StudentNotFoundException;
import mk.edu.seeu.java.Project.model.Course;
import mk.edu.seeu.java.Project.model.Student;
import mk.edu.seeu.java.Project.repositories.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/course")
public class RestCourseController {

    @Autowired
    private CourseRepo courseRepo;

    @GetMapping
    public Iterable findAll() {
        return courseRepo.findAll();
    }


    @GetMapping("/{id}")
    public Course findOne(@PathVariable long id) {
        return courseRepo.findById(id)
                .orElseGet(() -> {
                    throw new CourseNotFoundException("Course Not Found", null);
                });
    }


    @DeleteMapping("/delete/{id}")
    public void deleteCourse(@PathVariable long id) {
        courseRepo.findById(id)
                .orElseGet(() -> {
                    throw new CourseNotFoundException("Course not found", null);
                });
        courseRepo.deleteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Course createCourse(@RequestBody Course course) {
        return courseRepo.save(course);
    }

    @PutMapping("/update/{id}")
    public Course updateCourse(@RequestBody Course course, @PathVariable long id) {
        if (course.getCid() != id) {
            throw new CourseIdMismatchException("The id did not match", null);
        }
        courseRepo.findById(id)
                .orElseGet(() -> {
                    throw new CourseNotFoundException("Course not found", null);
                });
        return courseRepo.save(course);
    }
}
