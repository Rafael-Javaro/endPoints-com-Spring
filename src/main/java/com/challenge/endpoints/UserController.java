package com.challenge.endpoints;

import com.challenge.entity.User;
import com.challenge.repository.UserRepository;
import com.challenge.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public Iterable<User> findAll() { return this.userRepository.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.userService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User")
        ), HttpStatus.OK);
    }

    @GetMapping("/acceleration/{name}")
    public List<User> findUserByAccelerationId(@PathParam("name") String name) {
        List<User> usersList = this.userService.findByAccelerationName(name);
        return usersList.isEmpty() ? (List<User>) new ResourceNotFoundException("Users from " + name)
                : usersList;
    }

}
