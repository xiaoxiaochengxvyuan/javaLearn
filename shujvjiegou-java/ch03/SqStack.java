package ch03;
/*
 * ˳��ջ���ʵ��
 */
public class SqStack implements IStack{
	private Object[] stackElem;	//��������
	private int top;			//�ڷǿ�ջ�У�topʼ��ָ��ջ��Ԫ�ص���һ���洢λ�ã���ջΪ�գ�topֵΪ0.
	//ջ�Ĺ��캯��������һ���洢�ռ�����ΪmaxSize�Ŀ�ջ
	public SqStack(int maxSize){
		top =0;			//��ʼ��top��
		stackElem =new Object[maxSize];			//����maxSize�ռ����������
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		top=0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		
		return top == 0;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return top;
	}

	@Override
	//ȡջ��Ԫ��
	public Object peek() {
		// TODO Auto-generated method stub
		if(!isEmpty())
			return stackElem[top-1];
		else
			return null;
	}

	@Override
	//��ջ
	public void push(Object x) throws Exception {
		// TODO Auto-generated method stub
		if(top ==stackElem.length)
			throw new Exception("ջ������лл");
		else
			stackElem[top++]=x;
		//�������������������ֱֵ�Ӱ�top+1���޸�topָ��
	}

	@Override
	//��ջ
	public Object pop() {
		// TODO Auto-generated method stub
		if(isEmpty())
		return null;
		else
			return stackElem[--top];
	}
	public void display(){
		for(int i=top-1;i>=0;i--)
			System.out.println(stackElem[i].toString()+" ");	//���
	}

}
