package com.atguigu.crm.shiro;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.atguigu.crm.entity.Authority;
import com.atguigu.crm.entity.User;
import com.atguigu.crm.service.UserService;

public class CrmShiroRealm extends AuthorizingRealm{
	
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	//分配权限
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		
		User user = (User) arg0.getPrimaryPrincipal();
		
		Set<String> roles = new HashSet<>();
		
		for (Authority auth : user.getRole().getAuthorities()) {
			roles.add(auth.getName());
		}
		
		System.out.println("权限:" + roles);
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
		
		return info;
	}
	
	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken arg0) throws AuthenticationException {
		
		UsernamePasswordToken token = (UsernamePasswordToken) arg0;
		
		//3. 調用 Service 或 Dao 方法利用 username 來獲取數據表中當前用戶的信息
		User user = userService.getUserByName(token.getUsername());
		
		if(user == null){
			throw new UnknownAccountException("用戶不存在！");
		}
		if(user.getEnabled() != 1) {
			throw new LockedAccountException("用户不可用！");
		}
		Object principal = user;
		Object hashedCredentials = user.getPassword();
		ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSalt());
		String realmName = getName();
		
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, hashedCredentials, credentialsSalt, realmName);
		
		return info;
	}
	
	public static void main(String[] args) {
		Object result = new SimpleHash("MD5", "123456", ByteSource.Util.bytes("ceadfd47cdaa814c"), 1024);
		System.out.println(result);
	}
}
