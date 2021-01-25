package mk.edu.seeu.java.Project.controller.simpleController;

import mk.edu.seeu.java.Project.model.Course;
import mk.edu.seeu.java.Project.repositories.CourseRepo;
import mk.edu.seeu.java.Project.repositories.StudentRepo;
import mk.edu.seeu.java.Project.model.Student;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.Subject;
import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Controller
public class StudentController {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private CourseRepo courseRepo;

    @GetMapping("/signup")
    public String showBaseForm(Student student,Model model) {
        model.addAttribute("courses",courseRepo.findAll());
        return "add";
    }

    @PostMapping("/addstudent")
    public String addStudent(@Valid Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "add";
        }

        studentRepo.save(student);
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String showStudentList(Model model) {
        model.addAttribute("students", studentRepo.findAll());
        return "index";
    }

      @GetMapping("/edit/{id}")
        public String showUpdateForm(@PathVariable("id") long sid, Model model) {
        Student student = studentRepo.findById(sid)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + sid));


        model.addAttribute("students", student);
        return "update";
    }


    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") long sid, @Valid Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "update";
        }
        var foundStudent = studentRepo.findById(sid)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + sid));
        foundStudent.setSname(student.getSname());


        studentRepo.save(foundStudent);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") long sid, Model model) {
        Student student = studentRepo.findById(sid)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Student Id:" + sid));
        studentRepo.delete(student);
        return "redirect:/index";
    }

}
