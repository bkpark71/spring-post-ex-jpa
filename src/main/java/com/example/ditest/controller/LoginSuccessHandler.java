package com.example.ditest.controller;

import com.example.ditest.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest req,
                                        HttpServletResponse resp,
                                        Authentication authentication) throws IOException, ServletException {
        HttpSession session = req.getSession();

        User user = (User)authentication.getPrincipal();
        session.setAttribute("userId", user.getUserId());
        session.setAttribute("name", user.getName());

        resp.sendRedirect("/posts");
    }
}
