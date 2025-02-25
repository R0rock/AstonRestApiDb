package com.example.controller;

import com.example.dto.UserDTO;
import com.example.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/users/*")
public class UserServlet extends HttpServlet {

    private final UserService userService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public UserServlet(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            List<UserDTO> users = userService.findAll();
            resp.getWriter().write(objectMapper.writeValueAsString(users));
        } else {
            Long id = Long.valueOf(pathInfo.split("/")[1]);
            userService.findById(id).ifPresentOrElse(
                    user -> resp.getWriter().write(objectMapper.writeValueAsString(user)),
                    () -> resp.setStatus(HttpServletResponse.SC_NOT_FOUND)
            );
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDTO userDTO = objectMapper.readValue(req.getInputStream(), UserDTO.class);
        UserDTO savedUser = userService.save(userDTO);
        resp.getWriter().write(objectMapper.writeValueAsString(savedUser));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getPathInfo().split("/")[1]);
        userService.deleteById(id);
        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
}