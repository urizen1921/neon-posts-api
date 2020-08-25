package org.paulo.paula.neonlights.service;

import org.paulo.paula.neonlights.model.Post;
import org.paulo.paula.neonlights.persistence.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    private PostRepository postRepository;

    @Autowired
    public void setPostRepository(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post get(String id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public List<Post> list() {
        Sort sortByCreationDate = Sort.by("creationTime").descending();
        return postRepository.findAll(sortByCreationDate);
    }

    @Override
    public Post save(Post post) {
        return postRepository.insert(post);
    }

    @Override
    public Post update(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void removePost(String id) {
        Post post = postRepository.findById(id).orElse(null);

        if(post != null) {
            postRepository.delete(post);
        }
    }
}

