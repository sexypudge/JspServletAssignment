package com.nissho.vn.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nissho.vn.dao.EmployeeDao;
import com.nissho.vn.daoImpl.EmployeeDaoImpl;
import com.nissho.vn.model.Employee;

@WebServlet("/")
public class EmployeeManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public EmployeeDao employeeDao = new EmployeeDaoImpl();   
    
    public EmployeeManagementServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Employee> listEmployees = null;
		try {
			listEmployees = employeeDao.getAllEmployees();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("listEmployees", listEmployees);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
