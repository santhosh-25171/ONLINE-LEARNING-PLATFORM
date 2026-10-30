package com.learning.CLI;

import com.learning.models.User;
import com.learning.services.UserService;
import java.util.Scanner;

public final class UserCLI extends CrudMenu<User> {
    public UserCLI(UserService service) {
        super("Users", service);
    }

    @Override
    protected User readEntity(Scanner input) {
        int id = CliInput.readInt(input, "User ID: ");
        String name = CliInput.readLine(input, "Name: ");
        String email = CliInput.readLine(input, "Email: ");
        String password = CliInput.readLine(input, "Password: ");
        int roleChoice = CliInput.readChoice(input,
                "Role (1=Student, 2=Instructor, 3=Admin): ", 1, 3);
        String role = roleChoice == 1 ? "STUDENT"
                : roleChoice == 2 ? "INSTRUCTOR" : "ADMIN";
        return new User(id, name, email, password, role);
    }

    @Override
    protected String describe(User user) {
        return "User{id=" + user.getUserId() + ", role=" + user.getRole()
                + ", name='" + user.getName() + "', email='" + user.getEmail() + "'}";
    }
}
