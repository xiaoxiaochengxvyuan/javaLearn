package ch02;

public class SqList implements IList {
	private Object[] listElem;			//���Ա�洢�ռ�
	private int curLen;					//���Ա�ǰ����
	public SqList(int maxSize){			//˳�����Ĺ��캯��������һ���洢�ռ�����ΪmaxSize�����Ա�
		curLen = 0;						//��˳���ĵ�ǰ����Ϊ0
		listElem =new Object[maxSize];		//Ϊ˳������maxSize���洢��Ԫ
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		curLen = 0;				//��һ���Ѿ����ڵ����Ա��ÿ�Ϊ0��
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return curLen ==0;	//�ж����Ա��е�����Ԫ�صĸ����Ƿ�Ϊ0.��Ϊ0������TURE�����򷵻�FALSE
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return curLen;		//	����˳���ĵ�ǰ���ȡ�
	}

	@Override
	//��ȡ�����Ա��еĵ�i������Ԫ�ز��к�������ֵ������i��ȡֵ0<=i<=length()-1
	//��i���ڴ˷�Χ�����׳��쳣
	public Object get(int i) throws Exception{
		// TODO Auto-generated method stub
		if(i<0||i>curLen -1){				//i���С��0���ߴ��ڱ�-1 ���׳��쳣
			throw new Exception("��"+i+"��Ԫ�ز�����");
			
		}
		return listElem[i];
	}

	@Override
	public void insert(int i, Object x) throws Exception{	//�����Ա�ĵ�i��Ԫ��֮ǰ����һ��ֵΪx������Ԫ��
		// TODO Auto-generated method stub
		if(curLen == listElem.length)			//�ж�˳����Ƿ�����
			throw new Exception("˳�������");		//�׳��쳣
		if(i<0||i>curLen)
			throw new Exception("����λ�ò��Ϸ�");		//�׳��쳣��i���Ϸ�
		for(int j=curLen;j>i;j--){
			listElem[j] = listElem[j-1];	//����λ�ü���֮�����������Ԫ�������һλ
		}
			listElem[i] = x;							//����x
												
		
		curLen++;								//����һ
	
	}


	@Override
	public void remove(int i) throws Exception {				//ɾ�����������Ա��еĵ�i��Ԫ�ء�
		// TODO Auto-generated method stub
		if(i<0||i>curLen)
			throw new Exception("i���Ϸ�");
		for(int j =i;j<curLen -1;j++){
			listElem[j] =listElem[j+1];			//��ɾ��Ԫ��֮�����������Ԫ������һλ
		}
		curLen--;						//��-1
		
	}

	@Override
	public int indexOf(Object x) {				//�������Ա����״γ����ƶ�������Ԫ�ص�λ��ţ��������ڣ�����-1
		// TODO Auto-generated method stub
		int j =0;			//jָʾ˳����д��Ƚϵ�����Ԫ�أ����ʼֵָʾ˳����е�0��Ԫ��
		while (j<curLen&&!listElem[j].equals(x))		//���αȽ�
			j++;	
		if(j<curLen)									//�ж�j��λ���Ƿ�λ��˳�����
			return j;
		else										
			return -1;									//ֵΪx������Ԫ����˳����в�����
	}

	@Override
	public void display() {		//������Ա��е�����Ԫ��
		// TODO Auto-generated method stub
		for(int j=0;j<curLen;j++){
			System.out.print(listElem[j]+"  ");
			System.out.println();					//����
		}
	}

}
