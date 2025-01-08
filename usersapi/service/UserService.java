package com.example.usersapi.service;

import com.example.usersapi.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    private final Map<UUID, User> userStorage = new HashMap<>();

    public User createUser(User user) {
        user.setId(UUID.randomUUID());
        userStorage.put(user.getId(), user);
        return user;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userStorage.values());
    }

    public User getUserById(UUID id) {
        return userStorage.get(id);
    }

    public User updateUser(UUID id, User user) {
        if (!userStorage.containsKey(id)) {
            return null;
        }
        user.setId(id);
        userStorage.put(id, user);
        return user;
    }

    public boolean deleteUser(UUID id) {
        return userStorage.remove(id) != null;
    }
}
