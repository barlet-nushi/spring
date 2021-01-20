package mk.edu.seeu.java.Project.repositories;

import mk.edu.seeu.java.Project.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(path = "courses", collectionResourceRel = "courses")
public interface CourseRepo extends PagingAndSortingRepository<Course,Long> {

}
