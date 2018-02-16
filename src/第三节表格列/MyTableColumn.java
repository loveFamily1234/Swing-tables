package 第三节表格列;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
//定义我的表格列MyTableColumn类，继承自JFrame类
public class MyTableColumn extends JFrame{
	String[] head={"A","C","D","B","H","I","G","E","F"};
	String[][] data={{"a","b","c","d","e","f","g","h","i"},{"1","2","3","4","5","6","7","8","9"},{"一","二","三","四","五","六","七","八","九"}};
	DefaultTableModel tableModel=new DefaultTableModel(data,head);
	MyColumnModel myColumnModel=new MyColumnModel();
	JTable table=new JTable(tableModel,myColumnModel);
	JScrollPane scrollPane=new JScrollPane(table);
	
	public MyTableColumn(){
		//使用TableModel接口中的getColumnCount方法，根据数据模型创建默认的表列
		table.createDefaultColumnsFromModel();
		
		this.add(scrollPane,BorderLayout.CENTER);
		
		this.setTitle("我的表格列");
		this.setBounds(200,200,500,150);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MyTableColumn();
	}
}
