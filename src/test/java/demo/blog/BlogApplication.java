package demo.blog;

import demo.blog.config.shiro.PasswordHelper;
import demo.blog.dao.UserDao;
import demo.blog.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)

public class BlogApplication {
    @Resource
    private UserDao userDao;

    @Test
    public void userDao(){

    }
}
