package ch03;

import ch02.Node;

public class PriorityQueue implements Iqueue{
	private Node front ;			//���׵�����
	private Node rear;				//��β������
	//���ȼ����еĹ��캯��
	public PriorityQueue(){
		front = rear = null;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		front =rear = null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return front == null;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		Node p =front ;			
		int length =0 ;				//���еĳ���
		while(p != null){			//һֱ���ҵ���β
			p = p.next;
			++length;
		}
		return length;
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		if(front == null)		//����Ϊ��
			return null;
		else 
			return front.data;
	}
	//���
	@Override
	public void offer(Object x) throws Exception {
		// TODO Auto-generated method stub
		PriorityQData pn = (PriorityQData) x;
		Node s = new Node(pn);					//����һ���½��
		if(front ==null)						//����Ϊ��
			front =rear = s;					//�޸Ķ��е���β���
		else{
			Node p = front ,q =front;
			while(p!=null&&pn.priority >= ((PriorityQData)p.data).priority){
						//�½ڵ��������ֵ����н���������ֵ��Ƚ�
				q = p;		
				p = p.next;
			}
			if(p == null){					//pΪ�գ���ʾ�������˶�β
				rear.next =s;					//���½ڵ���뵽��β
				rear =s;						//�޸Ķ�βָ��
			}
			else if(p == front){				//p�����ȼ����ڶ��׽������ȼ�
				s.next =front;							//���½����뵽����
				front =s;				//�޸Ķ��׽��
			}
			else{
				q.next =s;
				s.next =p;
			}
		}
	}

	@Override
	public Object poll() {
		// TODO Auto-generated method stub
		if(front ==null)			//����Ϊ��
			return null;
		else{
			Node p =front ;
			front =p.next;
			return p.data;
		}
	}
	public void display(){
		if(!isEmpty()){
			Node p = front;
			while (p!=rear.next){
				PriorityQData q =(PriorityQData)p.data;
				System.out.println(q.elem + " " +q.priority);
				p = p.next;
			}
		}else {
			System.out.println("�˶���Ϊ��");
		}
	}
}
