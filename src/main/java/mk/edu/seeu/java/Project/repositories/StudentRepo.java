package mk.edu.seeu.java.Project.repositories;

import mk.edu.seeu.java.Project.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends CrudRepository<Student,Long> {

    Student findBysid(long sid);
}
