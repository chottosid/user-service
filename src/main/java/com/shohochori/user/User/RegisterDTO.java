package com.shohochori.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterDTO {
    private String name;
    private String email;
    private String password;
    private String number;
    private String address;
    private LocalDateTime dob;
    private String gender;
    private String profilePicture;
    private String userName;
}
