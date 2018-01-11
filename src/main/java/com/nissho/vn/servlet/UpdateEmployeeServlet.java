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
import com.nissho.vn.model.Employee;

@WebServlet("/update")
public class UpdateEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeDao employeeDao = new EmployeeDaoImpl();

    public UpdateEmployeeServlet() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        int empId = Integer.parseInt(request.getParameter("emp_id"));
        String name = (String) request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String sex = (String) request.getParameter("sex");
        int deptId = Integer.parseInt(request.getParameter("department"));

        try {
            employeeDao.updateEmployee(new Employee(empId, name, deptId, age, sex));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        response.sendRedirect("index");
    }

}
