package ch03;
/*
 * 顺序栈表的实现
 */
public class SqStack implements IStack{
	private Object[] stackElem;	//对象数组
	private int top;			//在非空栈中，top始终指向栈顶元素的下一个存储位置，当栈为空，top值为0.
	//栈的构造函数，构造一个存储空间容量为maxSize的空栈
	public SqStack(int maxSize){
		top =0;			//初始化top；
		stackElem =new Object[maxSize];			//分配maxSize空间给对象数组
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		top=0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		
		return top == 0;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return top;
	}

	@Override
	//取栈顶元素
	public Object peek() {
		// TODO Auto-generated method stub
		if(!isEmpty())
			return stackElem[top-1];
		else
			return null;
	}

	@Override
	//入栈
	public void push(Object x) throws Exception {
		// TODO Auto-generated method stub
		if(top ==stackElem.length)
			throw new Exception("栈已满，谢谢");
		else
			stackElem[top++]=x;
		//这个设计真的厉害，赋了值直接把top+1，修改top指针
	}

	@Override
	//出栈
	public Object pop() {
		// TODO Auto-generated method stub
		if(isEmpty())
		return null;
		else
			return stackElem[--top];
	}
	public void display(){
		for(int i=top-1;i>=0;i--)
			System.out.println(stackElem[i].toString()+" ");	//输出
	}

}
