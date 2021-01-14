package com.marcelsauter.aycuserservice.repository;

import com.marcelsauter.aycuserservice.model.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {
}
