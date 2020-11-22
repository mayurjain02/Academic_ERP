<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/department.css"/>

	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	<script>
		$(document).ready(function(){
			$("#header").load("header.jsp");

			$("#create_department").click(function(){
				$("#department_area").load("create_department.jsp");
				$("#operations_area").empty();
			});


			$('select').on('change', function() {
				$("#department_area").load("department_operations.jsp?GET='"+this.value+"'");
			});

			$.ajax(
					{
						url: "webapi/department/getName",
						type: "POST",
						success: function (response){
							console.log(response);
							$.each(response, function(i, option) {
								$('#dept_dropdown').append($('<option/>').attr("value", option.deptName).text(option.deptName));
							});
						}
					});

		});
		$(document).load(function(){


        });

		function deleteDept()
		{
			$("#operations_area").load("delete_dept.jsp");

			var department_name = $("#dept_dropdown").val();
			var dept = {
				"deptName" : department_name
			};
			$.ajax(
					{
						url: "webapi/department/delete",
						type: "POST",
						dataType: 'json',
						contentType : "application/json",
						data :JSON.stringify(dept),
						success: function (response){
							alert(response.message);
							location.reload();
						}
					});

		}
		function showEmp()
		{
			$("#operations_area").load("show_employees.jsp");


		}
		function edit()
		{
			$("#operations_area").load("edit_dept.jsp");


		}

		function createDepartment() {
			var department_name = $("#dname").val();
			var capacity = $("#capacity").val();
			var hod_id = $("#hod_id").val();

			var dept = {
				"deptName" : department_name,
				"capacity" : capacity,
				"hod":hod_id
			};
			console.log(dept);
			$.ajax(
					{
						url: "webapi/department/create",
						type: "POST",
						dataType: 'json',
						contentType : "application/json",
						data :JSON.stringify(dept),
						success: function (response){
							alert(response.message);
							location.reload();
						}
					});
		}

		function update() {
			var prev_dept = $("#dept_dropdown").val();
			var department_name = $("#dname").val();
			var capacity = $("#capacity").val();
			var hod_id = $("#hod_id").val();


			var dept = {
				"prevDeptName" : prev_dept,
				"newDeptName" : department_name,
				"capacity" : capacity,
				"hod":hod_id
			};
			console.log(dept);
			$.ajax(
					{
						url: "webapi/department/edit",
						type: "POST",
						dataType: 'json',
						contentType : "application/json",
						data :JSON.stringify(dept),
						success: function (response){
							alert(response.message);
							location.reload();
						}
					});
		}

	</script>
</head>
<body>
<div class="container-fluid">
	<div id="header">
	</div>
	<div class="row" style="margin-top:10vh;">
		<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"></div>
		<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
			<!--  class="dropdown">
              <button class="btn btn-secondary btn-lg dropdown-toggle" type="button" data-toggle="dropdown">Select department
              <span class="caret"></span></button>
              <ul class="dropdown-menu">
                <li><a href="#">Accounts</a></li>
                <li><a href="#">Admin</a></li>
                <li><a href="#">Faculy</a></li>
              </ul>
            </div-->
			<select class="form-control form-control-lg" id="dept_dropdown" on>
				<option value="">Select Department</option>
			</select>
		</div>
		<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
			<div class="form-group">
				<input type="button" class="btn btn-secondary btn-lg btn-block" id="create_department" value="Create Department"/>
			</div>
		</div>
		<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"></div>
	</div>

	<div class="row" style="margin-top:5vh;">
		<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
		<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4" id="department_area">

		</div>
		<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
	</div>

	<div class="row" style="margin-top:5vh;">
		<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
		<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4" id="operations_area">

		</div>
		<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
	</div>
</div>
</body>
</html>