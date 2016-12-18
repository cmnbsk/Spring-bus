package pl.pollub53.springBus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pollub53.springBus.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
