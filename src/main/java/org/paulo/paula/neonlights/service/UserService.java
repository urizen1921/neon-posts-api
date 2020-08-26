package org.paulo.paula.neonlights.service;

import org.paulo.paula.neonlights.model.Post;
import org.paulo.paula.neonlights.model.User;

import java.util.List;

public interface UserService {

    User get(String id);

    User getByUserId(String id);

    List<User> list();

    User save(User user);

    User update(User user);

    void removeUser(String id);

}
