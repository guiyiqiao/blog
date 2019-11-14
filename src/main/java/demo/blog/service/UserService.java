package demo.blog.service;

import demo.blog.model.User;

public interface UserService {
    User getUserByEmail(String email);
    User addUser(User user);
}
