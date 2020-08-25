package org.paulo.paula.neonlights.persistence;

import org.paulo.paula.neonlights.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends MongoRepository<Post, String> {


}
