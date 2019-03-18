package com.ainijar.modules.sys.shiro;

import com.ainijar.modules.sys.model.User;
import com.ainijar.modules.sys.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 系统安全认证实现类
 * @author slt
 * @version 2018-08-29
 */

@Slf4j
@Service
public class ShiroRealm extends AuthorizingRealm {

	@Autowired
	IUserService iUserService;

	/**
	 * 认证回调函数, 登录时调用
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		// 校验用户名密码
		User user = iUserService.getUserByLoginName(token.getUsername());
		if (user != null) {
			SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), getName());
			return authenticationInfo;
		} else {
			throw new UnknownAccountException("账号或密码不正确");
		}
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		SimpleAuthorizationInfo authenticationInfo = new SimpleAuthorizationInfo();
		principalCollection.getPrimaryPrincipal();
		return authenticationInfo;
	}


}

