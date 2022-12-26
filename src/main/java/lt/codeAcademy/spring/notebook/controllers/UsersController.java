package lt.codeAcademy.spring.notebook.controllers;

import lt.codeAcademy.spring.notebook.entities.User;
import lt.codeAcademy.spring.notebook.payload.response.UserResponse;
import lt.codeAcademy.spring.notebook.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class UsersController {
    @Autowired
    private UserService userService;

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(new UserResponse(
            userService.getUserById( id )
        ));
    }

    @PostMapping("/users/{id}")
    public ResponseEntity<UserResponse> updateUser(@RequestBody User user, @PathVariable Long id) {
        return ResponseEntity.ok(new UserResponse(
            userService.updateUserById( id, user )
        ));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById( id );
        return new ResponseEntity<>( HttpStatus.NO_CONTENT );
    }
}
