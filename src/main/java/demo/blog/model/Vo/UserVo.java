package demo.blog.model.Vo;

import demo.blog.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVo {
    @NotEmpty(message = "邮箱不能为空！")
    @Email(message = "邮箱格式错误！")
    private String email;
    @NotEmpty(message = "密码不能为空！")
    private String password;
    @NotEmpty(message = "验证码不能为空！")
    private String captcha;

    public User toUser(){
        User user = new User();
        if(email.equals("root@126.com")){
            user.setEmail("root");
        }else
        user.setEmail(email);
        user.setPassword(password);
        return user;
    }
}
