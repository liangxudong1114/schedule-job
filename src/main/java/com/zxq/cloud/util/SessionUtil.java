package com.zxq.cloud.util;

import cn.hutool.core.util.StrUtil;
import com.zxq.cloud.model.po.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author zxq
 * @date 2020/3/27 14:09
 **/
public class SessionUtil {

    private static HttpSession session = getSession();

    /**
     * 登录验证码存放在session的key
     */
    public static final String VERITY_CODE_IN_SESSION_KEY = "USER_AUTH_VERITY_CODE";

    /**
     * 用户信息存放在session的key
     */
    public static final String USER_INFO_IN_SESSION_KEY = "USER_INFO";

    /**
     * 获取session
     * @return
     */
    private static HttpSession getSession() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attrs.getRequest().getSession();
    }

    /**
     * 将登录验证码存放在session中
     * @param verityCode
     */
    public static void putVerityCode(String verityCode) {
        if (StrUtil.isNotBlank(verityCode)) {
            session.setAttribute(VERITY_CODE_IN_SESSION_KEY, verityCode);
        }
    }

    /**
     * 获取session中的登录验证码
     */
    public static String getVerityCode() {
        return (String) session.getAttribute(VERITY_CODE_IN_SESSION_KEY);
    }

    /**
     * 删除session中的登录验证码
     */
    public static void removeVerityCode() {
        session.removeAttribute(VERITY_CODE_IN_SESSION_KEY);
    }

    /**
     * 将用户信息存放在session中
     * @param user
     */
    public static void putUserInfo(User user) {
        if (user != null) {
            session.setAttribute(USER_INFO_IN_SESSION_KEY, user);
        }
    }

    /**
     * 删除session中的用户信息
     */
    public static void removeUserInfo() {
        session.removeAttribute(USER_INFO_IN_SESSION_KEY);
    }

    /**
     * 获取session中的用户信息
     * @return
     */
    public static User getUserInfo() {
        return (User) session.getAttribute(USER_INFO_IN_SESSION_KEY);
    }

}
