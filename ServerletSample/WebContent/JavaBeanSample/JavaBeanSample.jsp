<%@ page language="java" contentType="text/html; charset=BIG5" pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<style type="text/css">
    .button{
        display:inline-block;
        background-color: #FFFFFF;
        margin: 5px;
        width: 80px;
        text-align: center;
        position:relative;
    }
</style>
<script type="text/javascript">
    function formSubmit(){
    	var errorMsg = [];
    	
    	if(document.getElementById("account").value==""){
    		//show Error Msg
    		errorMsg.push('account');
    	}
    	
    	if(document.getElementById("password").value==""){
    		errorMsg.push('password');
    	}
    	if(errorMsg.length == 0){
    		document.sampleForm.submit();
    	}else {
    		showError(errorMsg);
    	}
    }
    
    function showError(errorMsg){
    	document.getElementById('MessageDialog').style.display = 'inline';
    	document.getElementById('content').innerHTML = 'Please enter '+errorMsg.toString()+' !';
    }
</script>
<title>Insert title here</title>
</head>
<body>
<form name="sampleForm"action="JavaBeanSampleRespose.jsp">
<div style="background-color: #AAAAAA;width: 350px;margin: 50px;padding: 25px;">
    <font style="color: #FFFFFF;font-size: 20px">Welcom ! <br>Please Enter your Account and password</font><br>
    <table style="margin-bottom: 15px">
	    <tr>
	       <td width="50px">Account:</td>
	        <td><input type="text" id="account" name="account"></td>
	    </tr>
	    <tr>
           <td>Password:</td>
            <td><input type="text" id="password" name="password"></td>
        </tr>
    </table>
    <span onclick="formSubmit();" class="button" style="left:150px;">login</span>
    <span onclick='document.getElementById("account").value="";document.getElementById("password").value="";' class="button" style="left:150px;">clear</span>
</div>
<div id='MessageDialog' style="position:absolute; left: 100px;top:130px;width: 300px;background-color: #EEEEEE;display: none;padding: 10px;">
    <p>Message<p>
    <p id='content'></p>
    <span class="button" onclick="this.parentNode.style.display='none'" style="position: relative;left: 35%">close</span>
</div>
</form>
</body>
</html>