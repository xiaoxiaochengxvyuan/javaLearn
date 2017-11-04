package ch03;

import ch02.Node;

public class PriorityQueue implements Iqueue{
	private Node front ;			//队首的引用
	private Node rear;				//队尾的引用
	//优先级队列的构造函数
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
		int length =0 ;				//队列的长度
		while(p != null){			//一直查找到队尾
			p = p.next;
			++length;
		}
		return length;
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		if(front == null)		//队列为空
			return null;
		else 
			return front.data;
	}
	//入队
	@Override
	public void offer(Object x) throws Exception {
		// TODO Auto-generated method stub
		PriorityQData pn = (PriorityQData) x;
		Node s = new Node(pn);					//构造一个新结点
		if(front ==null)						//队列为空
			front =rear = s;					//修改队列的首尾结点
		else{
			Node p = front ,q =front;
			while(p!=null&&pn.priority >= ((PriorityQData)p.data).priority){
						//新节点的数据域值与队列结点的数据域值相比较
				q = p;		
				p = p.next;
			}
			if(p == null){					//p为空，表示遍历到了队尾
				rear.next =s;					//将新节点加入到队尾
				rear =s;						//修改队尾指针
			}
			else if(p == front){				//p的优先级大于队首结点的优先级
				s.next =front;							//将新结点加入到队首
				front =s;				//修改队首结点
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
		if(front ==null)			//队列为空
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
			System.out.println("此队列为空");
		}
	}
}
