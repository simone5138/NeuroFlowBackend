package Neuroflow.backend.user.controller;

import Neuroflow.backend.user.dto.AuthResponse;
import Neuroflow.backend.user.dto.LoginRequest;
import Neuroflow.backend.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final UserService service;
    public AuthController(UserService service) { this.service = service; }

    @PostMapping("/signin")
    public AuthResponse login(@Valid @RequestBody LoginRequest req) {
        return service.login(req);
    }
}
