package mk.edu.seeu.java.Project;

import mk.edu.seeu.java.Project.model.Course;
import mk.edu.seeu.java.Project.model.Student;
import mk.edu.seeu.java.Project.model.Teacher;
import mk.edu.seeu.java.Project.repositories.CourseRepo;
import mk.edu.seeu.java.Project.repositories.StudentRepo;
import mk.edu.seeu.java.Project.repositories.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.*;


@SpringBootApplication
public class ProjectApplication implements CommandLineRunner {

	@Autowired
	StudentRepo studentRepo;

	@Autowired
	CourseRepo courseRepo;

	@Autowired
	TeacherRepo teacherRepo;

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Student student = new Student("Barlet");
        Student student1 = new Student("Setki");

		studentRepo.save(student);
        studentRepo.save(student1);

		Course course1 = new Course("Calculus");
		Course course2 = new Course("Database");
        Course course3 = new Course("Java");

		courseRepo.saveAll(Arrays.asList(course1,course2,course3));

		student.getCourse().addAll(Arrays.asList(course1,course2));
        student1.getCourse().addAll(Arrays.asList(course1,course3));

		studentRepo.save(student);
		studentRepo.save(student1);

		Teacher teacher = new Teacher("John");
		Teacher teacher1 = new Teacher("Joe");
        Teacher teacher2 = new Teacher("Habib");

		teacher.setCourse(course1);
		teacher1.setCourse(course2);
		teacher2.setCourse(course3);


		teacherRepo.saveAll(Arrays.asList(teacher,teacher1,teacher2));
	}
}
