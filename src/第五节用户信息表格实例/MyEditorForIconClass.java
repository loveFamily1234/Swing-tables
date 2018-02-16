package ������û���Ϣ���ʵ��;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
//�Զ���Icon���͵ı༭��MyEditorForIconClass���̳���AbstractCellEditor��ʵ�������ӿ�
public class MyEditorForIconClass extends AbstractCellEditor implements TableCellEditor,ActionListener{
	Icon icon;
	JButton iconButton=new JButton();//����һ��ͼƬ��ť
	JFileChooser fileChooser=new JFileChooser();//�����ļ�ѡ��������
	public static final String EDIT="edit";//����һ���༭����
	public MyEditorForIconClass(){
		iconButton.addActionListener(this);//ΪͼƬ��ťע�������
		iconButton.setActionCommand(EDIT);//���ð�ť��������ΪEDIT
	}
	public void actionPerformed(ActionEvent e){
		//���Ի�õĶ��������Ƿ���EDIT�������
		if(e.getActionCommand().equals(EDIT)){
			iconButton.setIcon(icon);//���ð�ť��ͼ��
			fileChooser.showOpenDialog(iconButton);//�ļ�ѡ��Ի���ѡ��ͼƬ
			if(fileChooser.getSelectedFile()!=null){
				//���ѡ������ͼƬ������ͼƬ����Ϊ��ť��ͼ��
				icon=new ImageIcon(fileChooser.getSelectedFile().getAbsolutePath());
			}
			this.fireEditingStopped();//֪ͨ���м����������ӳٷ�ʽ�����¼�����
		}
	}
	//����getCellEditorValue��������ͼ��
	public Object getCellEditorValue(){
		return icon;//����ͼ��
	}
	//��дgetTableCellEditComponent����
	public Component getTableCellEditorComponent(JTable table,Object value,boolean isSelected,int row,int column){
		icon=(Icon)value;
		return iconButton;//����ͼƬ��ť
	}

}
