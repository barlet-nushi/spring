package mk.edu.seeu.java.Project.repositories;

import mk.edu.seeu.java.Project.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Set;

@RepositoryRestResource(path = "students", collectionResourceRel = "students")
public interface StudentRepo extends PagingAndSortingRepository<Student,Long> {


    Set<Student> findBySname(@Param("sname") String name);
    Set<Student> findBySid(@Param("sid") long id);
    Set<Student> findBySnameContaining(@Param("sname") String name);

}
