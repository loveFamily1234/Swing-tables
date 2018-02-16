package ������û���Ϣ���ʵ��;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;

public class UserInfoTable extends JFrame{
	//�����Զ�����ģ�Ͷ���tableModel
	MyTableModel tableModel=new MyTableModel();
	//����ָ�����ģ�ʹ���JTable����table
	JTable table=new JTable(tableModel);
	JScrollPane scrollPane=new JScrollPane(table);//���table������������
	
	public UserInfoTable(){
		table.setRowHeight(60);
		this.add(scrollPane,BorderLayout.CENTER);
		//�����Զ���ı����ɫ��Ⱦ��
		MyCellRendererForColorClass myCellRenderer=new MyCellRendererForColorClass();
		//����ע��ָ���������ݵ���Ⱦ��
		table.setDefaultRenderer(Color.class, myCellRenderer);
		//�����Զ���ı��༭����������ɫ�༭����ͼ��༭��
		MyEditorForColorClass myEditorForColor=new MyEditorForColorClass();
		MyEditorForIconClass myEditorForIcon=new MyEditorForIconClass();
		//����ע��ָ���������ݵı༭��
		table.setDefaultEditor(Color.class, myEditorForColor);
		table.setDefaultEditor(Icon.class, myEditorForIcon);
		
		this.setTitle("�û���Ϣ���(�Զ�����༭������Ⱦ��)");
		this.setBounds(200,200,700,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new UserInfoTable();
	}
}
