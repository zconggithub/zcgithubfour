package com.shiro.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.shiro.entity.Module;
import com.shiro.entity.Role;
import com.shiro.entity.User;
import com.shiro.service.UserService;


/**
 * 
 * @classDesc: 功能描述:(类AuthRealm完成根据用户名去数据库的查询，并且将用户信息放入shiro中，供第二个类调用)
 * @author: 周聪  
 * @createTime: 2017年6月21日 上午10:06:19  
 * @version: v1.0  
 * @copyright:科瑞达科技
 */
public class AuthRealm extends AuthorizingRealm{
    @Autowired
    private UserService userService;
    
    //认证.登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken utoken=(UsernamePasswordToken) token;//获取用户输入的token
        String username = utoken.getUsername();
        User user = userService.findUserByUserName(username);
        return new SimpleAuthenticationInfo(user, user.getPassword(),this.getClass().getName());//放入shiro.调用CredentialsMatcher检验密码
    }
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        User user=(User) principal.fromRealm(this.getClass().getName()).iterator().next();//获取session中的用户
        List<String> permissions=new ArrayList<>();
        Set<Role> roles = user.getRoles();
        if(roles.size()>0) {
            for(Role role : roles) {
                Set<Module> modules = role.getModules();
                if(modules.size()>0) {
                    for(Module module : modules) {
                        permissions.add(module.getMname());
                    }
                }
            }
        }
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);//将权限放入shiro中.
        return info;
    }

}
/**
 * 授权的方法是在碰到<shiro:hasPermission>标签的时候调用的，它会去检测shiro框架中的权限
 * （这里的permissions）是否包含有该标签的name值，如果有，里面的内容显示，如果没有，里面的内容不予显示
 * （这就完成了对权限的认证）
 */
	

	


  
    