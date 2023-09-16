package com.erdog.developerblogbackend.configuration;

import com.erdog.developerblogbackend.model.User;
import com.erdog.developerblogbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DatabaseLoader implements CommandLineRunner {

    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0){
            userRepository.save(new User("john_doe", "John", "Doe", "123 Elm St.", "1234567890", "password123"));
            userRepository.save(new User("jane_doe", "Jane", "Doe", "456 Oak St.", "0987654321", "mypassword"));
            userRepository.save(new User("alice", "Alice", "Wonderland", "789 Maple St.", "1122334455", "alicepass"));
        }
    }
}
