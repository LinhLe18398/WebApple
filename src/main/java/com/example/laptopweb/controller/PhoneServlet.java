package com.example.laptopweb.controller;

import com.example.laptopweb.dao.PhoneDAO;
import com.example.laptopweb.model.Phone;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(value = "/phones")
public class PhoneServlet extends HttpServlet {
    private PhoneDAO phoneDAO;
    @Override
    public void init() throws ServletException {
        phoneDAO = new PhoneDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                try {
                    insertPhone(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
          switch (action){
              case "create":
                  showNewForm(req,resp);
                  break;

              case "delete":
                  try {
                      deletePhone(req,resp);
                  } catch (SQLException e) {
                      throw new RuntimeException(e);
                  }
                  break;

              case "search":
                  try {
                      searchByName(req,resp);
                  } catch (SQLException e) {
                      throw new RuntimeException(e);
                  }
                  break;


              default:
                  try {
                      listPhone(req,resp);
                  } catch (SQLException e) {
                      throw new RuntimeException(e);
                  }
                  break;
          }
        }

    private void searchByName(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String keyword = req.getParameter("keyword");
        List<Phone> phoneList = phoneDAO.selectAllPhone();
        if (keyword != null && !keyword.isEmpty()){
            phoneList = phoneDAO.searchByName(keyword);
        }
        req.setAttribute("phoneList",phoneList);
        req.getRequestDispatcher("list.jsp").forward(req,resp);

    }

    private void deletePhone(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        phoneDAO.deletePhone(id);
        List<Phone> phoneList = phoneDAO.selectAllPhone();
        req.setAttribute("phoneList",phoneList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("list.jsp");
        requestDispatcher.forward(req,resp);
    }


    private void insertPhone(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String name = req.getParameter("name");
        String brand = req.getParameter("brand");
        String color = req.getParameter("color");
        double price = Double.parseDouble(req.getParameter("price"));
        String urlImage = req.getParameter("urlImage");
        phoneDAO.insertPhone(new Phone(name,brand,color,price,urlImage));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("create.jsp");
        requestDispatcher.forward(req,resp);

    }


    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("create.jsp");
        requestDispatcher.forward(req,resp);
    }

    private void listPhone(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        List<Phone> phoneList = phoneDAO.selectAllPhone();
        req.setAttribute("phoneList",phoneList);
        System.out.println(phoneList.size());
        RequestDispatcher dispatcher = req.getRequestDispatcher("list.jsp");
        dispatcher.forward(req,resp);
    }

}

