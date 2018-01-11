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

    public List <Employee> getAllEmployees() {
        Connection con = ConnectionUtil.loadDriver();

        String query = "SELECT * FROM employee";

        List <Employee> listEmployees = new ArrayList <Employee>();

        ResultSet rs = ConnectionUtil.getResultSet(query, con);
        try {
            while (rs.next()) {
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

    public int insertEmployee(Employee employee) throws SQLException {
        Connection con = ConnectionUtil.loadDriver();
        String query = "INSERT INTO employee VALUES " + "(" + employee.getEmpId() + ",'" + employee.getName() + "'," + employee.getDeptId() + "," + employee.getAge() + ",'" + employee.getSex() + "')";
        return ConnectionUtil.runQuery(query, con);
    }

    public int getLastId() {
        Connection con = ConnectionUtil.loadDriver();
        String query = "SELECT MAX(emp_id) FROM employee";
        int empId = 0;

        ResultSet rs = ConnectionUtil.getResultSet(query, con);
        try {
            while (rs.next()) {
                empId = rs.getInt("MAX(emp_id)");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionUtil.closeConnection(con);
        }

        return empId;
    }

    public int removeEmployee(int id) {
        Connection con = ConnectionUtil.loadDriver();
        String query = "DELETE FROM employee WHERE emp_id =" + id;
        int num = 0;
        try {
            num = ConnectionUtil.runQuery(query, con);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionUtil.closeConnection(con);
        }
        return num;
    }

    public int updateEmployee(Employee employee) throws SQLException {
        Connection con = ConnectionUtil.loadDriver();
        String query = "UPDATE employee SET " + "name = '" + employee.getName() + "',dept_id = " + employee.getDeptId() + ",age = " + employee.getAge() + ",sex = '" + employee.getSex() + "' WHERE emp_id = " + employee.getEmpId();
        int num = 0;
        try {
            num = ConnectionUtil.runQuery(query, con);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionUtil.closeConnection(con);
        }
        return num;
    }

    public Employee getEmployeeById(int id) throws SQLException {
        Connection con = ConnectionUtil.loadDriver();

        String query = "SELECT * FROM employee WHERE emp_id = " + id;

        Employee employee = new Employee();

        ResultSet rs = ConnectionUtil.getResultSet(query, con);
        try {
            while (rs.next()) {
                employee.setEmpId(rs.getInt("emp_id"));
                employee.setName(rs.getString("name"));
                employee.setDeptId(rs.getInt("dept_id"));
                employee.setSex(rs.getString("sex"));
                employee.setAge(rs.getInt("age"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionUtil.closeConnection(con);
        }
        return employee;
    }

}
