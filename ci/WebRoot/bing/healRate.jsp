<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'healRate.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script src="echarts.common.min.js"></script>
    <script src="jquery-3.2.1.js"></script>
  </head>
  
  <body>
   <div id="main" style="width: 600px;height:400px;"></div>
    <script>
    var myChart = echarts.init(document.getElementById('main'));
	var data = [];
    	option = {
    tooltip: {
        trigger: 'item',
        formatter: "{a} <br/>{b}: {c} ({d}%)"
    },
    legend: {
        orient: 'vertical',
        x: 'left',
        data:['过轻','健康','超重','肥胖']
    },
    series: [
        {
            name:'健康状况',
            type:'pie',
            radius: ['50%', '70%'],
            avoidLabelOverlap: false,
            label: {
                normal: {
                    show: false,
                    position: 'center'
                },
                emphasis: {
                    show: true,
                    textStyle: {
                        fontSize: '30',
                        fontWeight: 'bold'
                    }
                }
            },
            labelLine: {
                normal: {
                    show: false
                }
            },
            data:data
        }
    ]
};
    	   var nums=[];   
         
         $.ajax({
         type : "post",
         async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
         url : "HealRateServlet",    
         data : {},
         dataType : "json",        //返回数据形式为json
         success : function(result) {
             //请求成功时执行该函数内容，result即为服务器返回的json对象
             if (result) {
             	console.log(result);
             	var type=['过轻','健康','超重','肥胖'];
             	
                    for(var i=0;i<result.length;i++){       
                      nums[i]={value:result[i],name:type[i]};
                       
                     }
                    
                  
                
                   myChart.setOption({        //加载数据图表
                      
                       series: [{
                         // 根据名字对应到相应的系列
                          name: '健康状况',
                           data: nums
                      }]
                  });
                    
             }
         
        },
         error : function(errorMsg) {
             //请求失败时执行该函数
         alert("图表请求数据失败!");
        
         }
    })

	myChart.setOption(option);
    </script>
  </body>
</html>
