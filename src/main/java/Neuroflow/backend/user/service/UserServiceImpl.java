package Neuroflow.backend.user.service;

import Neuroflow.backend.user.dto.*;
import Neuroflow.backend.user.entity.User;
import Neuroflow.backend.user.mapper.UserMapper;
import Neuroflow.backend.user.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder; // definisci un @Bean in SecurityConfig

    public UserServiceImpl(UserRepository repo, UserMapper mapper, PasswordEncoder pe) {
        this.repo = repo; this.mapper = mapper; this.passwordEncoder = pe;
    }

    @Override public Page<UserDto> list(Pageable p) { return repo.findAll(p).map(mapper::toDto); }

    @Override public UserDto get(Long id) {
        User e = repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found: "+id));
        return mapper.toDto(e);
    }

    @Override public UserDto create(UserCreateRequest r) {
        if (repo.existsByUsername(r.getUsername())) throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already exists");
        if (repo.existsByEmail(r.getEmail()))     throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists");
        User e = mapper.toEntity(r);
        e.setPasswordHash(passwordEncoder.encode(r.getPassword()));
        return mapper.toDto(repo.save(e));
    }

    @Override public UserDto update(Long id, UserUpdateRequest r) {
        User e = repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found: "+id));
        // se cambia email verifica duplicati
        if (!e.getEmail().equals(r.getEmail()) && repo.existsByEmail(r.getEmail()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists");
        mapper.updateEntity(r, e);
        return mapper.toDto(repo.save(e));
    }

    @Override public void delete(Long id) {
        if (!repo.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found: "+id);
        repo.deleteById(id);
    }

    @Override public void changePassword(Long id, UserPasswordUpdateRequest r) {
        User e = repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found: "+id));
        e.setPasswordHash(passwordEncoder.encode(r.getNewPassword()));
        repo.save(e);
    }

    @Override
    public AuthResponse login(LoginRequest req) {
        User u = repo.findByUsername(req.getUsername()).orElse(null);
        if (u == null || !passwordEncoder.matches(req.getPassword(), u.getPasswordHash())) {
            return new AuthResponse(false, "Invalid credentials", null);
        }
        return new AuthResponse(true, "Login successful", mapper.toDto(u));
    }
}

