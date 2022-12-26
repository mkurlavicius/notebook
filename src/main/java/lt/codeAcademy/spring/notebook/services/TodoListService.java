package lt.codeAcademy.spring.notebook.services;

import lt.codeAcademy.spring.notebook.entities.TodoList;
import lt.codeAcademy.spring.notebook.entities.TodoListItem;
import lt.codeAcademy.spring.notebook.entities.User;
import lt.codeAcademy.spring.notebook.repositories.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoListService {

    @Autowired
    TodoListRepository todoListRepository;

    @Autowired
    UserService userService;

    public List<TodoList> getTodoList(Long id) {
        User user = userService.getUserById(id);
        return user.getTodoLists();
    }

    public TodoList saveTodoList(TodoList todoList, Long id) {
        User user = userService.getUserById(id);
        todoList.setUser(user);

        return todoListRepository.save(todoList);
    }

    public TodoList getTodoListById(Long userId, Long id) {
        User user = userService.getUserById(userId);

        List<TodoList>todoLists = user.getTodoLists();
        for (TodoList todoList: todoLists) {
            if(todoList.getId() == id) {
                return todoList;
            }
        }
        return null;
    }

    public TodoList updateTodoListById(Long userId, Long id, TodoList todoList) {
        User user = userService.getUserById(userId);
        TodoList result = userService.getTodoListById(user, id);

        result.setUser(user);

        return todoListRepository.save(todoList);
    }

    public String deleteTodoListById(Long userId, Long id) {
        User user = userService.getUserById(userId);
        TodoList todoList = userService.getTodoListById(user, id);

        boolean exists = todoListRepository.existsById(todoList.getId());

        if (exists) {
            todoListRepository.deleteById(todoList.getId());
            return "Todo list was deleted with id:" + id;
        }
        return "Todo list does not exist";
    }

    public TodoListItem getTodoListItemById(TodoList todoList, Long todoListItemId) {
        for (TodoListItem todoListItem: todoList.getTodoListsItems()) {
            if(todoListItem.getId() == todoListItemId) {
                return todoListItem;
            }
        }
        return null;
    }

}
