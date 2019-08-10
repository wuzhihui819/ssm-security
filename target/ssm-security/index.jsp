<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"  isELIgnored="false"%>
<!DOCTYPE html>
<html>
<%
    pageContext.setAttribute("APP_PATH",request.getContextPath());

%>
    <head>

        <script type="text/javascript" src="${APP_PATH}/static/js/jquery-3.4.1.min.js"></script>
        <title>防伪码验证</title>
    </head>
        <script type="text/javascript">
            var flag = 0;
            function reloadCheckImg(){
                $("#tip").text("");
                $("img").attr("src","img.jsp?t="+(new Date().getTime()));

            }

            function check(){
                if(flag==0){
                    alert("验证码错误");
                    $("form").submit(function (e) {
                        e.preventDefault();
                    })
                    location.reload();
                }else{
                    var securityId = $("#check_id").val();
                    if(securityId.length!=3){
                        alert("防伪码必须为16位！");
                        $("form").submit(function (e) {
                            e.preventDefault();
                        })
                        location.reload();
                    }

                }

            }

            $(document).ready(function () {
                $("#checkcodeId").blur(function () {
                    var $checkcode = $("#checkcodeId").val();
                    //校验：文本框输入 发送到服务端
                    //服务端：获取文本框 对比图片 返回验证结果

                    $.post(
                        "CheckCode",//服务器地址
                        "checkcode="+$checkcode,
                        function (result) {//图片地址
                            var resultHtml = $("<img src='"+result+"' height='15' width='15px'/>")
                            var result_msg = result;
                            if(result_msg.toString().match("wrong")){
                                flag=0;
                            }else{
                                flag=1;
                            }

                            $("#tip").html(resultHtml);
                        }
                    )
                });
            });
        </script>


    <body>
        <div  style="margin:100px auto;width: 600px;height:400px;background-color: lavender;text-align: center">
            <br>
            <form method="post" action="doCheck">
                <h3>防伪码验证</h3>
                <br>
                <br>
                <label>防伪码:</label><input type="text" name="identify" id="check_id">
                <br> <br>
                <label>验证码:</label><input type="text" name="checkcode" id="checkcodeId" size="4" />
                <a href="javascript:reloadCheckImg()"><img src="img.jsp" /></a>
                <span id="tip"></span>
                <br><br>
                <div style="text-align: center">
                    <button type="submit" onclick="check()">查询</button>  
                </div>
            </form>

        </div>

    </body>
</html>
