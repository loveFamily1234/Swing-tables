package 第三节表格列;

import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

//自定义的表格列模型类MyColumnModel,继承自DefaultTableColumnModel类
public class MyColumnModel extends DefaultTableColumnModel{
	//继承默认表格列模型类，重写addColumn方法
	public void addColumn(TableColumn tc){
		super.addColumn(tc);//调用父类方法
		int newIndex=this.sorted(tc);//获得比指定列标题大的列的索引
		if(newIndex!=tc.getModelIndex()){//如果不是当前列的索引
			//调用moveColumn方法将当前列及其列标题移动到获得的新列索引出
			this.moveColumn(tc.getModelIndex(), newIndex);
		}
	}
	
	public int sorted(TableColumn tc){//自定义比较列标题大小的方法
		int count=this.getColumnCount();//获取列的总数
		String name=tc.getHeaderValue().toString();//获取当前列的列标题字符串
		for(int i=0;i<count;i++){//依次将当前列标题与其他列标题比较大小
			if(name.compareTo(this.getColumn(i).getHeaderValue().toString())<=0){
				return i;//当扫描到的列标题比指定列的标题大，就返回扫描到的列索引
			}
		}
		return count;//返回表格中最大的列索引值+1
	}
}
