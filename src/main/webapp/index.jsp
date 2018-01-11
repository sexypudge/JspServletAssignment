<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Employee Management</title>
    <style>
        .control-label {
            text-align: left !important;
        }
    </style>
    <script type="text/javascript">
        var empId;

        $(document).ready(function () {
            $("#buttonDelete").click(function () {
                $.ajax({
                    type: "POST",
                    url: "remove",
                    data: {
                        employeeId: empId
                    },
                    success: function (data) {
                        window.location.href = "index"
                    },
                });
            });
        });

        function getIdtoRemove(idToRemove) {
            empId = idToRemove;
        }
    </script>
</head>
<body>
<div class="col-sm-12 container">
    <div style="text-align: center;">
        <h1>Employee Management</h1>
    </div>
    <div class="row" style="margin-top: 50px;">
        <form action="insert" method="POST" class="form-horizontal" name="employeeForm">
            <div class="col-sm-3">
                <%-- <input type="text" id="empId" name="empId" class="form-control" value="${not empty employeeToBeModified ? employeeToBeModified.name : ''}" hidden> --%>
            </div>
            <div class="col-sm-6">
                <div class="form-group">
                    <label class="control-label col-sm-2 text-left" for="name">
                        Họ và Tên
                    </label>
                    <div class="col-sm-4">
                        <c:choose>
                            <c:when test="${empty employeeToBeModified}">
                                <input type="text" id="name" name="name" class="form-control">
                            </c:when>
                            <c:otherwise>
                                <input type="text" id="name" name="name" class="form-control"
                                       value="${employeeToBeModified.name}">
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="col-sm-4">
                        <c:if test="${not empty validateName}">
                            <span class="text-danger"><c:out value="${validateName}"></c:out></span>
                        </c:if>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2 text-left" for="age">Tuổi</label>
                    <div class="col-sm-2">
                        <c:choose>
                            <c:when test="${empty employeeToBeModified}">
                                <input type="text" class="form-control" name="age" id="age">
                            </c:when>
                            <c:otherwise>
                                <input type="text" id="age" name="age" class="form-control"
                                       value="${employeeToBeModified.age}">
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="col-sm-4">
                        <c:if test="${not empty validateAge}">
                            <span class="text-danger"><c:out value="${validateAge}"></c:out></span>
                        </c:if>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2 text-left">
                        Giới tính
                    </label>
                    <div class="col-sm-4">
                        <div class="radio">
                            <c:choose>
                                <c:when test="${empty employeeToBeModified}">
                                    <label>
                                        <input type="radio" name="sex" value="Nam"/> Nam
                                    </label>
                                    <label>
                                        <input type="radio" name="sex" value="Nữ"/> Nữ
                                    </label>
                                </c:when>
                                <c:otherwise>
                                    <label>
                                        <input type="radio" name="sex" id="male"
                                               value="Nam" ${employeeToBeModified.sex == 'Nam' ? 'checked' : '' } /> Nam
                                    </label>
                                    <label>
                                        <input type="radio" name="sex" id="female"
                                               value="Nữ" ${employeeToBeModified.sex == 'Nữ' ? 'checked' : '' }/> Nữ
                                    </label>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2 text-left" for="department">
                        Phòng ban
                    </label>
                    <div class="col-sm-4">
                        <select id="department" name="department" class="form-control">
                            <c:if test="${not empty listDepartments}">
                                <c:forEach items="${listDepartments}" var="dept">
                                    <option value="${dept.deptId}" ${empty employeeToBeModified ? '' : (employeeToBeModified.deptId == dept.deptId ? 'selected' : '') }>${dept.toString()}</option>
                                </c:forEach>
                            </c:if>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-6" style="text-align: center;">
                        <input class="btn btn-primary" type="submit" value="Thêm mới" ${empty
                                employeeToBeModified ? '' : 'disabled' }>
                        <button formaction="update?emp_id=${not empty employeeToBeModified ? employeeToBeModified.empId : ''}"
                                class="btn btn-primary"
                                style="margin-left: 20px;" ${empty employeeToBeModified ? 'disabled' : '' }>Cập nhật
                        </button>
                        <button formaction="index" class="btn"
                                style="margin-left: 20px;" ${empty employeeToBeModified ? 'disabled' : '' }>Hủy
                        </button>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <div class="row">
        <div class="col-sm-2"></div>
        <div class="col-sm-8">
            <c:if test="${not empty listEmployees}">
                <table id="employeeTable"
                       class="table table-striped table-bordered table-hover">
                    <thead>
                    <tr>
                        <th style="text-align: center;">Họ và Tên</th>
                        <th style="text-align: center;">Tuổi</th>
                        <th style="text-align: center;">Giới tính</th>
                        <th style="text-align: center;">Phòng ban</th>
                        <th></th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${listEmployees}" var="empl">
                        <tr>
                            <th style="text-align: center;">${empl.name}</th>
                            <td style="text-align: center;">${empl.age}</td>
                            <td style="text-align: center;">${empl.sex}</td>
                            <td style="text-align: center;">
                                <c:if test="${not empty listDepartments}">
                                    <c:forEach items="${listDepartments}" var="dept">
                                        <c:if test="${empl.deptId == dept.deptId}">
                                            <c:out value="${dept.toString()}"/>
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </td>
                            <th style="text-align: center;"><a id="edit" href="findOne?emp_id=${empl.empId}">Sửa</a>
                            </th>
                            <th style="text-align: center;"><a id="remove" data-toggle="modal" data-target="#myModal"
                                                               onclick="getIdtoRemove(${empl.empId})">Xoá</a></th>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="modal fade" id="myModal" role="dialog">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title">Xác nhận xoá</h4>
                            </div>
                            <div class="modal-body">
                                <p>Bạn muốn xoá nhân viên?</p>
                            </div>
                            <div class="modal-footer">
                                <button id="buttonDelete" type="button" class="btn btn-primary" data-dismiss="modal">
                                    Ok
                                </button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
        </div>
    </div>
</div>
</body>
<link rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
        src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>