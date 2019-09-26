package com.qifeixianapp.qfxdemo.Activitiy;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.qifeixianapp.qfxdemo.CellView.MyMarkerView;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.tool.TestandroidjsUnitl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class TsetAndroidActivity extends AppCompatActivity implements OnTitleBarListener {
    TitleBar titleBar;
    LineChart lineChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tset_android);
        titleBar=findViewById(R.id.Testjsanzroid);
        lineChart=findViewById(R.id.chart_linechart);
        linechartSetting(lineChart);
        //自定义的MarkerView对象
        MyMarkerView mv = new MyMarkerView(this, R.layout.activity_my_marker_view);
        mv.setChartView(lineChart);
        lineChart.setMarker(mv);
    }
    public  void linechartSetting(LineChart lineChart) {

        Description description = new Description();
        description.setText("测试图表");
        description.setTextColor(Color.RED);
        description.setTextSize(20);
        lineChart.setDescription(description);//设置图表描述信息
        lineChart.setNoDataText("没有数据熬");//没有数据时显示的文字
        lineChart.setNoDataTextColor(Color.BLUE);//没有数据时显示文字的颜色
        lineChart.setDrawGridBackground(false);//chart 绘图区后面的背景矩形将绘制
        lineChart.setDrawBorders(false);//禁止绘制图表边框的线
        //lineChart.setBorderColor(); //设置 chart 边框线的颜色。
        //lineChart.setBorderWidth(); //设置 chart 边界线的宽度，单位 dp。
        //lineChart.setLogEnabled(true);//打印日志
        //lineChart.notifyDataSetChanged();//刷新数据
        //lineChart.invalidate();//重绘

        /**
         * Entry 坐标点对象  构造函数 第一个参数为x点坐标 第二个为y点
         */
        ArrayList<Entry> values1 = new ArrayList<>();
        ArrayList<Entry> values2 = new ArrayList<>();
        ArrayList<Entry> values3 = new ArrayList<>();

        values1.add(new Entry(1, 10));
        values1.add(new Entry(2, 15));
        values1.add(new Entry(3, 20));
        values1.add(new Entry(4, 5));
        values1.add(new Entry(5, 30));
        values1.add(new Entry(6, 120));
        values1.add(new Entry(7, 30));

//        values2.add(new Entry(1, 110));
//        values2.add(new Entry(2, 115));
//        values2.add(new Entry(3, 130));
//        values2.add(new Entry(4, 85));
//        values2.add(new Entry(5, 90));
//
//
//        values3.add(new Entry(1, 10));
//        values3.add(new Entry(2, 12));
//        values3.add(new Entry(3, 15));
//        values3.add(new Entry(4, 13));
//        values3.add(new Entry(5, 14));
        //LineDataSet每一个对象就是一条连接线
        LineDataSet set1;
//        LineDataSet set2;
//        LineDataSet set3;
        //判断图表中原来是否有数据
        if (lineChart.getData() != null &&
                lineChart.getData().getDataSetCount() > 0) {
            //获取数据1
            set1 = (LineDataSet) lineChart.getData().getDataSetByIndex(0);
            set1.setValues(values1);
//            set2 = (LineDataSet) lineChart.getData().getDataSetByIndex(1);
//            set2.setValues(values2);
//            set2 = (LineDataSet) lineChart.getData().getDataSetByIndex(2);
//            set2.setValues(values3);
            //刷新数据
            lineChart.getData().notifyDataChanged();
            lineChart.notifyDataSetChanged();
        } else {
            //设置数据1  参数1：数据源 参数2：图例名称
            set1 = new LineDataSet(values1, "测试数据1");
            set1.setColor(Color.BLACK);
            set1.setCircleColor(Color.BLACK);
            set1.setLineWidth(1f);//设置线宽
            set1.setCircleRadius(3f);//设置焦点圆心的大小
            set1.enableDashedHighlightLine(3f, 5f, 0f);//点击后的高亮线的显示样式
            set1.setHighlightLineWidth(2f);//设置点击交点后显示高亮线宽
            set1.setHighlightEnabled(false);//是否禁用点击高亮线
            set1.setHighLightColor(Color.RED);//设置点击交点后显示交高亮线的颜色
            set1.setValueTextSize(9f);//设置显示值的文字大小
            set1.setDrawFilled(false);//设置禁用范围背景填充


            if (Utils.getSDKInt() >= 18) {
                // fill drawable only supported on api level 18 and above
                Drawable drawable = ContextCompat.getDrawable(this, R.drawable.fb);
                set1.setFillDrawable(drawable);//设置范围背景填充
            } else {
                set1.setFillColor(Color.BLACK);
            }

//            //设置数据2
//            set2 = new LineDataSet(values2, "测试数据2");
//            set2.setColor(Color.GRAY);
//            set2.setCircleColor(Color.GRAY);
//            set2.setLineWidth(1f);
//            set2.setCircleRadius(3f);
//            set2.setValueTextSize(10f);
//
//
//            //设置数据2
//            set3 = new LineDataSet(values3, "测试数据3");
//            set3.setColor(Color.GRAY);
//            set3.setCircleColor(Color.GRAY);
//            set3.setLineWidth(1f);
//            set3.setCircleRadius(3f);
//            set3.setValueTextSize(10f);
//            //保存LineDataSet集合
            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1); // add the datasets
//            dataSets.add(set2);
//            dataSets.add(set3);
            //创建LineData对象 属于LineChart折线图的数据集合
            LineData data = new LineData(dataSets);
            // 添加到图表中
            lineChart.setData(data);
            //绘制图表
            lineChart.invalidate();

        }
        //获取此图表的x轴
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setEnabled(true);//设置轴启用或禁用 如果禁用以下的设置全部不生效
        xAxis.setDrawAxisLine(true);//是否绘制轴线
        xAxis.setDrawGridLines(true);//设置x轴上每个点对应的线
        xAxis.setDrawLabels(true);//绘制标签  指x轴上的对应数值
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//设置x轴的显示位置
        //xAxis.setTextSize(20f);//设置字体
        //xAxis.setTextColor(Color.BLACK);//设置字体颜色
        //设置竖线的显示样式为虚线
        //lineLength控制虚线段的长度
        //spaceLength控制线之间的空间
        xAxis.enableGridDashedLine(5f, 5f, 1f);
//        xAxis.setAxisMinimum(0f);//设置x轴的最小值
//        xAxis.setAxisMaximum(10f);//设置最大值
        xAxis.setAvoidFirstLastClipping(true);//图表将避免第一个和最后一个标签条目被减掉在图表或屏幕的边缘
//        xAxis.setLabelRotationAngle(10f);//设置x轴标签的旋转角度
//        设置x轴显示标签数量  还有一个重载方法第二个参数为布尔值强制设置数量 如果启用会导致绘制点出现偏差
//        xAxis.setLabelCount(10);
//        xAxis.setTextColor(Color.BLUE);//设置轴标签的颜色
//        xAxis.setTextSize(24f);//设置轴标签的大小
//        xAxis.setGridLineWidth(10f);//设置竖线大小
//        xAxis.setGridColor(Color.RED);//设置竖线颜色
//        xAxis.setAxisLineColor(Color.GREEN);//设置x轴线颜色
//        xAxis.setAxisLineWidth(5f);//设置x轴线宽度
//        xAxis.setValueFormatter();//格式化x轴标签显示字符

        /**
         * Y轴默认显示左右两个轴线
         */
        //获取右边的轴线
        YAxis rightAxis=lineChart.getAxisRight();
        //设置图表右边的y轴禁用
        rightAxis.setEnabled(false);

        //获取左边的轴线
        YAxis leftAxis = lineChart.getAxisLeft();
        //设置网格线为虚线效果
        leftAxis.enableGridDashedLine(5f, 5f, 0f);
        //是否绘制0所在的网格线
        leftAxis.setDrawZeroLine(false);
        lineChart.setTouchEnabled(true); // 设置是否可以触摸
        lineChart.setDragEnabled(true);// 是否可以拖拽
        lineChart.setScaleEnabled(false);// 是否可以缩放 x和y轴, 默认是true
        lineChart.setScaleXEnabled(true); //是否可以缩放 仅x轴
        lineChart.setScaleYEnabled(false); //是否可以缩放 仅y轴
        lineChart.setPinchZoom(true);  //设置x轴和y轴能否同时缩放。默认是否
        lineChart.setDoubleTapToZoomEnabled(true);//设置是否可以通过双击屏幕放大图表。默认是true
        lineChart.setHighlightPerDragEnabled(true);//能否拖拽高亮线(数据点与坐标的提示线)，默认是true
        lineChart.setDragDecelerationEnabled(true);//拖拽滚动时，手放开是否会持续滚动，默认是true（false是拖到哪是哪，true拖拽之后还会有缓冲）
        lineChart.setDragDecelerationFrictionCoef(0.99f);//与上面那个属性配合，持续滚动时的速度快慢，[0,1) 0代表立即停止。
        Legend l = lineChart.getLegend();//图例
//        l.setPosition(Legend.LegendPosition.RIGHT_OF_CHART_INSIDE);//设置图例的位置
//        l.setTextSize(10f);//设置文字大小
//        l.setForm(Legend.LegendForm.CIRCLE);//正方形，圆形或线
//        l.setFormSize(10f); // 设置Form的大小
//        l.setWordWrapEnabled(true);//是否支持自动换行 目前只支持BelowChartLeft, BelowChartRight, BelowChartCenter
//        l.setFormLineWidth(10f);//设置Form的宽度
        // animateX(int durationMillis) : 水平轴动画 在指定时间内 从左到右
//        animateY(int durationMillis) : 垂直轴动画 从下到上
//        animateXY(int xDuration, int yDuration) : 两个轴动画，从左到右，从下到上
        lineChart.animateXY(1000,1000);
    }



    @Override
    public void onLeftClick(View v) {
        finish();
    }

    @Override
    public void onTitleClick(View v) {

    }

    @Override
    public void onRightClick(View v) {

    }
}
