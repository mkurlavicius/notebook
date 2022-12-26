package lt.codeAcademy.spring.notebook.controllers;

import lt.codeAcademy.spring.notebook.entities.TodoListItem;
import lt.codeAcademy.spring.notebook.services.TodoListItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class TodoListItemsController {
    @Autowired
    private TodoListItemService todoListItemService;

    @GetMapping("/users/{userId}/todoLists/{todoListId}/todolistItems")
    public List<TodoListItem> getAllTodoListItems(@PathVariable Long userId, @PathVariable Long todoListId) {
        return todoListItemService.getTodoListItems(userId, todoListId);
    }

    @PostMapping("/users/{userId}/todoLists/{todoListId}/todoListItems")
    public TodoListItem saveTodoListItem
        (
            @RequestBody TodoListItem todoListItem,
            @PathVariable Long userId,
            @PathVariable Long todoListId
        )
    {
        return todoListItemService.saveTodoListItem(userId, todoListId, todoListItem);
    }

    @PostMapping("/users/{userId}/todoLists/{todoListId}/todoListItems/{id}")
    public TodoListItem updateTodoListItem
        (
            @RequestBody TodoListItem todoListItem,
            @PathVariable Long userId,
            @PathVariable Long todoListId,
            @PathVariable Long id
        )
    {
        return todoListItemService.updateTodoListItemById(
            userId,
            todoListId,
            todoListItem
        );
    }

    @DeleteMapping("/users/{userId}/todoLists/{todoListId}/todolistItems/{id}")
    public ResponseEntity<HttpStatus> deleteTodoListItem
        (
            @PathVariable Long userId,
            @PathVariable Long todoListId,
            @PathVariable Long id
        )
    {
        todoListItemService.deleteTodoListItemById(userId, todoListId, id);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT );
    }
}
