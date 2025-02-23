package mk.edu.seeu.java.Project.controller.simpleController;

import mk.edu.seeu.java.Project.repositories.CourseRepo;
import mk.edu.seeu.java.Project.repositories.TeacherRepo;
import mk.edu.seeu.java.Project.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class TeacherController {

    @Autowired
    private TeacherRepo teacherRepo;

    @Autowired
    private CourseRepo courseRepo;

    @GetMapping("/teacher")
    public String showBaseForm(Teacher teacher,Model model) {
        model.addAttribute("courses",courseRepo.findAll());
        return "addTeacher";
    }

    @PostMapping("/teacher/addteacher")
    public String addTeacher(@Valid Teacher teacher, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addTeacher";
        }

        teacherRepo.save(teacher);
        return "redirect:/teacher/indexTeacher";
    }

    @GetMapping("/teacher/indexTeacher")
    public String showTeacherList(Model model) {
        model.addAttribute("teachers", teacherRepo.findAll());
        return "indexTeacher";
    }

    @GetMapping("/teacher/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long tid, Model model) {
        Teacher teacher = teacherRepo.findById(tid)
                .orElseThrow(() -> new IllegalArgumentException("Invalid teacher Id:" + tid));

        model.addAttribute("teachers", teacher);
        return "updateTeacher";
    }

    @PostMapping("/teacher/update/{id}")
    public String updateTeacher(@PathVariable("id") long tid, @Valid Teacher teacher, BindingResult result, Model model) {

        teacherRepo.save(teacher);
        return "redirect:/teacher/indexTeacher";
    }

    @GetMapping("/teacher/delete/{id}")
    public String deleteTeacher(@PathVariable("id") long tid, Model model) {
        Teacher teacher= teacherRepo.findById(tid)
                .orElseThrow(() -> new IllegalArgumentException("Invalid teacher Id:" + tid));
        teacherRepo.delete(teacher);
        return "redirect:/teacher/indexTeacher";
    }


}
