package lt.codeAcademy.spring.notebook.services;

import lt.codeAcademy.spring.notebook.entities.TodoList;
import lt.codeAcademy.spring.notebook.entities.TodoListItem;
import lt.codeAcademy.spring.notebook.entities.User;
import lt.codeAcademy.spring.notebook.repositories.TodoListItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoListItemService {

    @Autowired
    TodoListItemRepository todoListItemRepository;

    @Autowired
    UserService userService;

    @Autowired
    TodoListService todoListService;

    public List<TodoListItem> getTodoListItems(Long userId, Long todoListId) {
        TodoList todoList = todoListService.getTodoListById(userId, todoListId);
        return todoList.getTodoListsItems();
    }

    public TodoListItem saveTodoListItem(Long userId, Long todoListId, TodoListItem todoListItem) {
        User user = userService.getUserById(userId);
        TodoList todoList = userService.getTodoListById(user, todoListId);
        todoListItem.setTodoList(todoList);

        return todoListItemRepository.save(todoListItem);
    }

    public TodoListItem updateTodoListItemById
        (
            Long userId,
            Long todoListId,
            TodoListItem todoListItem
        ) {
        User user = userService.getUserById(userId);
        TodoList todoList = userService.getTodoListById(user, todoListId);

        todoListItem.setTodoList(todoList);

        return todoListItemRepository.save(todoListItem);
    }

    public String deleteTodoListItemById(Long userId, Long todoListId, Long id) {
        User user = userService.getUserById(userId);
        TodoList todoList = userService.getTodoListById(user, todoListId);
        TodoListItem todoListItem = todoListService.getTodoListItemById(todoList, id);

        boolean exists = todoListItemRepository.existsById(todoListItem.getId());

        if (exists) {
            todoListItemRepository.deleteById(todoListItem.getId());
            return "Todo list item was deleted with id:" + id;
        }
        return "Todo list item does not exist";
    }

}
