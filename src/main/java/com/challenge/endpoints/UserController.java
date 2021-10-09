package com.challenge.endpoints;
import com.challenge.entity.User;
import com.challenge.repository.UserRepository;
import com.challenge.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable("id") Long id) {
        return this.userService.findById(id);
    }

    @GetMapping(params = "accelerationName")
    public List<User> findByAccelerationId(@RequestParam String accelerationName) {
        return this.userService.findByAccelerationName(accelerationName);
    }

    @GetMapping(params = "companyId")
    public List<User> findByCompanyId(@RequestParam Long companyId) {
       return this.userService.findByCompanyId(companyId);
    }

}
