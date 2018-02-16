package 第四节表格事件;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;

public class TableEventTest extends JFrame{
	String[] head={"商品ID","商品名称","商品原价","成交金额","处理情况"};
	
	String[] data1={"1001","怀旧牛仔裤","200.0","120.0","已发货"};
	String[] data2={"1002","长袖针织衬衫","110.0","85.0","交易完毕"};
	String[] data3={"1003","波西米亚长裙","300.0","180.0","待发货"};
	String[] data4={"1004","短装牛仔服","90.0","47.0","等待处理"};
	String[][] data={data1,data2,data3,data4};
	
	DefaultTableModel tableModel=new DefaultTableModel(data,head);
	JTable table=new JTable(tableModel);
	JScrollPane scrollPane=new JScrollPane(table);
	
	JTextField textField=new JTextField("选中或更改表格内容的信息将显示在此文本框中");
	
	TableListener tableListener=new TableListener();
	
	public TableEventTest(){
		//使用TableModel接口中定义的getColumnCount方法，根据数据模型创建默认的表列
		table.createDefaultColumnsFromModel();
		//表格选择模型注册监听器
		table.getSelectionModel().addListSelectionListener(tableListener);
		//表格列模型注册监听器
		table.getColumnModel().addColumnModelListener(tableListener);
		//表格模型注册监听器
		table.getModel().addTableModelListener(tableListener);
		
		this.add(scrollPane,BorderLayout.NORTH);
		textField.setEditable(false);
		this.add(textField, BorderLayout.SOUTH);
		
		this.setTitle("表格事件测试");
		this.setBounds(200,200,500,200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		new TableEventTest();
	}

	//定义自定义的监听器内部类TableListener,实现了3个监听器接口
    class TableListener implements ListSelectionListener,TableColumnModelListener,TableModelListener{
	   int row=0;//定义行索引
	   int col=0;//定义列索引
	   //实现ListSelectionListener监听接口中的方法valueChanged
	   public void valueChanged(ListSelectionEvent e){//当选中发生变化时
		  row=table.getSelectedRow();//获取当前选择的行索引
		  this.showMessage(row,col);//调用showMessage方法
	  }
	   
	   //实现TableColumnModelListener监听接口中的方法columnSelectionChanged
	   public void columnSelectionChanged(ListSelectionEvent e){//当选中列发生变化时
		   col=table.getSelectedColumn();//获取当前选择的列索引
		   this.showMessage(row,col);//调用showMessage方法
	   }
	   //TableColumnModelListener监听接口中不需要的方法仍需要空实现
	   public void columnMarginChanged(ChangeEvent ce){}
	   public void columnMoved(TableColumnModelEvent tcme){}
	   public void columnRemoved(TableColumnModelEvent tcme){}
	   public void columnAdded(TableColumnModelEvent tcme){}
	   
	   //实现TableModelListener监听接口中的方法
	   public void tableChanged(TableModelEvent e){//当表格内容变化时执行此方法
		   String str=(String)table.getValueAt(row, col);//获取当前选择单元格的值
		   //设置提示信息
		   textField.setText("注意：您将第"+(row+1)+"行第"+(col+1)+"列的内容更改为："+str+"。");
	   }
	   //定义显示提示信息的方法showMessage
	   public void showMessage(int r,int c){
		   String str=(String)table.getValueAt(r,c);//获取当前选择单元格的值
		   //设置显示信息
		   textField.setText("您选择的是第"+(r+1)+"行第"+(c+1)+"列的表示“"+table.getColumnName(c)+"”的单元格，其内容为：“"+str+"”。");
	   }
   }
}
