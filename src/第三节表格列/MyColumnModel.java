package �����ڱ����;

import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

//�Զ���ı����ģ����MyColumnModel,�̳���DefaultTableColumnModel��
public class MyColumnModel extends DefaultTableColumnModel{
	//�̳�Ĭ�ϱ����ģ���࣬��дaddColumn����
	public void addColumn(TableColumn tc){
		super.addColumn(tc);//���ø��෽��
		int newIndex=this.sorted(tc);//��ñ�ָ���б������е�����
		if(newIndex!=tc.getModelIndex()){//������ǵ�ǰ�е�����
			//����moveColumn��������ǰ�м����б����ƶ�����õ�����������
			this.moveColumn(tc.getModelIndex(), newIndex);
		}
	}
	
	public int sorted(TableColumn tc){//�Զ���Ƚ��б����С�ķ���
		int count=this.getColumnCount();//��ȡ�е�����
		String name=tc.getHeaderValue().toString();//��ȡ��ǰ�е��б����ַ���
		for(int i=0;i<count;i++){//���ν���ǰ�б����������б���Ƚϴ�С
			if(name.compareTo(this.getColumn(i).getHeaderValue().toString())<=0){
				return i;//��ɨ�赽���б����ָ���еı���󣬾ͷ���ɨ�赽��������
			}
		}
		return count;//���ر��������������ֵ+1
	}
}
