package com.example.springbootcrud.User.Controller;

import com.example.springbootcrud.User.Model.User;
import com.example.springbootcrud.User.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers()
    {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK); //ok is 200 status code
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserByID(@PathVariable("id") Long id)
    {
        User attempt = userService.findUserById(id);
        if (attempt != null){ return new ResponseEntity<>(attempt, HttpStatus.OK);}
        return new ResponseEntity<>(attempt, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getByEmail")
    public ResponseEntity<User> getUserByEmail(@RequestBody User user){
        User attempt = userService.findUserByEmail(user.getEmail());
        if (attempt != null){ return new ResponseEntity<>(attempt, HttpStatus.OK);}
        return new ResponseEntity<>(attempt, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email){
        User attempt = userService.findUserByEmail(email);
        if (attempt != null){ return new ResponseEntity<>(attempt, HttpStatus.OK);}
        return new ResponseEntity<>(attempt, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user)
    {
        User attempt = userService.addUser(user);
        if (attempt != null){ return new ResponseEntity<>(attempt, HttpStatus.CREATED);}
        return new ResponseEntity<>(attempt, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user)
    {
        User attempt = userService.updateUser(user);
        if (attempt != null){ return new ResponseEntity<>(attempt, HttpStatus.NO_CONTENT);}
        return new ResponseEntity<>(attempt, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id)
    {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
