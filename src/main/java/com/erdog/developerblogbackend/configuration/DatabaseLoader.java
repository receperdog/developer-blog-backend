package com.erdog.developerblogbackend.configuration;

import com.erdog.developerblogbackend.model.Comment;
import com.erdog.developerblogbackend.model.Post;
import com.erdog.developerblogbackend.model.User;
import com.erdog.developerblogbackend.model.enums.PostStatus;
import com.erdog.developerblogbackend.repository.CommentRepository;
import com.erdog.developerblogbackend.repository.PostRepository;
import com.erdog.developerblogbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class DatabaseLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

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
        if (postRepository.count() == 0) {
            // Create and save posts first
            Post johnsPost = new Post("John's First Post", "This is the content of John's first post.", "A post by John", john, new Date(), PostStatus.PUBLISHED, null);
            Post janesPost = new Post("Thoughts by Jane", "Just some thoughts by Jane.", "Thoughts about life", jane, new Date(), PostStatus.DRAFT, null);
            Post alicesPost = new Post("Alice's Adventures", "Adventures described by Alice.", "Adventures in wonderland", alice, new Date(), PostStatus.PUBLISHED, null);

            postRepository.save(johnsPost);
            postRepository.save(janesPost);
            postRepository.save(alicesPost);

            // Create and associate comments
            Comment comment1 = new Comment("This is the first comment on John's post.", alice, johnsPost);
            Comment comment2 = new Comment("This is the second comment on John's post.", jane, johnsPost);
            Comment comment3 = new Comment("This is a comment on Jane's post.", john, janesPost);

            johnsPost.setComments(Arrays.asList(comment1, comment2));
            janesPost.setComments(Arrays.asList(comment3));

            // Save the posts again to persist the comments
            postRepository.save(johnsPost);
            postRepository.save(janesPost);
        }
    }
}
