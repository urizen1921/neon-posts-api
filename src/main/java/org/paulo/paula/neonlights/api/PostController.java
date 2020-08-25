package org.paulo.paula.neonlights.api;

import org.paulo.paula.neonlights.model.Post;
import org.paulo.paula.neonlights.persistence.PostRepository;
import org.paulo.paula.neonlights.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("neon/api")
public class PostController {

    private PostService postService;

    @Autowired
    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/all")
    public Collection<Post> all() {
        return postService.list();
    }
}
