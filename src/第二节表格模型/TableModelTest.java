package 第二节表格模型;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
public class TableModelTest extends JFrame implements ActionListener{
	JPanel panel=new JPanel ();
	JButton addRow=new JButton("增加行");
	JButton addColumn=new JButton("增加列");
	JButton deleteRow=new JButton("删除行");
	JButton deleteColumn=new JButton("删除列");
	JButton[] buttonArray={addRow,addColumn,deleteRow,deleteColumn};
	String[] head={"第1列"};
	String[][] data={{"第1行第1列"}};
	
	DefaultTableModel tableModel=new DefaultTableModel(data,head);//创建表格模型
	JTable table=new JTable(tableModel);//创建JTable对象
	
	JScrollPane scrollPane=new JScrollPane(table);
	
	public TableModelTest(){
		for(int i=0;i<buttonArray.length;i++){
			panel.add(buttonArray[i]);
			buttonArray[i].addActionListener(this);
		}
		this.add(panel,BorderLayout.NORTH);
		this.add(scrollPane, BorderLayout.CENTER);
		
		this.setTitle("表格模型测试");
		this.setBounds(200,200,450,200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public void actionPerformed(ActionEvent e){
		DefaultTableModel temp=(DefaultTableModel)table.getModel();//获得表格模型
		int c=temp.getColumnCount();//获得表格的列数
		int r=temp.getRowCount();//获得表格的行数
		if(e.getSource()==buttonArray[0]){//按下“增加行”按钮时
			Vector newR=new Vector();//创建新行的数据向量
			for(int i=0;i<c;i++){
				newR.add((r+1)+"行"+(i+1)+"列");//为数据向量添加数据
			}
			temp.getDataVector().add(newR);//添加数据向量到表格模型中
			//刷新表格后重新绘制
			((DefaultTableModel)table.getModel()).fireTableStructureChanged();
		}
		else if(e.getSource()==buttonArray[1]){//按下“增加列”按钮
			Vector newC=new Vector();
			for(int i=0;i<r;i++){
				newC.addElement((i+1)+"行"+(c+1)+"列");//为数据向量添加数据
			}
			temp.addColumn("第"+(c+1)+"列",newC);//将新列添加进数据模型中
		}
		else if(e.getSource()==buttonArray[2]){//按下“删除行”按钮
			if(r>0){
				temp.removeRow(r-1);//删除最后一行
			}
		}
		else if(e.getSource()==buttonArray[3]){//按下“删除列”按钮
			if(c-1>0){
				//设置表的列数为当前列数减1，也就是最后一列被删除
				temp.setColumnCount(c-1);
			}
		}
	}
	
	public static void main(String[] args) {
		new TableModelTest();
	}
}
