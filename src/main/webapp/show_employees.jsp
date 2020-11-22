<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
    /*var response = [
        {
            "id":"1",
            "name":"Alon",
            "empId":"43235",
            "email":"abc@gmail.com",
            "phoneNum" : "95050950"
        },
        {
            "id":"2",
            "name":"John",
            "empId":"5323",
            "email":"abc@gmail.com",
            "phoneNum" : "854865"
        }
    ];

    console.log(response);
    $.each(response, function(i, item) {
        $('<tr>').append(
            $('<td>').text(item.id),
            $('<td>').text(item.name),
            $('<td>').text(item.empId),
            $('<td>').text(item.email),
            $('<td>').text(item.phoneNum)
        ).appendTo('#emp_table');
    });*/
    var department_name = $("#dept_dropdown").val();
    var dept = {
        "deptName" : department_name
    };
    $.ajax(
       {
           url: "webapi/showAll",
           type: "POST",
           dataType: 'json',
           contentType : "application/json",
           data :JSON.stringify(dept),
           success: function (response){
               console.log(response);
               $.each(response, function(i, item) {
                   $('<tr>').append(
                       $('<td>').text(item[0]),
                       $('<td>').text(item[1]),
                       $('<td>').text(item[2]),
                       $('<td>').text(item[3])
                   ).appendTo('#emp_table');
               });
           }
       });
</script>
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Name</th>
        <th scope="col">Employee ID</th>
        <th scope="col">Email id</th>
        <th scope="col">Phone</th>
    </tr>
    </thead>
    <tbody id="emp_table">

    </tbody>
</table>