package mk.edu.seeu.java.Project.repositories;

import mk.edu.seeu.java.Project.model.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo extends CrudRepository<Teacher,Long> {

}
