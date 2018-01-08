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

/**
 * Servlet implementation class InsertEmployeeServlet
 */

@WebServlet("/insert")
public class InsertEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDao employeeDao = new EmployeeDaoImpl();      
    
    public InsertEmployeeServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int lastId = employeeDao.getLastId();
		
		String name = (String) request.getAttribute("name");
		int age = (Integer) request.getAttribute("age");
		int deptId = (Integer) request.getAttribute("deptid");
		String sex = (String) request.getAttribute("sex");
		
		try {
			employeeDao.insertEmployee(new Employee(lastId+1, name, age, deptId, sex));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
