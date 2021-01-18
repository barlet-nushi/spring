package mk.edu.seeu.java.Project.Repositories;

import mk.edu.seeu.java.Project.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepo extends CrudRepository<Course,Long> {


}
