package org.paulo.paula.neonlights.persistence;

import org.paulo.paula.neonlights.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByUserId(String userId);
}
