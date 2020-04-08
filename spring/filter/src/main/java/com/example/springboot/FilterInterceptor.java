package com.example.springboot;


import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class FilterInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(
        HttpServletRequest request,
        HttpServletResponse response, 
        Object handler) throws Exception {
        
 HandlerMethod hm = (HandlerMethod) handler;
        Method method = hm.getMethod();

        // Check if method is annotated to require this Secret Authorization
        if ((method.getDeclaringClass().isAnnotationPresent(RestController.class) ||
             method.getDeclaringClass().isAnnotationPresent(Controller.class)) &&
            method.isAnnotationPresent(FilterEndpoint.class)) {
            System.out.println("handle it: " + getRemoteAddr(request));
        }


        return true;
    }


    private String getRemoteAddr(HttpServletRequest request) {
        String ipFromHeader = request.getHeader("X-FORWARDED-FOR");
        if (ipFromHeader != null && ipFromHeader.length() > 0) {
            return ipFromHeader;
        }
    return request.getRemoteAddr();
}


}
