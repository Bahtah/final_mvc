package surantaev.spring_security_db.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import surantaev.spring_security_db.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}