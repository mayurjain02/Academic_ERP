<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<script>
  var department_name = $("#dept_dropdown").val();
  var dept = {
    "deptName" : department_name
  };
  $.ajax(
          {
            url: "webapi/department/getValue",
            type: "POST",
            dataType: 'json',
            contentType : "application/json",
            data :JSON.stringify(dept),
            success: function (response){
              console.log(response);
                $("#dname").val(response.deptName);
              $("#capacity").val(response.capacity);
              $("#hod_id").val(response.hod);
            }
          });
</script>
<form class="form-container">
  <div class="form-group">
    <h2 align="center">Edit Department</h2>
  </div>
  <div class="form-group">
    <label>Department Name</label>
    <input type="text" class="form-control" id="dname" aria-describedby="emailHelp" placeholder="Enter Department name" required>
  </div>
  <div class="form-group">
    <label>Capacity</label>
    <input type="number" class="form-control" id="capacity" placeholder="Capacity" required>
  </div>
  <div class="form-group">
    <label>HOD Name</label>
    <input type="text" class="form-control" id="hod_id" placeholder="HOD Name" required>
  </div>

  <input type="button" class="btn btn-primary btn-block" onclick="update()" value="Update"/>
</form>