package �����ڱ����;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
//�����ҵı����MyTableColumn�࣬�̳���JFrame��
public class MyTableColumn extends JFrame{
	String[] head={"A","C","D","B","H","I","G","E","F"};
	String[][] data={{"a","b","c","d","e","f","g","h","i"},{"1","2","3","4","5","6","7","8","9"},{"һ","��","��","��","��","��","��","��","��"}};
	DefaultTableModel tableModel=new DefaultTableModel(data,head);
	MyColumnModel myColumnModel=new MyColumnModel();
	JTable table=new JTable(tableModel,myColumnModel);
	JScrollPane scrollPane=new JScrollPane(table);
	
	public MyTableColumn(){
		//ʹ��TableModel�ӿ��е�getColumnCount��������������ģ�ʹ���Ĭ�ϵı���
		table.createDefaultColumnsFromModel();
		
		this.add(scrollPane,BorderLayout.CENTER);
		
		this.setTitle("�ҵı����");
		this.setBounds(200,200,500,150);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MyTableColumn();
	}
}
