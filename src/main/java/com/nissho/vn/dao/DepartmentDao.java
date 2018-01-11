package com.nissho.vn.dao;

import java.sql.SQLException;
import java.util.List;

import com.nissho.vn.model.Department;

public interface DepartmentDao {
    List <Department> getAllDepartments() throws SQLException;
}
