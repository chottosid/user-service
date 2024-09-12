package com.shohochori.user.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        User user = userService.login(loginDTO.getUserName(), loginDTO.getPassword());
        if(user == null) {
            return ResponseEntity.status(401).body("Invalid userName or password");
        }
        user.setPassword(null);
        return ResponseEntity.ok(user);
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO registerDTO) {
        boolean registered = userService.register(registerDTO);
        if(registered) {
            return ResponseEntity.ok("Registered successfully");
        }
        return ResponseEntity.status(409).body("Email already exists");
    }
}
