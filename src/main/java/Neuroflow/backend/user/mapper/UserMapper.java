package Neuroflow.backend.user.mapper;

import Neuroflow.backend.user.dto.*;
import Neuroflow.backend.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toDto(User e) {
        if (e == null) return null;
        UserDto d = new UserDto();
        d.setId(e.getId());
        d.setUsername(e.getUsername());
        d.setEmail(e.getEmail());
        d.setFirstName(e.getFirstName());
        d.setLastName(e.getLastName());
        d.setRole(e.getRole());
        d.setEnabled(e.isEnabled());
        return d;
    }

    public User toEntity(UserCreateRequest r) {
        User e = new User();
        e.setUsername(r.getUsername());
        e.setEmail(r.getEmail());
        e.setFirstName(r.getFirstName());
        e.setLastName(r.getLastName());
        e.setRole(r.getRole());
        e.setEnabled(r.isEnabled());
        // passwordHash viene settata nel Service
        return e;
    }

    public void updateEntity(UserUpdateRequest r, User e) {
        e.setEmail(r.getEmail());
        e.setFirstName(r.getFirstName());
        e.setLastName(r.getLastName());
        if (r.getRole()!=null) e.setRole(r.getRole());
        e.setEnabled(r.isEnabled());
    }
}
