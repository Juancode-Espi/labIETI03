package com.labIETI.user.repository;

import com.labIETI.user.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository  extends MongoRepository<User, Long> {}
