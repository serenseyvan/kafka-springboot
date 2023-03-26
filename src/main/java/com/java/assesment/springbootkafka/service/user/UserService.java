package com.java.assesment.springbootkafka.service.user;

import com.java.assesment.springbootkafka.dao.UserRepository;
import com.java.assesment.springbootkafka.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser() {
        logger.info("Getting all user operation is started.");
        return userRepository.findAll();
    }

    public User getUserByName(String name) {
        List<User> users = getAllUser();
        User userByName = users.stream()
                .filter(user -> name.equals(user.getName()))
                .findAny()
                .orElse(null);
        return userByName;

    }

}
