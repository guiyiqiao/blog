package demo.blog.service.impl;

import demo.blog.dao.UserDao;
import demo.blog.model.User;
import demo.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public User getUserByEmail(String email) {
        User user = userDao.selectUserByEmail(email);
        if(user==null) return null;
        return userDao.selectUser(user.getId());
    }

    @Override
    @Transactional
    public User addUser(User user) {
        userDao.insertUser(user);
        System.out.println(user);
        return user;
    }
}
