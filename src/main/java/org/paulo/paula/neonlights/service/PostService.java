package org.paulo.paula.neonlights.service;


import org.paulo.paula.neonlights.model.Post;

import java.util.List;

public interface PostService {

    Post get(String id);

    List<Post> list();

    Post save(Post post);

    Post update(Post post);

    void removePost(String id);

}
