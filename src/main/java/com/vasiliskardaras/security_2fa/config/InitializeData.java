package com.vasiliskardaras.security_2fa.config;

import com.vasiliskardaras.security_2fa.model.Authority;
import com.vasiliskardaras.security_2fa.model.User;
import com.vasiliskardaras.security_2fa.repository.AuthorityRepository;
import com.vasiliskardaras.security_2fa.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class InitializeData {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository, PasswordEncoder encoder,
            AuthorityRepository authorityRepository) {
        return args -> {
            if (authorityRepository.findAll().isEmpty()) {
                Authority authUser = authorityRepository.save(new Authority("ROLE_USER"));
                Authority authAdmin = authorityRepository.save(new Authority("ROLE_ADMIN"));

                if (userRepository.findAll().isEmpty()) {

                    userRepository.save(new User("user", encoder.encode("password"), "ROLE_USER", Set.of(authUser)));
                    userRepository.save(new User("admin", encoder.encode("password"), "ROLE_USER,ROLE_ADMIN",
                            Set.of(authUser, authAdmin)));
                }
            }
        };
    }
}
