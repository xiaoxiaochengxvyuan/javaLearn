package ch02;

public class Example2_1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub	
		SqList L= new SqList(10);		//����һ������10���洢��Ԫ�Ĵ洢�ռ�Ŀ�˳���
		L.insert(0, 'a');				//��ʼ��˳����е�ǰ�������Ԫ��
		L.insert(1, 'z');
		L.insert(2, 'd');
		L.insert(3, 'm');
		L.insert(4, 'z');
		int order = L.indexOf('z');			//��˳����в���ֵΪz������Ԫ��
		if(order !=-1)
			System.out.println("˳����е�һ�γ���ֵΪz������Ԫ��λ��Ϊ��"+order);
		else 
			System.out.println("�Ҳ�������z������Ԫ��");
	}

}
