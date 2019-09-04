package com.example.demo.logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.Getter;
import lombok.Setter;

@Component
@Scope(scopeName = "session",proxyMode = ScopedProxyMode.TARGET_CLASS)
@Getter
@Setter
public class LoggingUtil {

    private String uri;
    private String callerIp;
    private String authorization;

    public LoggingUtil() {
        HttpServletRequest httpServletRequest = 
                ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        this.uri = httpServletRequest.getRequestURI();
        this.callerIp = httpServletRequest.getRemoteAddr();
        this.authorization = httpServletRequest.getHeader("Authorization");
    }

    public void log() {
        System.out.println("URI is "+this.uri+" Caller IP is "+this.callerIp+"authorization id is "+this.authorization);
    }
}
