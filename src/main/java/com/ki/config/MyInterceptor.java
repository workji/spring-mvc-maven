package com.ki.config;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Map;

public class MyInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        System.out.println("Request Header Show:");
        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String key = headers.nextElement();
            System.out.println(key + " - " + request.getHeader(key));
        }

        // request performance check
        request.setAttribute("start_time", System.currentTimeMillis());

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {

        long start_time = (long)request.getAttribute("start_time");
        long end_time = System.currentTimeMillis();
        modelAndView.addObject("elapsed_time", (end_time-start_time));

        System.out.println("Interceptor postHandle:");
        Map<String, Object> maps = modelAndView.getModel();
        maps.entrySet().stream().forEach(data-> System.out.println(data.getKey() + " - " + data.getValue()));

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {
        System.out.println("Request Done.");
    }
}
