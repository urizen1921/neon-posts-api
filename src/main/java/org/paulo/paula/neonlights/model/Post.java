package org.paulo.paula.neonlights.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "posts")
public class Post {

    @Id
    private String id;

    @TextIndexed
    private String userId;

    @TextIndexed
    private String userName;

    private String post;

    @Indexed(direction = IndexDirection.DESCENDING)
    private int likes;

    public Post(String userId,
                String userName,
                String post) {

        this.userId = userId;
        this.userName = userName;
        this.post = post;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPost() {
        return post;
    }

    public int getLikes() {
        return likes;
    }
}
