package mk.edu.seeu.java.Project.Controller.SimpleController;

import mk.edu.seeu.java.Project.Repositories.StudentRepo;
import mk.edu.seeu.java.Project.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class StudentController {

    @Autowired
    private StudentRepo studentRepo;

    @GetMapping("/signup")
    public String showBaseForm(Student student) {
        return "add";
    }

    @PostMapping("/addstudent")
    public String addStudent(@Valid Student student, BindingResult result, Model model) {
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

        studentRepo.save(student);
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
