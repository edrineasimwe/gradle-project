package org.example.controller;

import org.example.model.User;
import org.example.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody User user){
        return ResponseEntity.ok(service.addUser(user));
    }
    @GetMapping("/findById")
    public ResponseEntity<Optional<User>> findById(@PathVariable int id){
        return ResponseEntity.ok(Optional.ofNullable(service.getUserById((long) id)));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

//    @GetMapping
//    public List<User> getAllUsers() {
//        return service.findAll();
//    }
//
//    @PostMapping
//    public User createUser(@RequestBody User user) {
//        return service.addUser(user);
//    }
//
//    @GetMapping("/{id}")
//    public User getUserById(@PathVariable Long id) {
//        return (User) service.getUserById(id);
//    }
//
//    @PutMapping("/{id}")
//    public User updateUser(@PathVariable Long id, @RequestBody User user) {
//        return service.updateUser(id, user);
//    }
//
////    @DeleteMapping("/{id}")
////    public void deleteUser(@PathVariable Long id) {
////        service.deleteById(id);
////    }
//    @DeleteMapping("/{id}")
//    public void deleteUser(@PathVariable Long id) {
//        service.deleteUser(id);
//    }
}

