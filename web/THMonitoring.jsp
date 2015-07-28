<%@ page import="java.util.*" contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html class="no-js">
<head>
  <title>ParkingLotAdmin</title>
  <!-- Bootstrap -->
  <link href="styles/bootstrap.min.css" rel="stylesheet" media="screen">
  <link href="styles/styles.css" rel="stylesheet" media="screen">
  <!--/.fluid-container-->
  <script src="scripts/jquery-1.9.1.min.js"></script>
  <script src="scripts/bootstrap.min.js"></script>

</head>

<body>

<script>
  function getChart(){
    $('#graphic').load('./chart.do');
  }
  $(document).ready(function(){
    setInterval(getChart,20000);
    getChart();
  })




</script>


<div class="navbar navbar-fixed-top">
  <div class="navbar-inner">
    <div class="container-fluid">
      <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </a>
      <a class="brand" href="index.do">Admin Panel</a>
      <div class="nav-collapse collapse">
        <ul class="nav pull-right">
          <li class="dropdown">
            <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown"> <i class="icon-user"></i> admin <i class="caret"></i>

            </a>
            <ul class="dropdown-menu">
              <li>
                <a tabindex="-1" href="#">Profile</a>
              </li>
              <li class="divider"></li>
              <li>
                <a tabindex="-1" href="login.html">Logout</a>
              </li>
            </ul>
          </li>
        </ul>
        <ul class="nav">
          <li class="dropdown">
            <a href="#" role="button" data-toggle="dropdown" class="dropdown-toggle">监控管理 <i class="caret"></i></a>
            <ul class="dropdown-menu">
              <li>
                <a tabindex="-1" href="http://192.168.3.199/">视频监控</a>
              </li>
              <li>
                <a tabindex="-1" href="THMonitoring.jsp">温湿度监测</a>
              </li>
            </ul>
          </li>
          <li class="dropdown">
            <a href="#"  class="dropdown-toggle" data-toggle="dropdown">服务器管理 <i class="caret"></i>
            </a>
            <ul class="dropdown-menu">
              <li>
                <a tabindex="-1" href="#">开启服务器</a>
              </li>
              <li class="divider"></li>
              <li>
                <a tabindex="-1" href="#">关闭服务器</a>
              </li>
            </ul>
          </li>
          <li class="dropdown">
            <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">用户管理 <i class="caret"></i>

            </a>
            <ul class="dropdown-menu">
              <li>
                <a tabindex="-1" href="listUsers.do?tag=users">用户列表</a>
              </li>
              <li>
                <a tabindex="-1" href="listUsers.do?tag=online">在线用户</a>
              </li>
              <li>
                <a tabindex="-1" href="pay.jsp">用户充值管理</a>
              </li>
            </ul>
          </li>
        </ul>
      </div>
      <!--/.nav-collapse -->
    </div>
  </div>
</div>
<div class="container-fluid">
  <div class="row-fluid">
    <div class="span3" id="sidebar">

      <ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
        <li class="active">
          <a ><span>便捷面板</span></a>
        </li>
        <li >
          <a href="http://192.168.3.199/"><i class="icon-chevron-right"></i>视频监控</a>
        </li>
        <li >
          <a href="listUsers.do?tag=online"><i class="icon-chevron-right"></i>在线用户列表</a>
        </li>
        <li >
          <a href="pay.jsp"><i class="icon-chevron-right"></i>用户充值</a>
        </li>
        <li >
          <a href="index.do"><i class="icon-chevron-right"></i>回到首页</a>
        </li >

      </ul>
    </div>

    <div class="span8" id="content" >
      <div class="row-fluid">
        <!-- Fixed navbar -->
        <div class="navbar navbar-default navbar-fixed-top" role="navigation" id="head"></div>
        <div class="container-fluid">
          <div class="row-fluid example">
            <div id="graphic" class="col-md-4">


            </div><!--/span-->
          </div><!--/row-fluid-->
        </div><!--/.fluid-container-->
        <!-- /Fixed navbar -->
      </div>
    </div>

  </div>
  <hr>
  <footer>
    <p>&copy; wswenyue 2015</p>
  </footer>
</div>


</body>

</html>
