package surantaev.spring_security_db.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import surantaev.spring_security_db.entity.Company;
import surantaev.spring_security_db.entity.Course;
import surantaev.spring_security_db.repo.CompanyRepository;
import surantaev.spring_security_db.repo.CourseRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    public void save(Course course) {
        courseRepository.save(course);
    }

    public Course getById(Long id) {
        return courseRepository.findById(id).get();
    }

    public void delete(Long id) {
        courseRepository.deleteById(id);
    }
}
