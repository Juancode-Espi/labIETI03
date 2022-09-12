package com.labIETI.user.service.impl;

import com.labIETI.user.entities.User;
import com.labIETI.user.repository.UserRepository;
import com.labIETI.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceMongoDB implements UserService {

    public final UserRepository userRepository;
    @Override
    public User create(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User findById(Long id) {
        if(userRepository.existsById(id))
            return userRepository.findById(id).get();
        else return null;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        if(userRepository.existsById(id))
            userRepository.deleteById(id);
    }

    @Override
    public User update(User user, Long id) {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            userRepository.save(user);
        }
        return user;
    }
}
