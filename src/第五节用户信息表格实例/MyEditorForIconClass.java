package 第五节用户信息表格实例;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
//自定义Icon类型的编辑器MyEditorForIconClass，继承自AbstractCellEditor，实现两个接口
public class MyEditorForIconClass extends AbstractCellEditor implements TableCellEditor,ActionListener{
	Icon icon;
	JButton iconButton=new JButton();//创建一个图片按钮
	JFileChooser fileChooser=new JFileChooser();//创建文件选择器对象
	public static final String EDIT="edit";//声明一个编辑常量
	public MyEditorForIconClass(){
		iconButton.addActionListener(this);//为图片按钮注册监听器
		iconButton.setActionCommand(EDIT);//设置按钮动作命令为EDIT
	}
	public void actionPerformed(ActionEvent e){
		//测试获得的动作命令是否与EDIT常量相等
		if(e.getActionCommand().equals(EDIT)){
			iconButton.setIcon(icon);//设置按钮的图标
			fileChooser.showOpenDialog(iconButton);//文件选择对话框，选择图片
			if(fileChooser.getSelectedFile()!=null){
				//如果选择了新图片，将新图片设置为按钮的图标
				icon=new ImageIcon(fileChooser.getSelectedFile().getAbsolutePath());
			}
			this.fireEditingStopped();//通知所有监听器，以延迟方式创建事件对象
		}
	}
	//定义getCellEditorValue方法返回图标
	public Object getCellEditorValue(){
		return icon;//返回图标
	}
	//重写getTableCellEditComponent方法
	public Component getTableCellEditorComponent(JTable table,Object value,boolean isSelected,int row,int column){
		icon=(Icon)value;
		return iconButton;//返回图片按钮
	}

}
