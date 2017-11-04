package ch03;

public interface IStack {
	public void clear();								//将存在的栈置空
	public boolean isEmpty();							//判断是否为空，若空 true，否则 false
	public int length();							//返回栈中数据元素的个数
	public Object peek();							//读取栈顶元素并返回其值，若为空，返回null
	public void push(Object x)throws Exception;	//将数据元素x压入栈顶
	public Object pop();						//删除并返回栈顶元素
}
