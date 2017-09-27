package ch02;
/*
 * 结点类的描述
 */
public class Node {
	public Object data;			//存放结点值
	public Node next;			//后继节点的引用

//无参构造方法
public Node(){
	this(null,null);		//初始化空的结点
}
//带一个参数时的构造方法
public Node(Object data){
	this(data,null);
}
//带俩个参数时的构造方法
public Node(Object data,Node next){
	this.data =data;
	this.next =next;
}
}