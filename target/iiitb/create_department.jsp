<form class="form-container">
<div class="form-group">
    <h2 align="center">Create Department</h2>
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
    <input type="text" class="form-control" id="hod_id" placeholder="Employee id" required>
  </div>
  
  <input type="button" class="btn btn-primary btn-block" onclick="createDepartment()" value="Create"/>
</form>