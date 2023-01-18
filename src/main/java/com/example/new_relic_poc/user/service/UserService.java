package com.example.new_relic_poc.user.service;

import com.example.new_relic_poc.user.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    List<User> list();

    User getUser(Long id);

    void delete(Long id);

    User createOrUpdate(User user);

}
