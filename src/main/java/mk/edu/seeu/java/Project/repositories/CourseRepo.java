package mk.edu.seeu.java.Project.repositories;

import mk.edu.seeu.java.Project.model.Course;
import mk.edu.seeu.java.Project.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@RepositoryRestResource(path = "courses", collectionResourceRel = "courses")
public interface CourseRepo extends PagingAndSortingRepository<Course,Long> {

    Set<Course> findByCname(@Param("cname") String name);
    Set<Course> findByCid(@Param("cid") long id);
    Set<Course> findByCnameContaining(@Param("cname") String name);

}
