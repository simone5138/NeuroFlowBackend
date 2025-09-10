package Neuroflow.backend.user.dto;

import Neuroflow.backend.user.entity.User.Role;

public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private Role role;
    private boolean enabled;
    // getters/setters
}
