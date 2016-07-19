<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>守望先锋管理员登录</title>
	<script type="text/javascript" src="/js/jquery-1.6.4.js"></script>
	<script type="text/javascript" src="/js/jquery.cookie.js"></script>
</head>
<body style="background-color: #F3F3F3">
    <div class="easyui-dialog" title="管理员登录" data-options="closable:false,draggable:false" style="width:400px;height:300px;padding:10px;">
       	<div style="margin-left: 50px;margin-top: 50px;">
       		<div style="margin-bottom:20px;">
	            <div>
	            	用户名（默认为admin）: <input name="username" class="easyui-textbox" data-options="required:true" style="width:200px;height:32px" value="admin"/>
	            </div>
	        </div>
	        <div style="margin-bottom:20px">
	            <div>
	            	密&nbsp;&nbsp;码（默认为admin）: <input name="password" class="easyui-textbox" type="password" style="width:200px;height:32px" data-options="" value="admin"/>
	            </div>
	        </div>
	        <div>
				<input type="button"  id="loginsubmit" value="登录" tabindex="8" />
	        </div>
       	</div>
    </div>

	<script type="text/javascript">
			$("#loginsubmit").click(function(){
				var username = $("[name=username]").val();
				var password = $("[name=password]").val();

				if(username!="admin" || password!="admin"){
					console.log('错误',"用户名密码不正确！");
					return ;
				}
				console.log('成功',"用户名密码正确！");
				$.cookie('admin','admin');
				window.location.href="/index";
			});
	</script>
</body>

</html>