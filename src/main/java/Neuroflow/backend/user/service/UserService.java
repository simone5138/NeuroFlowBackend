package Neuroflow.backend.user.service;

import Neuroflow.backend.user.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<UserDto> list(Pageable pageable);
    UserDto get(Long id);
    UserDto create(UserCreateRequest req);
    UserDto update(Long id, UserUpdateRequest req);
    void delete(Long id);
    void changePassword(Long id, UserPasswordUpdateRequest req);
    AuthResponse login(LoginRequest req);
}