package ������û���Ϣ���ʵ��;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel{
	String[] head={"��ԱID","����","�Ա�(���Դ�)","����","���","ͷ��","����ɫ"};
	//���������͵����飬����Ԫ�ذ��ձ���������͵�˳������
	Class[] typeArray={Object.class,Object.class,Boolean.class,Object.class,Double.class,Icon.class,Color.class};
	//����ÿ�г�ʼ������ݵ�����
	Object[] data1={"10001","ľľ���",false,23,1588.5,new ImageIcon("E:\\ͼƬ\\����ɭ\\1.jpg"),Color.ORANGE};
	Object[] data2={"10002","ȫְɱ��",true,24,2300.0,new ImageIcon("E:\\ͼƬ\\����ɭ\\2.jpg"),Color.BLUE};
	Object[] data3={"10003","�����̿�",true,20,500.2,new ImageIcon("E:\\ͼƬ\\����ɭ\\3.jpg"),Color.GREEN};
	Object[] data4={"10004","������",false,28,5000.0,new ImageIcon("E:\\ͼƬ\\����ɭ\\4.jpg"),Color.YELLOW};
	
	Object[][] data={data1,data2,data3,data4};
	//��дAbstractTableModel�еķ���
	public int getColumnCount(){//��дgetColumnCount���������ر�������
		return head.length;
	}
	public int getRowCount(){//��д�����ر�������
		return data.length;
	}
	public String getColumnName(int col){//��д������ָ���еı���
		return head[col];
	}
	public Object getValueAt(int r,int c){//��д������ָ���к��е�Ԫ���ֵ
		return data[r][c];
	}
	public Class getColumnClass(int c){//��д�������е���������
		return typeArray[c];
	}
	public boolean isCellEditable(int r,int c){//��д������ָ���к��еĵ�Ԫ��༭
		return true;
	}
	
	//��дsetValueAt��������ָ��ֵ����ָ���ĵ�Ԫ��
	public void setValueAt(Object value,int r,int c){
		data[r][c]=value;
		this.fireTableCellUpdated(r, c);//֪ͨ�������Ѹ���ָ����Ԫ���ֵ
	}
}
