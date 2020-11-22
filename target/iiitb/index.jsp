
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>:: Humon Resource ::</title>
    <script src="js/jquery.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/employee.css"/>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
    <script src="js/employee.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#login").click(function(){
                var uname=$("#uname").val();
                var pwd=$("#pwd").val();

                var data={
                    "username" : uname,
                    "password" : pwd
                }


                if(uname.length==0 || pwd.length==0)
                    alertMessage("Please check you input.");
                else
                {
                    $.ajax(
                        {
                            url: "webapi/login/check",
                            type: "POST",
                            dataType: 'json',
                            contentType : "application/json",
                            data :JSON.stringify(data),
                            success: function (response){
                                if(response.flag==0) {
                                    sessionStorage.setItem("username","Guest");
                                    window.location.href = "Department.jsp";
                                }
                                else
                                    alert(response.message+" "+response.flag);
                            }
                        });
                }
            });
        });
        function createDepartment()
        {

        }
    </script>
</head>
<body class="bg">
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
            <form class="form-container"><!--  method="POST" action="webapi/login/check" enctype="multipart/form-data"><!--"> -->
                <div class="form-group">
                    <h2 align="center">Employee Login</h2>
                </div>

                <div class="form-group">
                    <label for="exampleInputEmail1">Username</label>
                    <input type="text" class="form-control" name="username" id="uname" aria-describedby="emailHelp" placeholder="Enter username" required>
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input type="password" class="form-control" name="password" id="pwd" placeholder="Password" required>
                </div>
                <input type="button" class="btn btn-primary btn-block" id="login" value="Submit"/>

                <div id="login_status"></div>
            </form>
        </div>
        <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5"></div>
    </div>
</div>

</body>
</html>
