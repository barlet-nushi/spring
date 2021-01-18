package mk.edu.seeu.java.Project.repositories;

import mk.edu.seeu.java.Project.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends CrudRepository<Course,Long> {


}
