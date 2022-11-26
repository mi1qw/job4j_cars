package com.example.car;

import com.example.car.web.UserSession;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;

@TestConfiguration
@Slf4j
@Getter
public class SessionTracking implements ResultHandler {
    private MockHttpSession lastSession = new MockHttpSession();
    private UserSession userSession;
    @Autowired
    private UserTestSession userTestSession;

    @Override
    public void handle(final MvcResult result) {
        lastSession = (MockHttpSession) result.getRequest().getSession(false);
        assert lastSession != null;
        userSession = (UserSession) lastSession.getAttribute("scopedTarget.userSession");
        if (userSession != null) {
            userTestSession.setUserSession(userSession);
        } else {
            log.warn("userSession null");
        }
        log.info("session ID {}", lastSession.getId());
    }
}
