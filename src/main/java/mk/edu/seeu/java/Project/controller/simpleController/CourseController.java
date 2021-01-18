package mk.edu.seeu.java.Project.controller.simpleController;

import mk.edu.seeu.java.Project.repositories.CourseRepo;
import mk.edu.seeu.java.Project.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CourseController {

    @Autowired
    private CourseRepo courseRepo;

    @GetMapping("/course")
    public String showBaseForm(Course course) {
        return "addCourse";
    }

    @PostMapping("/course/addcourse")
    public String addCourse(@Valid Course course, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addCourse";
        }

        courseRepo.save(course);
        return "redirect:/course/indexCourse";
    }

    @GetMapping("/course/indexCourse")
    public String showStudentList(Model model) {
        model.addAttribute("courses", courseRepo.findAll());
        return "indexCourse";
    }

    @GetMapping("/course/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long cid, Model model) {
        Course course = courseRepo.findById(cid)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Course Id:" + cid));

        model.addAttribute("courses", course);
        return "updateCourse";
    }

    @PostMapping("/course/update/{id}")
    public String updateCourse(@PathVariable("id") long cid, @Valid Course course, BindingResult result, Model model) {

        courseRepo.save(course);
        return "redirect:/course/indexCourse";
    }

    @GetMapping("/course/delete/{id}")
    public String deleteCourse(@PathVariable("id") long cid, Model model) {
        Course course = courseRepo.findById(cid)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Course Id:" + cid));
        courseRepo.delete(course);
        return "redirect:/course/indexCourse";
    }


}
