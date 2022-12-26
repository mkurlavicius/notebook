package lt.codeAcademy.spring.notebook.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "todoListItems")
public class TodoListItem
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String content;

    private LocalDateTime deadline;

    private Integer sortNumber;

    @ManyToOne
    @JoinColumn(name = "todo_list_id", referencedColumnName = "id")
    private TodoList todoList;
}
