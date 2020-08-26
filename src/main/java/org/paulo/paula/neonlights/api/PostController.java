package org.paulo.paula.neonlights.api;

import org.paulo.paula.neonlights.model.Post;
import org.paulo.paula.neonlights.model.User;
import org.paulo.paula.neonlights.persistence.PostRepository;
import org.paulo.paula.neonlights.service.PostService;
import org.paulo.paula.neonlights.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collection;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("neon/api")
public class PostController {

    private PostService postService;
    private UserService userService;

    @Autowired
    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public Collection<Post> all() {
        return postService.list();
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public ResponseEntity<?> insert(@RequestBody Post post, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {

        if(bindingResult.hasErrors() || post.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        User user = this.userService.getByUserId(post.getUser().getUserId());

        if(user == null) {
            this.userService.save(post.getUser());
        }

        Post savedPost = this.postService.save(post);

        UriComponents uriComponents = uriComponentsBuilder.path("/neon/api/" + savedPost.getId()).build();

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping
    public void update(@RequestBody Post post) {

        Post postToUpdate = this.postService.get(post.getId());

        if(postToUpdate != null) {
            this.postService.update(post);
        }

    }
}
