package com.nissho.vn.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nissho.vn.dao.EmployeeDao;
import com.nissho.vn.model.Employee;
import com.nissho.vn.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	
	public List<Employee> getAllEmployees() {
		Connection con = ConnectionUtil.loadDriver();

		String query = "SELECT * FROM employee";
		
		List<Employee> listEmployees = new ArrayList<Employee>();
		
		ResultSet rs = ConnectionUtil.getResultSet(query, con);
		try {
			while(rs.next()) {
				int empId = rs.getInt("emp_id");
				String name = rs.getString("name");
				int deptId = rs.getInt("dept_id");
				int age = rs.getInt("age");
				String sex = rs.getString("sex");
				
				listEmployees.add(new Employee(empId, name, deptId, age, sex));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closeConnection(con);
		}
		
		return listEmployees;
	}

}
