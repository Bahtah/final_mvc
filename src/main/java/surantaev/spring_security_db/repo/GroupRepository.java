package surantaev.spring_security_db.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import surantaev.spring_security_db.entity.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
}