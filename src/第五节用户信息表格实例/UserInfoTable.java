package 第五节用户信息表格实例;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;

public class UserInfoTable extends JFrame{
	//创建自定义表格模型对象tableModel
	MyTableModel tableModel=new MyTableModel();
	//根据指定表格模型创建JTable对象table
	JTable table=new JTable(tableModel);
	JScrollPane scrollPane=new JScrollPane(table);//添加table到滚动窗格中
	
	public UserInfoTable(){
		table.setRowHeight(60);
		this.add(scrollPane,BorderLayout.CENTER);
		//创建自定义的表格颜色渲染器
		MyCellRendererForColorClass myCellRenderer=new MyCellRendererForColorClass();
		//向表格注册指定类型数据的渲染器
		table.setDefaultRenderer(Color.class, myCellRenderer);
		//创建自定义的表格编辑器，包括颜色编辑器和图像编辑器
		MyEditorForColorClass myEditorForColor=new MyEditorForColorClass();
		MyEditorForIconClass myEditorForIcon=new MyEditorForIconClass();
		//向表格注册指定类型数据的编辑器
		table.setDefaultEditor(Color.class, myEditorForColor);
		table.setDefaultEditor(Icon.class, myEditorForIcon);
		
		this.setTitle("用户信息表格(自定义表格编辑器和渲染器)");
		this.setBounds(200,200,700,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new UserInfoTable();
	}
}
