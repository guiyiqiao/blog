package demo.blog.controller;

import demo.blog.config.shiro.PasswordHelper;
import demo.blog.model.User;
import demo.blog.model.Vo.UserVo;
import demo.blog.service.UserService;
import demo.blog.util.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    //BindingResult br 需紧跟Valid后
    public Result login(@RequestBody @Valid UserVo userVo, BindingResult br ,HttpServletRequest request){
        System.out.println(userVo);
        if(br.hasErrors()){
            StringBuffer buffer = new StringBuffer();
            for (FieldError error : br.getFieldErrors()){
                buffer.append(error.getDefaultMessage()+"<br/>");
            }
            return new Result(0,new String(buffer));
        }
        System.out.println(request.getSession().getAttribute("captcha"));
        if(!userVo.getCaptcha().equals(request.getSession().getAttribute("captcha"))){
            return new Result(0,"验证码错误！");
        }
        User user = userVo.toUser();
        System.out.println(user);
        // 1.获取Subject
        Subject subject = SecurityUtils.getSubject();

        // 2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(user.getEmail(), user.getPassword());
        try{
            // 3.执行登录方法
            subject.login(token);
        }catch (Exception e){
            return new Result(0,"账号或密码错误");
        }
        subject.getSession().setTimeout(60);
        return new Result(1,"登陆成功!");
    }
    @PostMapping("/enroll")
    public Result enroll(@RequestBody @Valid User user, BindingResult result){
        if(result.hasErrors()){
            StringBuffer buffer = new StringBuffer();
            for (FieldError error : result.getFieldErrors()){
                buffer.append(error.getDefaultMessage()+"<br/>");
            }
            return new Result(0,new String(buffer));
        }
        if(userService.getUserByEmail(user.getEmail())!=null){
            return new Result(0,"该用户已注册！");
        }
        new PasswordHelper().encryptPassword(user);
        user.setRoleId(1);
        user.setStatus(1);

        user = userService.addUser(user);
        return new Result(1,"注册成功！");
    }
}
