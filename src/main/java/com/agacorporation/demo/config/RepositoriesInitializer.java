package com.agacorporation.demo.config;

import com.agacorporation.demo.domain.Authority;
import com.agacorporation.demo.domain.User;
import com.agacorporation.demo.repository.AuthorityRepository;
import com.agacorporation.demo.repository.UserRepository;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

@Configuration
public class RepositoriesInitializer {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    InitializingBean init() {

        return () -> {



            if (authorityRepository.findAll().isEmpty() == true) {
                try {
                    Authority roleUser = authorityRepository.save(new Authority("ROLE_USER"));
                    Authority roleAdmin = authorityRepository.save(new Authority("ROLE_ADMIN"));
                    User test = new User("test");
                    test.setAuthorities(new ArrayList<>(Arrays.asList(roleUser)));
                    test.setPassword(passwordEncoder.encode("test"));
                    test.setFirstName("Oleksiy");
                    test.setLastName("Petrenko");
                    test.setPhoneNumber("380663413389");
                    test.setEmail("mail@mail.com");
                    User user = new User("user");
                    user.setAuthorities(new ArrayList<>(Arrays.asList(roleUser)));
                    user.setPassword(passwordEncoder.encode("user"));
                    user.setFirstName("Tomas");
                    user.setLastName("Vasilenko");
                    user.setEmail("tomas@gmail.com");
                    user.setPhoneNumber("380964236177");

                    User admin = new User("admin");
                    admin.setFirstName("Polina");
                    admin.setLastName("Terentenko");
                    admin.setEmail("aga@aga.aga");
                    admin.setPhoneNumber("380671235588");
                    admin.setAuthorities(new ArrayList<>(Arrays.asList(roleAdmin)));
                    admin.setPassword(passwordEncoder.encode("admin"));




                    userRepository.save(user);
                    userRepository.save(admin);
                    userRepository.save(test);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
