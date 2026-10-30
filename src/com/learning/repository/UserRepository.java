package com.learning.repository;

import com.learning.models.User;

public class UserRepository extends InMemoryRepository<User> {
    public UserRepository() {
        super(User::getUserId);
    }

    public User findByEmail(String email) {
        if (email == null) {
            return null;
        }
        for (User user : findAll()) {
            if (email.equalsIgnoreCase(user.getEmail())) {
                return user;
            }
        }
        return null;
    }
}