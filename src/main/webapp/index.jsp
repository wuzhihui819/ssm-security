<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>


<%--<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>--%>
<%--<script type="text/javascript">--%>
<%--    $("#check_id").blur(function(){--%>
<%--        //发送ajax请求检验用户名是否可用--%>
<%--        alert(123);--%>
<%--        var securityId = this.value;--%>
<%--        $.ajax({--%>
<%--            url:"/checkuser",--%>
<%--            data:"securityId="+securityId,--%>
<%--            type:"POST",--%>
<%--            success:function(result){--%>
<%--                if(result.code==100){--%>
<%--                    show_validate_msg("#check_id","success","防伪码正确");--%>
<%--                }else{--%>
<%--                    show_validate_msg("#check_id","error","防伪码必须是16位");--%>
<%--                }--%>
<%--            }--%>
<%--        });--%>
<%--    });--%>
<%--</script>--%>
<body>
<div  style="margin:100px auto;width: 600px;height:400px;background-color: lavender;text-align: center">
    <br>
    <form method="post" action="doCheck">
        <h3>防伪码验证</h3>
        <br>
        <br>
        <label>防伪码:</label><input type="text" name="identify" id="check_id">
        <br><br> <br>
        <div style="text-align: center">
            <button type="submit" >查询</button>  
        </div>
    </form>
</div>
</body>
</html>
