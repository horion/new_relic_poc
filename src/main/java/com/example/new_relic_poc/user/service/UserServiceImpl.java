package com.example.new_relic_poc.user.service;

import com.example.new_relic_poc.user.model.User;
import com.example.new_relic_poc.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override public List<User> list() {
        return userRepository.findAll();
    }

    @Override public User getUser(Long id) {
        return userRepository.getReferenceById(id);
    }

    @Override public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override public User createOrUpdate(User user) {
        return userRepository.save(user);
    }

}
