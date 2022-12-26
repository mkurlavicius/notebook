package lt.codeAcademy.spring.notebook.repositories;

import lt.codeAcademy.spring.notebook.entities.TodoListItem;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TodoListItemRepository extends JpaRepository<TodoListItem, Long>
{

}
