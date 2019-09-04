package com.example.demo.logger;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class LoggingUtilTestWithMocks {
    private LoggingUtil loggingUtil;

    @Mock
    private HttpServletRequest httpServletRequest;

    @Before
    public void setUpBeforeClass() {
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(httpServletRequest));
    }

    @Test
    public final void testLoggingUtil() {
        when(httpServletRequest.getRequestURI()).thenReturn("/foo");
        when(httpServletRequest.getRemoteAddr()).thenReturn("10.1.1.11");
        when(httpServletRequest.getHeader("Authorization")).thenReturn("xAuth");
        loggingUtil = new LoggingUtil();

        String requestURI = ReflectionTestUtils.getField(loggingUtil, "uri").toString();
        assertEquals(requestURI, "/foo");
        String authorization = ReflectionTestUtils.getField(loggingUtil, "authorization").toString();
        assertEquals(authorization, "xAuth");
        String callerIp = ReflectionTestUtils.getField(loggingUtil, "callerIp").toString();
        assertEquals(callerIp, "10.1.1.11");
    }
}
