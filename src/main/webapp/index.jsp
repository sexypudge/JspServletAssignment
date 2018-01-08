<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Employee Management</title>
<style>
.control-label {
	text-align: left !important;
}
</style>
</head>
<body>
	<div class="col-sm-12 container">
		<div style="text-align: center;">
			<h1>Employee Management</h1>
		</div>
		<div class="row" style="margin-top: 50px;">
			<form action="insert" method="POST" class="form-horizontal" name="employeeForm">
				<div class="col-sm-3"></div>
				<div class="col-sm-6">
					<div class="form-group">
						<label class="control-label col-sm-2 text-left" for="name">
							Họ và Tên
						</label>
						<div class="col-sm-4">
							<input type="text" id="name" name="name" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 text-left" for="age">Tuổi</label>
						<div class="col-sm-2">
							<input type="text" class="form-control" name="age" id="age">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 text-left" for="sex">
							Giới tính
						</label>
						<div class="col-sm-4">
							<div class="radio">
								<label> 
									<input type="radio" name="sex" id="male" value="Nam" /> Nam
								</label> 
								<label> 
									<input type="radio" name="sex" id="female" value="Nữ" /> Nữ
								</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2 text-left" for="department">
								Phòng ban
						</label>
						<div class="col-sm-4">
							<select id="department" name="department" class="form-control">
								<option value="0">-- Chọn --</option>
								<c:if test="${not empty listDepartments}">
									<c:forEach items="${listDepartments}" var="dept">
										<option value="${dept.deptId}">${dept.toString()}</option>
									</c:forEach>
								</c:if>
							</select>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-6" style="text-align: center;">
							<input class="btn btn-primary" type="submit" value="Thêm mới">
							<input class="btn btn-primary" type="button" style="margin-left: 20px;"
								value="Cập nhật"> 
							<input class="btn" type="button" style="margin-left: 20px;"
								value="Huỷ">
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
									<th style="text-align: center;">Sửa</th>
									<th style="text-align: center;">Xoá</th>
								</tr>
							</c:forEach>
						</tbody>
					</table>
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