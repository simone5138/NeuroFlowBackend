package Neuroflow.backend.user.controller;

import Neuroflow.backend.user.dto.*;
import Neuroflow.backend.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;
    public UserController(UserService s){ this.service = s; }

    @GetMapping public Page<UserDto> list(Pageable p) { return service.list(p); }
    @GetMapping("/{id}") public UserDto get(@PathVariable Long id) { return service.get(id); }
    @PostMapping public UserDto create(@Valid @RequestBody UserCreateRequest r) { return service.create(r); }
    @PutMapping("/{id}") public UserDto update(@PathVariable Long id, @Valid @RequestBody UserUpdateRequest r) { return service.update(id, r); }
    @PutMapping("/{id}/password") public void changePassword(@PathVariable Long id, @Valid @RequestBody UserPasswordUpdateRequest r) { service.changePassword(id, r); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) { service.delete(id); }
}

