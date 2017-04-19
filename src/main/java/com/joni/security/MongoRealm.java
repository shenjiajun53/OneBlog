package com.joni.security;

import com.joni.model.Role;
import com.joni.model.User;
import com.joni.repository.UserRepository;
import com.joni.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by shenjj on 2017/4/19.
 */

@Component
public class MongoRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;

    public MongoRealm() {
        setName("SampleRealm"); //This name must match the name in the User class's getPrincipals() method
//        setCredentialsMatcher(new Sha256CredentialsMatcher());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userId = (String) principals.fromRealm(getName()).iterator().next();
        User user = userService.findUserById(userId);
        if (user != null) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            for (Role role : user.getRoles()) {
                info.addRole(role.getName());
                info.addStringPermissions(role.getPermissions());
            }
            return info;
        } else {
            return null;
        }
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        if (null == token) {
            return null;
        }
        System.out.printf("111111111 username =" + token.getUsername());
        User user = userService.findUserByName(token.getUsername());
        if (user != null) {
            return new SimpleAuthenticationInfo(user.getId(), user.getPass(), getName());
        } else {
            return null;
        }
    }
}
