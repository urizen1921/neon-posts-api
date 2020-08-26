package org.paulo.paula.neonlights.service;

import org.paulo.paula.neonlights.model.User;
import org.paulo.paula.neonlights.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User get(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User getByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.insert(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void removeUser(String id) {

        User user = userRepository.findById(id).orElse(null);

        if(user != null) {
            userRepository.delete(user);
        }
    }
}
