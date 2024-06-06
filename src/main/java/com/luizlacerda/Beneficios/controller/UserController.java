package com.luizlacerda.Beneficios.controller;

import com.luizlacerda.Beneficios.controller.dto.CreateUserDto;
import com.luizlacerda.Beneficios.controller.dto.LoginRequest;
import com.luizlacerda.Beneficios.controller.dto.LoginResponse;
import com.luizlacerda.Beneficios.entities.Role;
import com.luizlacerda.Beneficios.entities.User;
import com.luizlacerda.Beneficios.repository.RoleRepository;
import com.luizlacerda.Beneficios.repository.UserRepository;
import com.luizlacerda.Beneficios.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.Optional;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/createNewUser")
    @Operation(summary = "Create", description = "Criar um novo usuario", tags = "Authentication")
    @Transactional
    public ResponseEntity<Void> newUser(@RequestBody CreateUserDto createUserDto){

        this.userService.createNewUser(createUserDto);


        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    @Operation(summary = "Login", description = "Loga com o usuario é recebe um token", tags = "Authentication")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        LoginResponse loginResponse = this.userService.login(loginRequest);

        return ResponseEntity.ok(loginResponse);
    }
}
