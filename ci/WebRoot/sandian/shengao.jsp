<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'shengao.jsp' starting page</title>
    
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
   <div id="main" style="width: 800px;height:600px;"></div>
	<script>
	var myChart = echarts.init(document.getElementById('main'));
var data = [];

// See https://github.com/ecomfe/echarts-stat

option = {
    title: {
        text: '年龄身高分布图',
      
        left: 'center'
    },
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'cross'
        }
    },
    xAxis: {
        type: 'value',
        name:'年龄(月)',
        splitLine: {
            lineStyle: {
                type: 'dashed'
            }
        },
    },
    yAxis: {
        type: 'value',
        min: 1.5,
        name:'身高(cm)',
        splitLine: {
            lineStyle: {
                type: 'dashed'
            }
        },
    },
    series: [{
        name: 'scatter',
        type: 'scatter',
        label: {
            emphasis: {
                show: true,
                position: 'left',
                textStyle: {
                    color: 'blue',
                    fontSize: 16
                }
            }
        },
        data: data
    
    }]
};
//

       
         
         var nums=[];   
         
         $.ajax({
         type : "post",
         async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
         url : "ShengaoServlet",    
         data : {},
         dataType : "json",        //返回数据形式为json
         success : function(result) {
             //请求成功时执行该函数内容，result即为服务器返回的json对象
             if (result) {
             	console.log(result);
                    for(var i=0;i<result.length;i++){       
                      nums[i]=[result[i].age,result[i].shengao];
                       
                     }
                    
                  console.log(nums[1]);
                
                   myChart.setOption({        //加载数据图表
                      
                       series: [{
                         // 根据名字对应到相应的系列
                          name: 'scatter',
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
	
//
	
	myChart.setOption(option);
	</script>
  </body>
</html>
