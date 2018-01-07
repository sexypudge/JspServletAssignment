package com.nissho.vn.model;

public class Employee {
	private int empId;
	private String name;
	private int deptId;
	private int age;
	private String sex;

	public Employee() {
		super();
	}

	public Employee(int empId, String name, int deptId, int age, String sex) {
		super();
		this.empId = empId;
		this.name = name;
		this.deptId = deptId;
		this.age = age;
		this.sex = sex;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", deptId=" + deptId + ", age=" + age + ", sex=" + sex
				+ "]";
	}
}
