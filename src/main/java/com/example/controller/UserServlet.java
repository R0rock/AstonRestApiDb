package com.example.controller;

import com.example.dto.UserDTO;
import com.example.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@WebServlet("/users/*")
public class UserServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(UserServlet.class);

    private final UserService userService;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Validator validator;

    public UserServlet(UserService userService) {
        this.userService = userService;
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();

        try {
            if (pathInfo == null || pathInfo.equals("/")) {
                logger.info("Fetching all users");
                List<UserDTO> users = userService.findAll();
                resp.getWriter().write(objectMapper.writeValueAsString(users));
            } else {
                Long id = Long.valueOf(pathInfo.split("/")[1]);
                logger.info("Fetching user by ID: {}", id);

                Optional<UserDTO> user = userService.findById(id);
                if (user.isPresent()) {
                    resp.getWriter().write(objectMapper.writeValueAsString(user.get()));
                } else {
                    resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                }
            }
        } catch (NumberFormatException e) {
            logger.error("Invalid ID format", e);
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } catch (JsonProcessingException e) {
            logger.error("JSON Processing error", e);
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } catch (IOException e) {
            logger.error("IO error", e);
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            UserDTO userDTO = objectMapper.readValue(req.getInputStream(), UserDTO.class);
            logger.info("Creating user: {}", userDTO.getName());

            Set<ConstraintViolation<UserDTO>> violations = validator.validate(userDTO);
            if (!violations.isEmpty()) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                resp.getWriter().write("Validation errors: " + violations);
                return;
            }

            UserDTO savedUser = userService.save(userDTO);
            resp.getWriter().write(objectMapper.writeValueAsString(savedUser));
        } catch (JsonProcessingException e) {
            logger.error("JSON Processing error", e);
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } catch (IOException e) {
            logger.error("IO error", e);
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Long id = Long.valueOf(req.getPathInfo().split("/")[1]);
            logger.info("Deleting user by ID: {}", id);
            userService.deleteById(id);
            resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } catch (NumberFormatException e) {
            logger.error("Invalid ID format", e);
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } catch (Exception e) {
            logger.error("Error processing request", e);
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}

//
//import com.example.dto.UserDTO;
//import com.example.service.UserService;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
////import org.hibernate.mapping.Set;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//import javax.validation.ConstraintViolation;
//import javax.validation.Valid;
//import java.util.Set;
//import javax.validation.Validation;
//import javax.validation.Validator;
//import javax.validation.ValidatorFactory;
//
//
//@WebServlet("/users/*")
//public class UserServlet extends HttpServlet {
//    private static final Logger logger = LoggerFactory.getLogger(UserServlet.class);
//
//    private final UserService userService;
//    private final ObjectMapper objectMapper = new ObjectMapper();
//    private final Validator validator;
//
//    public UserServlet(UserService userService) {
//        this.userService = userService;
//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//        this.validator = factory.getValidator();
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String pathInfo = req.getPathInfo();
//        try {
//            if (pathInfo == null || pathInfo.equals("/")) {
//                logger.info("Fetching all users");
//                List<UserDTO> users = userService.findAll();
//                resp.getWriter().write(objectMapper.writeValueAsString(users));
//            } else {
//                Long id = Long.valueOf(pathInfo.split("/")[1]);
//                logger.info("Fetching user by ID: {}", id);
//                userService.findById(id).ifPresentOrElse(
//                        user -> resp.getWriter().write(objectMapper.writeValueAsString(user)),
//                        () -> resp.setStatus(HttpServletResponse.SC_NOT_FOUND)
//                );
//            }
//        } catch (IOException | JsonProcessingException e) {
//            logger.error("Error processing request", e);
//            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        try {
//            UserDTO userDTO = objectMapper.readValue(req.getInputStream(), UserDTO.class);
//            logger.info("Creating user: {}", userDTO.getName());
//
//            Set<ConstraintViolation<UserDTO>> violations = validator.validate(userDTO);
//            if (!violations.isEmpty()) {
//                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//                resp.getWriter().write("Validation errors: " + violations);
//                return;
//            }
//
//            UserDTO savedUser = userService.save(userDTO);
//            resp.getWriter().write(objectMapper.writeValueAsString(savedUser));
//        } catch (IOException | JsonProcessingException e) {
//            logger.error("Error processing request", e);
//            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @Override
//    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        try {
//            Long id = Long.valueOf(req.getPathInfo().split("/")[1]);
//            logger.info("Deleting user by ID: {}", id);
//            userService.deleteById(id);
//            resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
//        } catch (Exception e) {
//            logger.error("Error processing request", e);
//            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//        }
//    }
//}