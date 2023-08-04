package com.estudo.Project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.estudo.Project.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
