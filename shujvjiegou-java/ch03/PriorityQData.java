package ch03;
/*
 * ���ȼ�����  ͨ������ʽ�洢�ṹʵ�֡�
 * ����Ԫ�ص����ȼ���ĸߵ������������Ĵ�С��������������ԽС�����ȼ����Խ�ߡ�
 */
public class PriorityQData {
	public Object elem;				//��������Ԫ��ֵ
	public int priority;				//����������
	public PriorityQData(Object elem,int priority){
		this.elem = elem;
		this.priority = priority;
	}
}
