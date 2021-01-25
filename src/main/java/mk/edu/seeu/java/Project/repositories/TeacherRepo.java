package mk.edu.seeu.java.Project.repositories;

import mk.edu.seeu.java.Project.model.Student;
import mk.edu.seeu.java.Project.model.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@RepositoryRestResource(path = "teachers", collectionResourceRel = "teachers")
public interface TeacherRepo extends PagingAndSortingRepository<Teacher,Long> {

    Set<Teacher> findByTname(@Param("tname") String name);
    Set<Teacher> findByTid(@Param("tid") long id);
    Set<Teacher> findByTnameContaining(@Param("tname") String name);

}
