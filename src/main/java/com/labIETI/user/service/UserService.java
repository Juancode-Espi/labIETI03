package com.labIETI.user.service;

import com.labIETI.user.entities.User;

import java.util.List;

public interface UserService {

    User create(User user);

    User findById(Long id);

    List<User> getAll();

    void deleteById(Long id);

    User update(User user, Long id);
}
