package org.paulo.paula.neonlights.service.mock;

import org.paulo.paula.neonlights.model.Post;
import org.paulo.paula.neonlights.persistence.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

@Service
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

        Post post = new Post();
        post.setUserId("929jsdfj2023");
        post.setUserName("paulo");
        post.setPost("Hi, this is the first post!!!!");

        Post post2 = new Post();
        post2.setUserId("sdfdsfsdf");
        post2.setUserName("jovem");
        post2.setPost("Hi, this is the second post!!!!");

        Post post3 = new Post();
        post3.setUserId("21321fwef");
        post3.setUserName("Vera");
        post3.setPost("Hi, guys!");

        Collection<Post> initialPosts = Arrays.asList(post, post2, post3);

        this.postRepository.insert(initialPosts);

    }
}


