package ch02;
/*
 * ����������
 */
public class Node {
	public Object data;			//��Ž��ֵ
	public Node next;			//��̽ڵ������

//�޲ι��췽��
public Node(){
	this(null,null);		//��ʼ���յĽ��
}
//��һ������ʱ�Ĺ��췽��
public Node(Object data){
	this(data,null);
}
//����������ʱ�Ĺ��췽��
public Node(Object data,Node next){
	this.data =data;
	this.next =next;
}
}