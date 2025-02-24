package org.example.projects.Servlets;


import org.example.projects.Implementation_of_services.UserService;
import org.example.projects.communications.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
    private final UserService userService;

    public UserServlet(UserService userService) {
        [this.userService](this.userService) = userService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserDTO> users = [userService.getAllUsers()](userService.getAllUsers());
        // Заполнение ответа
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Получение данных из запроса
        // Создание нового пользователя
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Получение данных из запроса
        // Обновление существующего пользователя
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Получение идентификатора пользователя из запроса
        // Удаление пользователя
    }
}