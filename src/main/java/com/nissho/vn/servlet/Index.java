package com.nissho.vn.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nissho.vn.dao.DepartmentDao;
import com.nissho.vn.dao.EmployeeDao;
import com.nissho.vn.daoImpl.DeparmentDaoImpl;
import com.nissho.vn.daoImpl.EmployeeDaoImpl;
import com.nissho.vn.model.Department;
import com.nissho.vn.model.Employee;

@WebServlet("/index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EmployeeDao employeeDao = new EmployeeDaoImpl();   
    private DepartmentDao departmentDao = new DeparmentDaoImpl();
    
    public Index() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    request.setCharacterEncoding("UTF-8");
	    
		List<Employee> listEmployees = null;
		List<Department> listDepartments = null;
		try {
			listEmployees = employeeDao.getAllEmployees();
			listDepartments = departmentDao.getAllDepartments();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("listEmployees", listEmployees);
		request.setAttribute("listDepartments", listDepartments);
	
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
