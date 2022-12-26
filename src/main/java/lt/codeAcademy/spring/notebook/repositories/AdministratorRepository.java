package lt.codeAcademy.spring.notebook.repositories;

import lt.codeAcademy.spring.notebook.entities.Administrator;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {

}
