package ��һ��JTable��;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class JTableTest extends JFrame{//����JTableTest�࣬�̳�JFrame
	Vector vdata=new Vector();//��������������ݵ�����
	{
		//������ʾ�����ݵ�������
		Vector tempv1=new Vector();
	    Vector tempv2=new Vector();
	    Vector tempv3=new Vector();
	    Vector tempv4=new Vector();
	    Vector []tempv={tempv1,tempv2,tempv3,tempv4};
	    //������������
	    String []data1={"1001","����ţ�п�","200.0","120.0","�ѷ���"};
	    String []data2={"1002","������֯����","110.0","85.0","�������"};
	    String []data3={"1003","�������ǳ�ȹ","300.0","180.0","������"};
	    String []data4={"1004","��װţ�з�","90.0","47.0","�ȴ�����"};
	    String [][]datav={data1,data2,data3,data4};
	    for(int i=0;i<tempv.length;i++){
	    	for(int j=0;j<data1.length;j++){//Ϊ��ʾ�����ݵ��������������
	    		//���ν�ÿ�е��ַ���������ӵ���ʾ�����ݵ���������
	    		tempv[i].add(datav[i][j]);
	    	}
	    	vdata.add(tempv[i]);//��������ݵ�������������������ݵ�������
	    }
	} 
	Vector vhead=new Vector();//�������������������
	{
		//������������ַ�������
		String[] dataHead={"��ƷID","��Ʒ����","��Ʒԭ��","�ɽ����","�������"};
		for(int i=0;i<dataHead.length;i++){
			vhead.add(dataHead[i]);//��������ַ�����ӵ������������������
		}
	}
	JTable table=new JTable(vdata,vhead);//����������
	JScrollPane scrollPane=new JScrollPane(table);//������װ����������
	public JTableTest(){
//		table.setShowVerticalLines(false);//���ò����Ʊ��Ĵ�ֱ��
		table.setRowHeight(3,30);//����ָ�����и�
		table.setGridColor(Color.red);//���������ߵ���ɫΪ��ɫ
		this.add(scrollPane);//�����Ĺ���������ӽ�����
		//���ô���ı��⡢λ�á���С���ɼ����Լ��رն���
		this.setTitle("������վ���");
		this.setBounds(200,200,450,150);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new JTableTest();//����JTableTest�������
	}	
}
