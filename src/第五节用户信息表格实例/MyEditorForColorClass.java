package 第五节用户信息表格实例;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.TableCellEditor;

//声明Color类型的自定义编辑器，继承自AbstractCellEditor类，实现TableCellEditor和ActionListener接口
public class MyEditorForColorClass extends AbstractCellEditor implements TableCellEditor,ActionListener{
	Color c;
	JDialog dialog;//对话框
	JButton colorButton=new JButton();//创建一个按钮
	JColorChooser colorChooser=new JColorChooser();//创建颜色选择器对象
	public static final String EDIT="edit";
	public MyEditorForColorClass(){
		colorButton.addActionListener(this);
		colorButton.setActionCommand(EDIT);//设置颜色按钮的动作命令
		//获取颜色选择器对话框
		dialog=JColorChooser.createDialog(colorButton, "选择颜色", true, colorChooser, this, null);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals(EDIT)){//测试获得动作命令是否等于EDIT常量
			colorButton.setBackground(c);//设置按钮的背景色
			//设置前景色为背景色反色
			colorButton.setForeground(new Color(255-c.getRed(),255-c.getGreen(),255-c.getBlue()));
			colorChooser.setColor(c);//设置颜色选择器的颜色
			dialog.setVisible(true);//设置颜色选择器可见
			
			this.fireEditingStopped();//通知所有监听器，以延迟方式创建事件对象
		}
		else{
			c=colorChooser.getColor();//获取选择的颜色
		}
	}
	//定义getCellEditorValue方法，返回颜色变量
	public Object getCellEditorValue(){
		return c;
	}
	//重写getTableCellEditorComponent方法
	public Component getTableCellEditorComponent(JTable table,Object value,boolean isSelected,int row,int column){
		c=(Color)value;
		return colorButton;
	}
}
