package com.app.session.interceptor;

import com.app.session.constant.Role;
import com.app.session.exception.CustomAuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // controller에 진입하기 전에 실행이되고 반환 겂이 true일 경우 controller에 진입 false일 경우 진입하지 않는다.
        String role = (String)request.getSession().getAttribute("roel");

        // 인가(권한 부여) : 사용자에게 특정 리소스나 기능에 액세스할 수 있는 권한을 부여하는 프로세스
        if(role != null && role.equals(Role.MEMBER.name())){
            return true;
        }
        throw new CustomAuthenticationException();
    }
}
