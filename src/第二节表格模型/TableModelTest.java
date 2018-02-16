package �ڶ��ڱ��ģ��;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
public class TableModelTest extends JFrame implements ActionListener{
	JPanel panel=new JPanel ();
	JButton addRow=new JButton("������");
	JButton addColumn=new JButton("������");
	JButton deleteRow=new JButton("ɾ����");
	JButton deleteColumn=new JButton("ɾ����");
	JButton[] buttonArray={addRow,addColumn,deleteRow,deleteColumn};
	String[] head={"��1��"};
	String[][] data={{"��1�е�1��"}};
	
	DefaultTableModel tableModel=new DefaultTableModel(data,head);//�������ģ��
	JTable table=new JTable(tableModel);//����JTable����
	
	JScrollPane scrollPane=new JScrollPane(table);
	
	public TableModelTest(){
		for(int i=0;i<buttonArray.length;i++){
			panel.add(buttonArray[i]);
			buttonArray[i].addActionListener(this);
		}
		this.add(panel,BorderLayout.NORTH);
		this.add(scrollPane, BorderLayout.CENTER);
		
		this.setTitle("���ģ�Ͳ���");
		this.setBounds(200,200,450,200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public void actionPerformed(ActionEvent e){
		DefaultTableModel temp=(DefaultTableModel)table.getModel();//��ñ��ģ��
		int c=temp.getColumnCount();//��ñ�������
		int r=temp.getRowCount();//��ñ�������
		if(e.getSource()==buttonArray[0]){//���¡������С���ťʱ
			Vector newR=new Vector();//�������е���������
			for(int i=0;i<c;i++){
				newR.add((r+1)+"��"+(i+1)+"��");//Ϊ���������������
			}
			temp.getDataVector().add(newR);//����������������ģ����
			//ˢ�±������»���
			((DefaultTableModel)table.getModel()).fireTableStructureChanged();
		}
		else if(e.getSource()==buttonArray[1]){//���¡������С���ť
			Vector newC=new Vector();
			for(int i=0;i<r;i++){
				newC.addElement((i+1)+"��"+(c+1)+"��");//Ϊ���������������
			}
			temp.addColumn("��"+(c+1)+"��",newC);//��������ӽ�����ģ����
		}
		else if(e.getSource()==buttonArray[2]){//���¡�ɾ���С���ť
			if(r>0){
				temp.removeRow(r-1);//ɾ�����һ��
			}
		}
		else if(e.getSource()==buttonArray[3]){//���¡�ɾ���С���ť
			if(c-1>0){
				//���ñ������Ϊ��ǰ������1��Ҳ�������һ�б�ɾ��
				temp.setColumnCount(c-1);
			}
		}
	}
	
	public static void main(String[] args) {
		new TableModelTest();
	}
}
