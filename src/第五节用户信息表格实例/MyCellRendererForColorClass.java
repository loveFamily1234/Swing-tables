package ������û���Ϣ���ʵ��;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
//�Զ������Ⱦ���࣬�̳��Ա�ǩ�࣬ʵ�ֱ����Ⱦ��
public class MyCellRendererForColorClass extends JLabel implements TableCellRenderer{
	public MyCellRendererForColorClass(){
		this.setOpaque(true);//���ñ�ǩΪ��͸��״̬
		this.setHorizontalAlignment(JLabel.CENTER);//���ñ�ǩ�е��ı����뷽ʽΪ����
	}
	//ʵ�ֻ�ȡ��ʾ�����getTableCellRendererComponent����
	public Component getTableCellRendererComponent(JTable table,Object value,boolean isSelected,boolean hasFocus,int row,int column){
		Color c=(Color)value;//��ȡҪ��ʾ����ɫ
		this.setBackground(c);//���ñ���ɫ
		//����ǰ��ɫ��Ϊ����������ԣ�����������Ϊ����ɫ�ķ�ɫ
		this.setForeground(new Color(255-c.getRed(),255-c.getGreen(),255-c.getBlue()));
		this.setText("���ñ���ɫ");//���ñ�ǩ����ʾ����ʾ
		return this;
	}
}
