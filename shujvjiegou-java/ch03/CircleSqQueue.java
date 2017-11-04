package ch03;
/*
 * ʵ��ѭ��˳����С��������������ֻҪ����С�ڱ�������
 * ��ôֵ����ڳ��������ܻ�������ѧ֪ʶ���Ҿ�Ȼ���˺ܾ�Ϊʲô��
 */

public class CircleSqQueue implements Iqueue{
	private Object[] queueElem;			//���д洢�ռ�
	private int front;					//�����в�Ϊ�գ�ָ�����Ԫ�ء�
	private int rear;					//�����в�Ϊ�գ�ָ���βԪ�ء�
	//ѭ��������Ĺ��캯��
	public CircleSqQueue(int maxSize){
		front =rear =0;								//���ף���β��ʼ��Ϊ0
		queueElem =new Object[maxSize];				//Ϊ���з���maxSize���洢��Ԫ
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		front = rear = 0;				//���е��ÿղ���
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return  front == rear ;				//�ж϶����Ƿ�Ϊ��
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return (rear - front +queueElem.length)%queueElem.length;
	}

	@Override
	//��ȡ����Ԫ��
	public Object peek() {
		// TODO Auto-generated method stub
		if(front == rear)
		return null;
		else
			return queueElem[front];
	}

	@Override
	public void offer(Object x) throws Exception {
		// TODO Auto-generated method stub
		if((rear +1)%queueElem.length ==front){			//�ж϶����Ƿ���
			throw new Exception("��������");
		}else{
			queueElem[rear] = x;		//x����rear��ָ������洢λ���У�ʹ���Ϊ�µĶ�βԪ�ء�
			rear = (rear+1)%queueElem.length;		//�޸Ķ�βָ��
		}
		
	}

	@Override
	public Object poll() {
		// TODO Auto-generated method stub
		if(front == rear)				//����Ϊ��
		return null;
		else{
			Object t =queueElem[front];				//����frontλ�õ�ֵ
			front = (front +1)%queueElem.length;
			return t;										//����ɾ����ֵ
		}
	}
	public void display(){
		if(!isEmpty()){
			for(int i = front;i!=rear;i=(i+1)%queueElem.length)
				System.out.print(queueElem[i].toString()  + "");
		}else{
			System.out.println("�˶���Ϊ��");
		}
	}
}
