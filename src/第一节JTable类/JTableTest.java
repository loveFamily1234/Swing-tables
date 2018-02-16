package 第一节JTable类;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class JTableTest extends JFrame{//定义JTableTest类，继承JFrame
	Vector vdata=new Vector();//创建包含表格数据的向量
	{
		//创建表示行数据的子向量
		Vector tempv1=new Vector();
	    Vector tempv2=new Vector();
	    Vector tempv3=new Vector();
	    Vector tempv4=new Vector();
	    Vector []tempv={tempv1,tempv2,tempv3,tempv4};
	    //创建数据数组
	    String []data1={"1001","怀旧牛仔裤","200.0","120.0","已发货"};
	    String []data2={"1002","长袖针织衬衫","110.0","85.0","交易完毕"};
	    String []data3={"1003","波西米亚长裙","300.0","180.0","待发货"};
	    String []data4={"1004","短装牛仔服","90.0","47.0","等待处理"};
	    String [][]datav={data1,data2,data3,data4};
	    for(int i=0;i<tempv.length;i++){
	    	for(int j=0;j<data1.length;j++){//为表示行数据的子向量添加数据
	    		//依次将每行的字符串数组添加到表示行数据的子向量中
	    		tempv[i].add(datav[i][j]);
	    	}
	    	vdata.add(tempv[i]);//添加行数据的子向量到包含表格数据的向量中
	    }
	} 
	Vector vhead=new Vector();//创建包含表格标题的向量
	{
		//创建表格标题的字符串数组
		String[] dataHead={"商品ID","商品名称","商品原价","成交金额","处理情况"};
		for(int i=0;i<dataHead.length;i++){
			vhead.add(dataHead[i]);//将标题的字符串添加到包含表格标题的向量中
		}
	}
	JTable table=new JTable(vdata,vhead);//创建表格对象
	JScrollPane scrollPane=new JScrollPane(table);//将表格封装进滚动窗格
	public JTableTest(){
//		table.setShowVerticalLines(false);//设置不绘制表格的垂直线
		table.setRowHeight(3,30);//设置指定行行高
		table.setGridColor(Color.red);//设置网格线的颜色为灰色
		this.add(scrollPane);//将表格的滚动窗格添加进窗体
		//设置窗体的标题、位置、大小、可见性以及关闭动作
		this.setTitle("购物网站表格");
		this.setBounds(200,200,450,150);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new JTableTest();//创建JTableTest窗体对象
	}	
}
