package ch03;

public interface IStack {
	public void clear();								//�����ڵ�ջ�ÿ�
	public boolean isEmpty();							//�ж��Ƿ�Ϊ�գ����� true������ false
	public int length();							//����ջ������Ԫ�صĸ���
	public Object peek();							//��ȡջ��Ԫ�ز�������ֵ����Ϊ�գ�����null
	public void push(Object x)throws Exception;	//������Ԫ��xѹ��ջ��
	public Object pop();						//ɾ��������ջ��Ԫ��
}
