package com.xiangyang.shiro.realm;

import com.xiangyang.AO.UserAO;
import com.xiangyang.BizResult;
import com.xiangyang.contants.SessionContants;
import com.xiangyang.enums.RoleEnum;
import com.xiangyang.model.UserDO;
import com.xiangyang.util.UserUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by xiangyang on 17/1/17.
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserAO userAO;

    /**
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserDO userDO = UserUtil.getUser();
        authorizationInfo.addRole(RoleEnum.getDescByCode(userDO.getRole()));
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String email = (String) authenticationToken.getPrincipal();
        BizResult<UserDO> bizResult = userAO.queryUserDOByEmail(email);
        if (!bizResult.isSuccess()){
            return null;
        }
        UserDO userDO = bizResult.getResult();
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        session.setAttribute(SessionContants.USER_DO_KEY,userDO);
        return new SimpleAuthenticationInfo(userDO,userDO.getPassword(),getName());
    }
}
