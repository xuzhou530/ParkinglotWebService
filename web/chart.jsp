<%@ page import="java.util.*" contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<!-- ECharts单文件引入 -->
<script src="scripts/echarts.js"></script>
<script type="text/javascript">
  // 路径配置
  require.config({
    paths: {
      echarts: './scripts/'
    }
  });

  // 使用
  require(
          [
            'echarts',
            'echarts/chart/line', // 使用柱状图就加载bar模块，按需加载
            'echarts/chart/bar' // 使用柱状图就加载bar模块，按需加载

          ],
          function (ec) {
            // 基于准备好的dom，初始化echarts图表
            var myChart = ec.init(document.getElementById('chartinit'));

            var option = {
              title : {
                text: '实时温湿度变化监测',
                subtext: '每20s采集一次数据'
              },
              tooltip : {
                trigger: 'axis'
              },
              legend: {
                data:['温度','湿度']
              },
              toolbox: {
                show : true,
                feature : {
                  mark : {show: true},
                  dataView : {show: true, readOnly: false},
                  magicType : {show: true, type: ['line', 'bar']},
                  restore : {show: true},
                  saveAsImage : {show: true}
                }
              },
              calculable : true,
              xAxis : [
                {
                  type : 'category',
                  boundaryGap : false,
                  data : [${Time}]
                }
              ],
              yAxis : [
                {
                  type : 'value',
                  axisLabel : {
                    formatter: '{value}'
                  }
                }
              ],
              series : [
                {
                  name:'温度',
                  type:'line',
                  data:[${T}],
                  markPoint : {
                    data : [
                      {type : 'max', name: '最大值'},
                      {type : 'min', name: '最小值'}
                    ]
                  },
                  markLine : {
                    data : [
                      {type : 'average', name: '平均值'}
                    ]
                  }
                },
                {
                  name:'湿度',
                  type:'line',
                  data:[${H}],
                  markPoint : {
                    data : [
                      {type : 'max', name: '最大值'},
                      {type : 'min', name: '最小值'}
                    ]
                  },
                  markLine : {
                    data : [
                      {type : 'average', name : '平均值'}
                    ]
                  }
                }
              ]
            };

            // 为echarts对象加载数据
            myChart.setOption(option);
            music_init();
          }
  );
</script>

<div id="chartinit"  style="height:400px"></div>

</body>
</html>
