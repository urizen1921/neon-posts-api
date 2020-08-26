package org.paulo.paula.neonlights.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

@Document(collection = "posts")
public class Post {

    @Id
    private String id;

    private User user;

    private String post;

    private Set<String> likes = new HashSet<>();

    private Collection<Post> replies = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Set<String> getLikes() {
        return likes;
    }

    public void setLikes(Set<String> likes) {
        if(likes != null) {
            this.likes = likes;
        }
    }

    public Collection<Post> getReplies() {
        return replies;
    }

    public void setReplies(Collection<Post> replies) {
        this.replies = replies;
    }
}
