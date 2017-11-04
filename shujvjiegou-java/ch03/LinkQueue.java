package ch03;

import ch02.Node;

/*
 * 实现链队列
 */
public class LinkQueue implements Iqueue{
	private Node front;					//队首指针
	private Node rear;					//队尾指针
	//链队列类的构造函数				
	public LinkQueue(){
		front = rear = null;			//初始化指针
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
			p = p.next;				//指针下移
			++length;				//计数器加一
		}
		return length;
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		if(front!=null)
			return front.data;
		else
			return null;				//队列非空 返回首节点的数据域值
	}

	@Override
	public void offer(Object x) throws Exception {
		// TODO Auto-generated method stub
		Node p =new Node(x);			//初始化新结点
		if(front !=null){				//队列非空
			rear.next =p;
			rear =p;					//改变队尾的位置
		}
		else 
			front = rear = p;			
	}

	@Override
	//队列非空，出队
	public Object poll() {
		// TODO Auto-generated method stub
		if(front != null){						//队列非空
			Node p =front;					//p指向首结点
			front =front.next;				//首结点出列
			if(p==rear)						//被删除的是队尾结点时
				rear =null;					//修改队尾结点为空
			return p.data;					//输出被删除的结点的值
		}
		else
		return null;
	}

}
