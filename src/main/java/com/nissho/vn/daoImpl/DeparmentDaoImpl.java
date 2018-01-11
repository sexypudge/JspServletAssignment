package com.nissho.vn.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nissho.vn.dao.DepartmentDao;
import com.nissho.vn.model.Department;
import com.nissho.vn.util.ConnectionUtil;

public class DeparmentDaoImpl implements DepartmentDao {

    public List <Department> getAllDepartments() throws SQLException {
        Connection con = ConnectionUtil.loadDriver();

        String query = "SELECT * FROM department";

        List <Department> listDepartments = new ArrayList <Department>();

        ResultSet rs = ConnectionUtil.getResultSet(query, con);
        try {
            while (rs.next()) {
                int deptid = rs.getInt("deptid");
                String deptName = rs.getString("dept_name");
                String dirName = rs.getString("dir_name");

                listDepartments.add(new Department(deptid, deptName, dirName));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionUtil.closeConnection(con);
        }

        return listDepartments;
    }

}
