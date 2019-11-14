package demo.blog.dao;

import demo.blog.model.Power;
import demo.blog.model.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleDao {

    Role getRoleById(Integer id);

    List<Power> getPowerById(Integer id);
}
