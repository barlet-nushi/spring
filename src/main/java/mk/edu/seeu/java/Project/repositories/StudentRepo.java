package mk.edu.seeu.java.Project.repositories;

import mk.edu.seeu.java.Project.model.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "students", collectionResourceRel = "students")
public interface StudentRepo extends PagingAndSortingRepository<Student,Long> {

}
