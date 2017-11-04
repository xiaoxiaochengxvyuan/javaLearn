package ch03;

import ch02.Node;

/*
 * ʵ��������
 */
public class LinkQueue implements Iqueue{
	private Node front;					//����ָ��
	private Node rear;					//��βָ��
	//��������Ĺ��캯��				
	public LinkQueue(){
		front = rear = null;			//��ʼ��ָ��
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		front = rear =null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		
		return front == null;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		Node p =front;
		int length =0;
		while(p!=null){
			p = p.next;				//ָ������
			++length;				//��������һ
		}
		return length;
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		if(front!=null)
			return front.data;
		else
			return null;				//���зǿ� �����׽ڵ��������ֵ
	}

	@Override
	public void offer(Object x) throws Exception {
		// TODO Auto-generated method stub
		Node p =new Node(x);			//��ʼ���½��
		if(front !=null){				//���зǿ�
			rear.next =p;
			rear =p;					//�ı��β��λ��
		}
		else 
			front = rear = p;			
	}

	@Override
	//���зǿգ�����
	public Object poll() {
		// TODO Auto-generated method stub
		if(front != null){						//���зǿ�
			Node p =front;					//pָ���׽��
			front =front.next;				//�׽�����
			if(p==rear)						//��ɾ�����Ƕ�β���ʱ
				rear =null;					//�޸Ķ�β���Ϊ��
			return p.data;					//�����ɾ���Ľ���ֵ
		}
		else
		return null;
	}

}
