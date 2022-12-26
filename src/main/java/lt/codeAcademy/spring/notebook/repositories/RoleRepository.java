package lt.codeAcademy.spring.notebook.repositories;

import lt.codeAcademy.spring.notebook.entities.ERole;
import lt.codeAcademy.spring.notebook.entities.Role;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>
{
    Optional<Role> findByName(ERole name);
}
