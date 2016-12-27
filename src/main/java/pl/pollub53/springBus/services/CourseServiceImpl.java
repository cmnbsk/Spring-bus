package pl.pollub53.springBus.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.pollub53.springBus.domain.Course;
import pl.pollub53.springBus.repositories.CourseRepository;

import javax.persistence.NoResultException;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseRepository courseRepository;

    @Autowired
    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Course getCourseById(long id) {
        return courseRepository.findOne(id);
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(long id) {
        courseRepository.delete(id);
    }

    @Override
    public Course updateCourse(Course course) throws NoResultException {
        Course foundCourse = courseRepository.findOne(course.getId());
        if (foundCourse == null) {
            throw new NoResultException("Cannot update course. Course doesn't exist");
        }
        return courseRepository.save(course);
    }
}
