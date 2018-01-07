package com.nissho.vn.dao;

import java.sql.SQLException;
import java.util.List;

import com.nissho.vn.model.Employee;

public interface EmployeeDao {
	List<Employee> getAllEmployees() throws SQLException;
	
}
