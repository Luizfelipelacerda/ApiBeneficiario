package com.luizlacerda.Beneficios.config;

import com.luizlacerda.Beneficios.entities.Role;
import com.luizlacerda.Beneficios.entities.User;
import com.luizlacerda.Beneficios.repository.RoleRepository;
import com.luizlacerda.Beneficios.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
@RequiredArgsConstructor
public class AdminUserConfig implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        Role roleAdmin = this.roleRepository.findByName(Role.Values.ADMIN.name());
        var userAdmin = this.userRepository.findByUserName("admin");

        userAdmin.ifPresentOrElse(
                user-> {
                    System.out.println("admin ja existe");
                },
                ()-> {
                    User user = new User();
                    user.setUserName("admin");
                    user.setRoles(Set.of(roleAdmin));
                    user.setPassword(passwordEncoder.encode("12345"));
                    this.userRepository.save(user);
                }
        );

    }
}
