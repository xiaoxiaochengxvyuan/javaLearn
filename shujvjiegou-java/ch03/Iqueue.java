package ch03;
/*
 * ���нӿڡ�
 */
public interface Iqueue {
	public void clear();			//�ÿղ���
	public boolean isEmpty();		//�пղ���
	public int length();			//����г���
	public Object peek();			//��ȡ������Ԫ�ط�����ֵ
	public void offer(Object x ) throws Exception;		//��Ӳ�����
	public Object poll();							//ɾ������Ԫ�ط�����ֵ����Ϊ�գ��򷵻�Null
}
