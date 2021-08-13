package stringboot.springbootcourse.service;

import stringboot.springbootcourse.model.CourseDTO;
import stringboot.springbootcourse.persistence.model.Course;
import stringboot.springbootcourse.persistence.repository.CourseRepo;

import java.util.List;

public interface CourseService extends BaseService<Course, Long, CourseRepo> {

    CourseDTO getCourseDtoById(Long id);

    CourseDTO createCourse(CourseDTO courseDTO);

    List<CourseDTO> getAllCourses();
}
