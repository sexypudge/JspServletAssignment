package com.nissho.vn.model;

public class Department {
    private int deptId;
    private String deptName;
    private String dirName;


    public Department() {
        super();
    }

    public Department(int deptId, String deptName, String dirName) {
        super();
        this.deptId = deptId;
        this.deptName = deptName;
        this.dirName = dirName;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    @Override
    public String toString() {
        return deptName;
    }


}
