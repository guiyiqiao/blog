package demo.blog.dao;

import demo.blog.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    User selectUser(Integer id);

    User selectUserByEmail(String email);

    int insertUser(User user);

   /*
    int updateUser(User user);

    int deleteUser(Integer id);





    List<User> listUser(User user);

    Integer countUser();*/
}
