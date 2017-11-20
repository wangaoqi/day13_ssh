<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>
</head>

<body class="emp_body">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="44%" align="left">[员工管理]</td>
   
    <td width="52%"align="right">
    	<!-- 提交表单 -->
       <a href="javascript:void(0)" onclick="document.forms[0].submit()">
       	<img src="${pageContext.request.contextPath}/images/button/save.gif" />
       </a>
       <!-- 执行js，进行返回 -->
       <a href="javascript:void(0)" onclick="window.history.go(-1)"><img src="${pageContext.request.contextPath}/images/button/tuihui.gif" /></a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>


<form action="/edit.action" method="post">

	<s:hidden name="staffId" value="%{#byStaffId.staffId}"/>

	<table width="88%" border="0" class="emp_table" style="width:80%;">
		<%--显示对应的信息--%>
		<tr>
			<td>登录名：</td>
			<td><s:textfield name="loginName" value="%{#byStaffId.loginName}"/></td>
			<td>密码：</td>
			<td><s:password name="loginPwd" value="%{#byStaffId.loginPwd}" showPassword="true"/></td>
		</tr>
		<tr>
			<td>姓名：</td>
			<td><s:textfield name="staffName" value="%{#byStaffId.staffName}"/></td>
			<td>性别：</td>
			<td>
				<s:radio list="{'male','female'}" name="gender" value="%{#byStaffId.gender}"/>
			</td>
		</tr>
		<tr>
			<td width="10%">所属部门：</td>
			<td width="20%">
				<select name="post.department.depId" onchange="onChange(this.value)" id="department">
					<%--遍历部门--%>
					<s:iterator value="#departmentL" var="dep">
						<s:if test="%{#dep.depId.equals(#byStaffId.post.department.depId)}">
							<option value="${dep.depId}" selected="selected">${dep.depName}</option>
						</s:if>
						<s:else>
							<option value="${dep.depId}">${dep.depName}</option>
						</s:else>
					</s:iterator>
				</select>
			</td><br/>
			<td width="8%">职务：</td>
			<td width="62%">
				<select name="post.postId" id="posts">
					<%--接收后台传来的职务信息--%>
					<option value="${sessionScope.get("setPostId")}">${sessionScope.get("setPostName")}</option>
				</select>
			</td>
		</tr>
		<tr>
			<td width="10%">入职时间：</td>
			<td width="20%">
				<s:textfield  name="onDutyDate" value="%{#byStaffId.onDutyDate}"/>
			</td>
			<td width="8%"></td>
			<td width="62%"></td>
		</tr>
	</table>
</form>

<script type="application/javascript">
    function onChange(value) {
        //输出value的值
        console.log(value);
        //根据value的值发送请求,获取二级列表的json数据
        var data = new FormData();
        data.append("depId", value);
//		 data.append("postId",value);

        var xhr = new XMLHttpRequest();
        xhr.withCredentials = true;

        xhr.addEventListener("readystatechange", function () {
            if (this.readyState === 4) {
                console.log(this.responseText);
                //对请求回来的数据进行解析
                json = eval('(' + this.responseText + ')');

                //获取服务器的标签
                serverSelect = document.getElementById("post");
                //获取option标签
                optionEle = serverSelect.getElementsByTagName("option");
                //获取option的数量
                length = optionEle.length;
                //使用循环清空所有option标签
                for (var i = 0; i < length - 1; i++) {
                    serverSelect.removeChild(optionEle[1]);
                }
                //将json数据插入到option中
                for (var i = 0; i < json.length; i++) {
                    //创建一个option标签
                    option = document.createElement("option");
                    //设置value属性
                    option.setAttribute("value", json[i].postId);
                    //设置文本信息
                    text = document.createTextNode(json[i].postName)
                    //把文本信息添加到option标签中
                    option.appendChild(text);
                    //把option标签添加到servers标签中
                    serverSelect.appendChild(option);
                }

            }
        });

        xhr.open("POST", "findPostss.action");
        xhr.send(data);
    }
</script>

</body>
</html>
