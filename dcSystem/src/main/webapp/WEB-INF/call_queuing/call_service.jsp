<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/23
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>模仿微信端</title>
</head>
<body>
<script type="text/javascript">
    var websocket = null;
    var host = window.location.host;//localhost:8080;
    //判断当前浏览器是否支持WebSocket
    if ('WebSocket' in window) {
        // 路径+端口号   项目名   webSocket路径              var wsPath = window.location.host + "/项目名/websocket";
        websocket = new WebSocket("ws://"+host+ "/websocket.mvc?userId=${yonlie}");//获取用户session传递到后台
    } else if ('MozWebSocket' in window) {
        websocket = new MozWebSocket("ws://" + host
            + "/websocket.mvc");
    } else {
        alert('Not support websocket')
        websocket = new SockJS("http://" + host
            + "/sockjs/websocket.mvc");
    }
    //连接发生错误的回调方法
    websocket.onerror = function() {
        setMessageInnerHTML("error");
    };
    //连接成功建立的回调方法
    websocket.onopen = function(event) {
        setMessageInnerHTML("页面client打开websocket连接-----open");
    }
    //接收到消息的回调方法
    websocket.onmessage = function() {
        setMessageInnerHTML(event.data);
    }
    //连接关闭的回调方法
    websocket.onclose = function() {
        setMessageInnerHTML("页面client关闭websocket连接-----close");
    }
    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function() {
        websocket.close();
    }
    //将消息显示在网页上
    function setMessageInnerHTML(innerHTML) {
        document.getElementById('cus_message').innerHTML += innerHTML + '<br/>';
      /*  $.messager.show({
            title: '我的消息',
            msg: innerHTML,
            timeout: 5000,
            showType: 'slide'
        });*/
    }
    //关闭连接
    function closeWebSocket() {
        websocket.close();
    }
    //发送消息
    function send() {
        var message = document.getElementById('text').value;
        websocket.send(message);
    }
</script>

    <div >
        欢迎您：${yonlie}
    </div>

        <div id="cus_message"></div>
</div>
</body>
</html>
