package ���Ľڱ���¼�;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;

public class TableEventTest extends JFrame{
	String[] head={"��ƷID","��Ʒ����","��Ʒԭ��","�ɽ����","�������"};
	
	String[] data1={"1001","����ţ�п�","200.0","120.0","�ѷ���"};
	String[] data2={"1002","������֯����","110.0","85.0","�������"};
	String[] data3={"1003","�������ǳ�ȹ","300.0","180.0","������"};
	String[] data4={"1004","��װţ�з�","90.0","47.0","�ȴ�����"};
	String[][] data={data1,data2,data3,data4};
	
	DefaultTableModel tableModel=new DefaultTableModel(data,head);
	JTable table=new JTable(tableModel);
	JScrollPane scrollPane=new JScrollPane(table);
	
	JTextField textField=new JTextField("ѡ�л���ı�����ݵ���Ϣ����ʾ�ڴ��ı�����");
	
	TableListener tableListener=new TableListener();
	
	public TableEventTest(){
		//ʹ��TableModel�ӿ��ж����getColumnCount��������������ģ�ʹ���Ĭ�ϵı���
		table.createDefaultColumnsFromModel();
		//���ѡ��ģ��ע�������
		table.getSelectionModel().addListSelectionListener(tableListener);
		//�����ģ��ע�������
		table.getColumnModel().addColumnModelListener(tableListener);
		//���ģ��ע�������
		table.getModel().addTableModelListener(tableListener);
		
		this.add(scrollPane,BorderLayout.NORTH);
		textField.setEditable(false);
		this.add(textField, BorderLayout.SOUTH);
		
		this.setTitle("����¼�����");
		this.setBounds(200,200,500,200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		new TableEventTest();
	}

	//�����Զ���ļ������ڲ���TableListener,ʵ����3���������ӿ�
    class TableListener implements ListSelectionListener,TableColumnModelListener,TableModelListener{
	   int row=0;//����������
	   int col=0;//����������
	   //ʵ��ListSelectionListener�����ӿ��еķ���valueChanged
	   public void valueChanged(ListSelectionEvent e){//��ѡ�з����仯ʱ
		  row=table.getSelectedRow();//��ȡ��ǰѡ���������
		  this.showMessage(row,col);//����showMessage����
	  }
	   
	   //ʵ��TableColumnModelListener�����ӿ��еķ���columnSelectionChanged
	   public void columnSelectionChanged(ListSelectionEvent e){//��ѡ���з����仯ʱ
		   col=table.getSelectedColumn();//��ȡ��ǰѡ���������
		   this.showMessage(row,col);//����showMessage����
	   }
	   //TableColumnModelListener�����ӿ��в���Ҫ�ķ�������Ҫ��ʵ��
	   public void columnMarginChanged(ChangeEvent ce){}
	   public void columnMoved(TableColumnModelEvent tcme){}
	   public void columnRemoved(TableColumnModelEvent tcme){}
	   public void columnAdded(TableColumnModelEvent tcme){}
	   
	   //ʵ��TableModelListener�����ӿ��еķ���
	   public void tableChanged(TableModelEvent e){//��������ݱ仯ʱִ�д˷���
		   String str=(String)table.getValueAt(row, col);//��ȡ��ǰѡ��Ԫ���ֵ
		   //������ʾ��Ϣ
		   textField.setText("ע�⣺������"+(row+1)+"�е�"+(col+1)+"�е����ݸ���Ϊ��"+str+"��");
	   }
	   //������ʾ��ʾ��Ϣ�ķ���showMessage
	   public void showMessage(int r,int c){
		   String str=(String)table.getValueAt(r,c);//��ȡ��ǰѡ��Ԫ���ֵ
		   //������ʾ��Ϣ
		   textField.setText("��ѡ����ǵ�"+(r+1)+"�е�"+(c+1)+"�еı�ʾ��"+table.getColumnName(c)+"���ĵ�Ԫ��������Ϊ����"+str+"����");
	   }
   }
}
