package com.nissho.vn.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nissho.vn.dao.EmployeeDao;
import com.nissho.vn.daoImpl.EmployeeDaoImpl;

@WebServlet("/remove")
public class RemoveEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeDao employeeDao = new EmployeeDaoImpl();

    public RemoveEmployeeServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));

        try {
            employeeDao.removeEmployee(employeeId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("index");
    }

}
