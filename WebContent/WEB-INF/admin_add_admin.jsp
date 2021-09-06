<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Admin</title>
	<!-- Bootstrap Styles-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <link href="assets/css/select2.min.css" rel="stylesheet" >
	<link href="assets/css/checkbox3.min.css" rel="stylesheet" >
    <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>
    <div id="wrapper">
        <nav class="navbar navbar-default top-navbar" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="adminMain.do"><strong><i class="icon fa fa-plane"></i> ADMIN</strong></a>
				<div id="sideNav">
			<i class="fa fa-bars icon"></i> 
			</div>
            </div>

            <ul class="nav navbar-top-links navbar-right">
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="adminLogout.do"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
        </nav>
        <!--/. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
<li>
                        <a href="adminMain.do"><i class="fa fa-dashboard"></i> Dashboard</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-user"></i> Admins<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="adminList.do">Admin List</a>
                            </li>
                            <li>
                                <a href="adminAdd.do">Add New Admin</a>
                            </li>
							</ul>
					</li>	
                    <li>
                        <a href="#"><i class="fa fa-users"></i> Users<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="userList.do">User List</a>
                            </li>
                            <li>
                                <a href="userAdd.do">Add New User</a>
                            </li>
							</ul>
					</li>	
                </ul>
            </div>
        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
		  <div class="header"> 
              <h1 class="page-header">
                 Admin <small>Add New Admin</small>
              </h1>
              <ol class="breadcrumb">
                  <li><a href="#">Home</a></li>
				  <li><a href="#">Admin</a></li>
				  <li class="active">Add New Admin</li>
              </ol> 	
		</div>
            
            <div id="page-inner"> 
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <div class="card-title">
                                        <div class="title">Add New Admin</div>
                                    </div>
                                </div>
                                <div class="panel-body">
                                    <form action="adminAdd.do" method="POST"  class="form-horizontal">
                                    	<input type="hidden" name="csrfToken" value="${csrfToken}" />
                                    	
                                    	<c:forEach var="field" items="${form.visibleFields}">
                                        <div class="form-group">
                                            <label for="inputFirstName" class="col-sm-2 control-label">${field.label}</label>
                                            <label style="color: red;">${field.error}</label>
                                            <div class="col-sm-10">
                                                <input type="${field.type}" class="form-control" name="${field.name}" id="${field.name}" value="${field.value}"/>
                                            </div>
                                        </div>
                                        </c:forEach>
                                         
                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <input type="submit" class="btn btn-success" name = "action" value="Create"/>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>   
			</div>
             <!-- /. PAGE INNER  -->
            </div>
         <!-- /. PAGE WRAPPER  -->
        </div>
     <!-- /. WRAPPER  -->
    <!-- JS Scripts-->
    <!-- jQuery Js -->
    <script src="assets/js/jquery-1.10.2.js"></script>
      <!-- Bootstrap Js -->
    <script src="assets/js/bootstrap.min.js"></script>
    <!-- Metis Menu Js -->
    <script src="assets/js/jquery.metisMenu.js"></script>
	<script src="assets/js/select2.full.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
	  $(".selectbox").select2();
	});
	</script>
      <!-- Custom Js -->
    <script src="assets/js/custom-scripts.js"></script> 
</body>
</html>