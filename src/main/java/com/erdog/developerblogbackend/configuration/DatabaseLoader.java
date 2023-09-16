package com.erdog.developerblogbackend.configuration;

import com.erdog.developerblogbackend.model.Post;
import com.erdog.developerblogbackend.model.User;
import com.erdog.developerblogbackend.model.enums.PostStatus;
import com.erdog.developerblogbackend.repository.PostRepository;
import com.erdog.developerblogbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class DatabaseLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        User john = new User("john_doe", "John", "Doe", "123 Elm St.", "1234567890", "password123");
        User jane = new User("jane_doe", "Jane", "Doe", "456 Oak St.", "0987654321", "mypassword");
        User alice = new User("alice", "Alice", "Wonderland", "789 Maple St.", "1122334455", "alicepass");
        if (userRepository.count() == 0){
            userRepository.save(john);
            userRepository.save(alice);
            userRepository.save(jane);
        }
        if (postRepository.count() == 0){
            postRepository.save(new Post("John's First Post", "This is the content of John's first post.", "A post by John", john, new Date(), PostStatus.PUBLISHED));
            postRepository.save(new Post("Thoughts by Jane", "Just some thoughts by Jane.", "Thoughts about life", jane, new Date(), PostStatus.DRAFT));
            postRepository.save(new Post("Alice's Adventures", "Adventures described by Alice.", "Adventures in wonderland", alice, new Date(), PostStatus.PUBLISHED));
        }
    }
}
