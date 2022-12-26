package lt.codeAcademy.spring.notebook.repositories;

import lt.codeAcademy.spring.notebook.entities.Administrator;
import lt.codeAcademy.spring.notebook.entities.TodoList;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Long>
{
}
