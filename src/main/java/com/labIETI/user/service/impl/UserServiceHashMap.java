package com.labIETI.user.service.impl;

import com.labIETI.user.entities.User;
import com.labIETI.user.exception.UserNotFoundException;
import com.labIETI.user.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class UserServiceHashMap implements UserService {

    private final Map<Long,User> userMap = new HashMap<>();

    @Override
    public User create(User user) {
        userMap.put(user.getId(), user);
        return user;
    }

    @Override
    public User findById(Long id) {
        return userMap.get(id);
    }

    @Override
    public List<User> getAll() {
        return userMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        if(userMap.containsKey(id)) {
            userMap.remove(id);
        }else{
            throw new UserNotFoundException();
        }
    }

    @Override
    public User update(User user, Long id) {
        if(userMap.containsKey(id)) {
            userMap.remove(id);
            userMap.put(id, user);
            return user;
        }
        else{
            throw new UserNotFoundException();
        }
    }
}
