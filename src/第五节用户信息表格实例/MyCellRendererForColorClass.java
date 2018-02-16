package 第五节用户信息表格实例;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
//自定义的渲染器类，继承自标签类，实现表格渲染器
public class MyCellRendererForColorClass extends JLabel implements TableCellRenderer{
	public MyCellRendererForColorClass(){
		this.setOpaque(true);//设置标签为不透明状态
		this.setHorizontalAlignment(JLabel.CENTER);//设置标签中的文本对齐方式为居中
	}
	//实现获取显示组件的getTableCellRendererComponent方法
	public Component getTableCellRendererComponent(JTable table,Object value,boolean isSelected,boolean hasFocus,int row,int column){
		Color c=(Color)value;//获取要显示的颜色
		this.setBackground(c);//设置背景色
		//设置前景色，为了清楚、明显，这里设置其为背景色的反色
		this.setForeground(new Color(255-c.getRed(),255-c.getGreen(),255-c.getBlue()));
		this.setText("设置背景色");//设置标签中显示的提示
		return this;
	}
}
