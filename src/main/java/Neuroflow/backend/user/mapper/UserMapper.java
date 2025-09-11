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
        d.setDateBirth(e.getDateBirth());
        d.setAddress(e.getAddress());
        return d;
    }

    public User toEntity(UserCreateRequest r) {
        User e = new User();
        e.setUsername(r.getUsername());
        e.setEmail(r.getEmail());
        e.setFirstName(r.getFirstName());
        e.setLastName(r.getLastName());
        e.setDateBirth(r.getDateBirth());
        e.setAddress(r.getAddress());
        // passwordHash viene settata nel Service
        return e;
    }

    public void updateEntity(UserUpdateRequest r, User e) {
        e.setEmail(r.getEmail());
        e.setFirstName(r.getFirstName());
        e.setLastName(r.getLastName());
        e.setDateBirth(r.getDateBirth());
        e.setAddress(r.getAddress());
    }
}
