package ������û���Ϣ���ʵ��;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.TableCellEditor;

//����Color���͵��Զ���༭�����̳���AbstractCellEditor�࣬ʵ��TableCellEditor��ActionListener�ӿ�
public class MyEditorForColorClass extends AbstractCellEditor implements TableCellEditor,ActionListener{
	Color c;
	JDialog dialog;//�Ի���
	JButton colorButton=new JButton();//����һ����ť
	JColorChooser colorChooser=new JColorChooser();//������ɫѡ��������
	public static final String EDIT="edit";
	public MyEditorForColorClass(){
		colorButton.addActionListener(this);
		colorButton.setActionCommand(EDIT);//������ɫ��ť�Ķ�������
		//��ȡ��ɫѡ�����Ի���
		dialog=JColorChooser.createDialog(colorButton, "ѡ����ɫ", true, colorChooser, this, null);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals(EDIT)){//���Ի�ö��������Ƿ����EDIT����
			colorButton.setBackground(c);//���ð�ť�ı���ɫ
			//����ǰ��ɫΪ����ɫ��ɫ
			colorButton.setForeground(new Color(255-c.getRed(),255-c.getGreen(),255-c.getBlue()));
			colorChooser.setColor(c);//������ɫѡ��������ɫ
			dialog.setVisible(true);//������ɫѡ�����ɼ�
			
			this.fireEditingStopped();//֪ͨ���м����������ӳٷ�ʽ�����¼�����
		}
		else{
			c=colorChooser.getColor();//��ȡѡ�����ɫ
		}
	}
	//����getCellEditorValue������������ɫ����
	public Object getCellEditorValue(){
		return c;
	}
	//��дgetTableCellEditorComponent����
	public Component getTableCellEditorComponent(JTable table,Object value,boolean isSelected,int row,int column){
		c=(Color)value;
		return colorButton;
	}
}
