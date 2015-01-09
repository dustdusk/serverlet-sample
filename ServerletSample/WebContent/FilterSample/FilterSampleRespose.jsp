<%@ page language="java" contentType="text/html; charset=BIG5" pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
<%-- 宣告名為 sampleForm的變數, 變數範圍為page--%>
<jsp:useBean id="sampleForm" class="samplePack.bean.SampleForm" scope="page"></jsp:useBean>
<%-- 實際把值從request load 近Java bean--%>
<jsp:setProperty property="*" name="sampleForm"/>
<form name="sampleForm"action="FilterSampleLogin.jsp">
<div style="background-color: #AAAAAA;width: 350px;margin: 50px;padding: 25px;">
    <font style="color: #FFFFFF;font-size: 20px">this is your account and password</font><br>
    <table>
        <tr>
           <td width="50px">Account:</td>
            <td><jsp:getProperty property="account" name="sampleForm"/></td>
        </tr>
        <tr>
           <td>Password:</td>
            <td><jsp:getProperty property="password" name="sampleForm"/></td>
        </tr>
    </table>
    <div onclick="document.sampleForm.submit();" style="background-color: #FFFFFF;margin: 5px;width: 100px;text-align: center;position:relative;left:250px;">back</div>
</div>
</form>
</body>
</html>