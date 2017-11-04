package ch03;
/*
 * 实现循环顺序队列。关于求余操作，只要除数小于被除数，
 * 那么值会等于除数。（很基本的数学知识，我竟然想了很久为什么）
 */

public class CircleSqQueue implements Iqueue{
	private Object[] queueElem;			//队列存储空间
	private int front;					//若队列不为空，指向队首元素。
	private int rear;					//若队列不为空，指向队尾元素。
	//循环队列类的构造函数
	public CircleSqQueue(int maxSize){
		front =rear =0;								//队首，队尾初始化为0
		queueElem =new Object[maxSize];				//为队列分配maxSize个存储单元
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		front = rear = 0;				//队列的置空操作
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return  front == rear ;				//判断队列是否为空
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return (rear - front +queueElem.length)%queueElem.length;
	}

	@Override
	//读取队首元素
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
		if((rear +1)%queueElem.length ==front){			//判断队列是否满
			throw new Exception("队列已满");
		}else{
			queueElem[rear] = x;		//x存入rear所指的数组存储位置中，使其成为新的队尾元素。
			rear = (rear+1)%queueElem.length;		//修改队尾指针
		}
		
	}

	@Override
	public Object poll() {
		// TODO Auto-generated method stub
		if(front == rear)				//队列为空
		return null;
		else{
			Object t =queueElem[front];				//保存front位置的值
			front = (front +1)%queueElem.length;
			return t;										//返回删除的值
		}
	}
	public void display(){
		if(!isEmpty()){
			for(int i = front;i!=rear;i=(i+1)%queueElem.length)
				System.out.print(queueElem[i].toString()  + "");
		}else{
			System.out.println("此队列为空");
		}
	}
}
