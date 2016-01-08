<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="navbar-inverse">
		  <div class="navbar-inner">
		   <div class="container-fluid">
			  <a class="brand"><small><i class="icon-leaf"></i></small> </a>
			  <ul class="nav_ace-nav_pull_right">
			  <li class="shortMess">
			  <span>短信</span>
			  </li>
			  <li class="mail-profile">
			 <span>邮件</span>
			  </li> 
			  <li class="user-profile">
			    <img class="nav-user-photo" alt="PM" src="static/img/user.jpg" >
			    <span id="user_info">
			  	  <small>Welcome</small>系统管理员
			  	  </span>
			  	<ul id="user_menu" class="pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-closer">
			  	  <li><a onclick="editUserH();" style="cursor:pointer;"><i class="icon-user"></i>修改资料</a></li>
					<li><a onclick="logout();"><i class="icon-off"></i>退出</a></li>
			  	</ul>
			   </li>
			 </ul>
			   </div>
			  </div>
			  </div>
			  