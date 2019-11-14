package demo.blog.config.shiro;

import demo.blog.model.Power;
import demo.blog.model.Role;
import demo.blog.model.User;
import demo.blog.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        AuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String email = (String) principals.getPrimaryPrincipal();
        User user = userService.getUserByEmail(email);
        Role role = user.getRole();
        System.out.println(user);
        ((SimpleAuthorizationInfo) authorizationInfo).addRole(role.getRoleName());
        for(Power power : role.getPowers()){
            ((SimpleAuthorizationInfo) authorizationInfo).addStringPermission(power.getPower());
        }
       /* for(Role role : user.getRoles()){
            authorizationInfo.addRole(role.getRole_name());
            for(Right right : role.getRights()){
                authorizationInfo.addStringPermission(right.getRight_url());
            }
        }*/
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String email = (String) token.getPrincipal();
        User user = userService.getUserByEmail(email);
        if(user == null){
            return null;
        }
        ByteSource salt = ByteSource.Util.bytes(user.getCredentialsSalt());
        //credentialsSalt = ByteSource.Util.bytes(bean.getName());
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
            user.getEmail(),user.getPassword(),salt,getName()
        );
        return info;
    }
}
