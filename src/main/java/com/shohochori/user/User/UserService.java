package com.shohochori.user.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User login(String userName, String password) {
        Optional<User> user = userRepository.findByUserName(userName);
        if(user.isPresent() && user.get().getPassword().equals(password)) {
            return user.get();
        }
        return null;
    }

    public boolean register(RegisterDTO registerDTO) {
        Optional<User> user = userRepository.findByEmail(registerDTO.getEmail());
        if(user.isPresent()) {
            return false;
        }
        user = userRepository.findByUserName(registerDTO.getUserName());
        if(user.isPresent()) {
            return false;
        }
        User newUser = new User();
        newUser.setEmail(registerDTO.getEmail());
        newUser.setPassword(registerDTO.getPassword());
        newUser.setName(registerDTO.getName());
        newUser.setDob(registerDTO.getDob());
        newUser.setGender(registerDTO.getGender());
        newUser.setProfilePicture(registerDTO.getProfilePicture());
        newUser.setNumber(registerDTO.getNumber());
        newUser.setAddress(registerDTO.getAddress());
        newUser.setUserName(registerDTO.getUserName());
        userRepository.save(newUser);
        return true;
    }
}
