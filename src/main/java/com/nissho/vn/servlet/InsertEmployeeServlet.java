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
    
	private static final int INCREASE_ID_BY_1 = 1;
	
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
		response.setContentType("text/html; charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    request.setCharacterEncoding("UTF-8");
	    
		int lastId = employeeDao.getLastId();
		
		String name = (String) request.getParameter("name");
		int age =  Integer.parseInt(request.getParameter("age"));
		String sex = (String) request.getParameter("sex");
		int deptId = Integer.parseInt(request.getParameter("department"));
		
		if(sex == null) {
			sex = "";
		}
		
		try {
			employeeDao.insertEmployee(new Employee(lastId+INCREASE_ID_BY_1, name, deptId, age, sex));
			response.sendRedirect("index");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}

}
