package com.example.new_relic_poc.user.controller;

import com.example.new_relic_poc.user.model.UserRequest;
import com.example.new_relic_poc.user.model.User;
import com.example.new_relic_poc.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> list(){
        return ResponseEntity.ok(userService.list());
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserRequest userRequest){
        User userToSave = userRequest.converter();
        User saved = userService.createOrUpdate(userToSave);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Long id){
        User user = userService.getUser(id);
        if(user == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody UserRequest userRequest){
        User user = userService.getUser(id);
        if(user == null)
            return ResponseEntity.notFound().build();

        User userToSave = userRequest.update(user);
        User saved = userService.createOrUpdate(userToSave);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        User user = userService.getUser(id);
        if(user == null)
            return ResponseEntity.notFound().build();

        userService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
