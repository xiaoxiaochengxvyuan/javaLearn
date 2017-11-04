package ch03;
/*
 * 链栈表的实现
 */
import ch02.Node;

public class LinkStack implements IStack{
	private Node top;				//栈顶元素的引用
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		top =null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return top == null;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		Node p =top;		//初始化，P指向栈顶元素，length为计数器
		int length =0;
		while(p!=null){
			p =p.next;
			length++;
		}
		return length;
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		if(!isEmpty())
			return top.data;	//返回栈顶元素的值
		else
		return null;
	}

	@Override
	public void push(Object x) throws Exception {
		// TODO Auto-generated method stub
		Node p =new Node(x);
		p.next=top;
		top=p;
	}

	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		if(isEmpty())
		return null;
		else{
			Node p=top;
			top =top.next;
			return p.data;
		}
	}
	public void display(){
		Node p = top;
		while(p!=null){
			System.out.println(p.data.toString()+" ");
			p =p.next;
		}
	}
}
