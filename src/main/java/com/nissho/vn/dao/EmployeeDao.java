package com.nissho.vn.dao;

import java.sql.SQLException;
import java.util.List;

import com.nissho.vn.model.Employee;

public interface EmployeeDao {
	List<Employee> getAllEmployees() throws SQLException;
	Employee getEmployeeById(int id) throws SQLException;
	int insertEmployee(Employee employee) throws SQLException;
	int getLastId();
	int removeEmployee(int id) throws SQLException;
	int updateEmployee(Employee employee) throws SQLException;
}
