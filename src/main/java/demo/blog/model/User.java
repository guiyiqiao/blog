package demo.blog.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;


@Data
@NoArgsConstructor
public class User implements Serializable {
    private static final Long serialVersionUID = 1L;

    private Integer id;

    @Email(message = "邮箱格式错误！")
    @NotEmpty(message = "邮箱不能为空！")
    private String email;
    @NotEmpty(message = "密码不能为空！")
    private String password;
    private String salt;
    @NotEmpty(message = "昵称不能为空！")
    private String nickname;
    private Integer status;
    private Integer roleId;

    private Role role;
    private List<Power> powers;

    public User(String email, String password, String salt, String nickname, Integer status) {
        this.email = email;
        this.password = password;
        this.salt = salt;
        this.nickname = nickname;
        this.status = status;
    }
    public String getCredentialsSalt(){
        return this.email+this.salt;
    }
}
