package mk.edu.seeu.java.Project.Repositories;

import mk.edu.seeu.java.Project.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepo extends CrudRepository<Student,Long> {

    Student findBysid(long sid);
}
