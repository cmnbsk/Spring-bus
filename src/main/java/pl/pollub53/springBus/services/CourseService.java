package pl.pollub53.springBus.services;

import pl.pollub53.springBus.domain.Course;

import java.util.List;

public interface CourseService {
    List<Course> getCourses();

    Course getCourseById(long id);

    Course saveCourse(Course course);

    void deleteCourse(long id);

    Course updateCourse(Course course);
}
