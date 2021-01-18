package mk.edu.seeu.java.Project.repositories;

import mk.edu.seeu.java.Project.model.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "teachers", collectionResourceRel = "teachers")
public interface TeacherRepo extends PagingAndSortingRepository<Teacher,Long> {

}
