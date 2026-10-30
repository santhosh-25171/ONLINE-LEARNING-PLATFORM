package com.learning.services;

import com.learning.models.User;
import com.learning.repository.UserRepository;

public class UserService extends CrudService<User> {
    private final UserRepository users;

    public UserService(UserRepository users) {
        super(users);
        this.users = users;
    }

    @Override
    protected void validate(User user) {
        require(user != null, "User cannot be null");
        requireText(user.getName(), "Name");
        requireText(user.getEmail(), "Email");
        require(user.getEmail().contains("@"), "Email must be valid");
        requireText(user.getPassword(), "Password");
        requireText(user.getRole(), "Role");
        String role = user.getRole().trim();
        require("STUDENT".equalsIgnoreCase(role) || "INSTRUCTOR".equalsIgnoreCase(role)
                || "ADMIN".equalsIgnoreCase(role), "Role must be STUDENT, INSTRUCTOR, or ADMIN");
        User existing = users.findByEmail(user.getEmail());
        require(existing == null || existing.getUserId() == user.getUserId(),
                "Email is already registered");
    }
}
