package com.luizlacerda.Beneficios.service;

import com.luizlacerda.Beneficios.controller.dto.CreateUserDto;
import com.luizlacerda.Beneficios.controller.dto.LoginRequest;
import com.luizlacerda.Beneficios.controller.dto.LoginResponse;
import com.luizlacerda.Beneficios.entities.Role;
import com.luizlacerda.Beneficios.entities.User;
import com.luizlacerda.Beneficios.repository.RoleRepository;
import com.luizlacerda.Beneficios.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final JwtEncoder jwtEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public void createNewUser(CreateUserDto createUserDto){

        Role basicRole = roleRepository.findByName(Role.Values.BASIC.name());

        Optional<User> userOptional = userRepository.findByUserName(createUserDto.getUsername());

        if(userOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        User user = new User();
        user.setUserName(createUserDto.getUsername());
        user.setRoles(Set.of(basicRole));
        user.setPassword(this.passwordEncoder.encode(createUserDto.getPassword()));

        this.userRepository.save(user);
    }


    public LoginResponse login(LoginRequest loginRequest) {
        Optional<User> user = userRepository.findByUserName(loginRequest.getUsername());
        if(user.isEmpty() || !user.get().isLoginCorrect(loginRequest, passwordEncoder)){
            throw new BadCredentialsException("Usuario ou senha invalidos");
        }
        var now = Instant.now();
        var expiresIn = 300L;
        var claims = JwtClaimsSet.builder()
                .issuer("Beneficios_Backend")
                .subject(user.get().getUserId().toString())
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiresIn))
                .build();

        var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();


        return new LoginResponse(jwtValue, expiresIn);

    }
}
