package org.paulo.paula.neonlights.service.mock;

import org.paulo.paula.neonlights.model.Post;
import org.paulo.paula.neonlights.model.User;
import org.paulo.paula.neonlights.persistence.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

//@Service
public class DBSeeder implements CommandLineRunner {

    private PostRepository postRepository;
    private MongoTemplate mongoTemplate;

    public DBSeeder(PostRepository postRepository, MongoTemplate mongoTemplate) {
        this.postRepository = postRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        this.postRepository.deleteAll();
        this.mongoTemplate.dropCollection(User.class);

        Post post = new Post();
        User user = new User();
        user.setUserId("3122394");
        user.setUserEmail("paulo.almeida.paula@gmail.com");
        user.setUserName("Paulo Paula");
        user.setRole("Subscriber");
        this.mongoTemplate.insert(user);
        post.setUser(user);
        post.setPost("Hi, this is the first post!!!!");
        post.getLikes().add("423523525");


        Post post2 = new Post();
        User user2 = new User();
        user2.setUserId("423523525");
        user2.setUserEmail("adfgdagdg@gmail.com");
        user2.setUserName("dFSDFER");
        user2.setRole("Admin");
        this.mongoTemplate.insert(user2);
        post2.setUser(user2);
        post2.setPost("Hi, this is the second post!!!!");

        Post post3 = new Post();
        User user3 = new User();
        user3.setUserId("3243242gdfg");
        user3.setUserEmail("asdczcsdcf@gmail.com");
        user3.setUserName("Jovem");
        user3.setRole("Subscriber");
        this.mongoTemplate.insert(user3);
        post3.setUser(user3);
        post3.setPost("Hi, guys!");

        Post postReplyTo1 = new Post();
        postReplyTo1.setUser(user3);
        postReplyTo1.setPost("I'm answering to " + user.getUserName() + " post. This is a reply test!");
        post.getReplies().add(postReplyTo1);

        Collection<Post> initialPosts = Arrays.asList(post, post2, post3);

        this.postRepository.insert(initialPosts);

    }
}


