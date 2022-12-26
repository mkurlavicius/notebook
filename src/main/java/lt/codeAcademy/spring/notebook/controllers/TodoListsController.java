package lt.codeAcademy.spring.notebook.controllers;

import lt.codeAcademy.spring.notebook.entities.TodoList;
import lt.codeAcademy.spring.notebook.entities.User;
import lt.codeAcademy.spring.notebook.services.TodoListService;
import lt.codeAcademy.spring.notebook.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class TodoListsController {
    @Autowired
    private TodoListService todoListService;
    @Autowired
    private UserService userService;

    @GetMapping("/users/{userId}/todoLists")
    public List<TodoList> getAllTodoLists(@PathVariable Long userId) {
        return todoListService.getTodoList(userId);
    }

    @GetMapping("/users/{userId}/todoLists/{id}")
    public TodoList getTodoListById(@PathVariable Long userId, @PathVariable Long id) {
        return todoListService.getTodoListById(userId, id);
    }

    @PostMapping("/users/{userId}/todoLists")
    public TodoList saveTodoList(@RequestBody TodoList todoList, @PathVariable Long userId) {
        return todoListService.saveTodoList(todoList, userId);
    }

    @PostMapping("/users/{userId}/todoLists/{id}")
    public TodoList updateTodoList
        (
            @RequestBody TodoList todoList,
            @PathVariable Long userId,
            @PathVariable Long id
        )
    {
        return todoListService.updateTodoListById(userId, id, todoList);
    }

    @DeleteMapping("/users/{userId}/todoLists/{id}")
    public ResponseEntity<HttpStatus> deleteTodoList(@PathVariable Long userId, @PathVariable Long id) {
        todoListService.deleteTodoListById(userId, id );
        return new ResponseEntity<>( HttpStatus.NO_CONTENT );
    }
}
