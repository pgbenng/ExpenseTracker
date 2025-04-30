package server.api.service;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import server.api.dto.AuthResponse;
import server.api.dto.LoginRequest;
import server.api.dto.SignupRequest;
import server.api.entity.User;
import server.api.repository.UserRepository;
import server.api.security.JwtUtil;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public void signup(SignupRequest req) {
        if (userRepository.existsByEmail(req.email())) throw new IllegalArgumentException("Email already exists!");

        User user = new User(req.email(), passwordEncoder.encode(req.password()), req.firstName());
        userRepository.save(user);
    }

    public AuthResponse login(LoginRequest req) {
        User user = userRepository.findByEmail(req.email()).orElseThrow(() -> new UsernameNotFoundException("Email does not exist!"));

        if (!passwordEncoder.matches(req.password(), user.getPassword()))
            throw new BadCredentialsException("Invalid password!");

        String token = jwtUtil.generateToken(user.getId(), user.getEmail());
        return new AuthResponse(token, "Bearer");
    }
}
