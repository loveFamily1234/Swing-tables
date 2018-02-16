package 第五节用户信息表格实例;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel{
	String[] head={"会员ID","姓名","性别(男性打勾)","年龄","余额","头像","背景色"};
	//创建列类型的数组，数组元素按照表格中列类型的顺序排列
	Class[] typeArray={Object.class,Object.class,Boolean.class,Object.class,Double.class,Icon.class,Color.class};
	//创建每列初始表格数据的数组
	Object[] data1={"10001","木木秋风",false,23,1588.5,new ImageIcon("E:\\图片\\艾弗森\\1.jpg"),Color.ORANGE};
	Object[] data2={"10002","全职杀手",true,24,2300.0,new ImageIcon("E:\\图片\\艾弗森\\2.jpg"),Color.BLUE};
	Object[] data3={"10003","浪漫刺客",true,20,500.2,new ImageIcon("E:\\图片\\艾弗森\\3.jpg"),Color.GREEN};
	Object[] data4={"10004","玛利亚",false,28,5000.0,new ImageIcon("E:\\图片\\艾弗森\\4.jpg"),Color.YELLOW};
	
	Object[][] data={data1,data2,data3,data4};
	//重写AbstractTableModel中的方法
	public int getColumnCount(){//重写getColumnCount方法，返回表格的列数
		return head.length;
	}
	public int getRowCount(){//重写，返回表格的行数
		return data.length;
	}
	public String getColumnName(int col){//重写，返回指定列的标题
		return head[col];
	}
	public Object getValueAt(int r,int c){//重写，返回指定行和列单元格的值
		return data[r][c];
	}
	public Class getColumnClass(int c){//重写，返回列的数据类型
		return typeArray[c];
	}
	public boolean isCellEditable(int r,int c){//重写，允许指定行和列的单元格编辑
		return true;
	}
	
	//重写setValueAt方法，将指定值赋给指定的单元格
	public void setValueAt(Object value,int r,int c){
		data[r][c]=value;
		this.fireTableCellUpdated(r, c);//通知监听器已更改指定单元格的值
	}
}
