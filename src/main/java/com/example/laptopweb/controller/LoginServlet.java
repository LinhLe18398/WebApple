package com.example.laptopweb.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Login", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username.equals("admin") && password.equals("a")){
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            resp.sendRedirect("/phones");
//            RequestDispatcher requestDispatcher = req.getRequestDispatcher("list.jsp");
//            req.setAttribute("username",username);
//            requestDispatcher.forward(req,resp);
        }else {
            resp.sendRedirect("login-error.jsp");
        }
    }
}
