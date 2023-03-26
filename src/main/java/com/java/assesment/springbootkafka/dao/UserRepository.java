package com.java.assesment.springbootkafka.dao;

import com.java.assesment.springbootkafka.dto.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
