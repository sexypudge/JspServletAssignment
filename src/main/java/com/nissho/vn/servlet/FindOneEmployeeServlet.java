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

@WebServlet("/findOne")
public class FindOneEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDao employeeDao = new EmployeeDaoImpl();  
	private DepartmentDao departmentDao = new DeparmentDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindOneEmployeeServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    request.setCharacterEncoding("UTF-8");
	    
	    int idToBeModified = Integer.parseInt(request.getParameter("emp_id"));
	    
	    Employee employeeToBeModified = null;
		List<Employee> listEmployees = null;
		List<Department> listDepartments = null;
		try {
			listEmployees = employeeDao.getAllEmployees();
			listDepartments = departmentDao.getAllDepartments();
			employeeToBeModified = employeeDao.getEmployeeById(idToBeModified);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("listEmployees", listEmployees);
		request.setAttribute("listDepartments", listDepartments);
		request.setAttribute("employeeToBeModified", employeeToBeModified);
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
