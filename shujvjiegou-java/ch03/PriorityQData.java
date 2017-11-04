package ch03;
/*
 * 优先级队列  通常以链式存储结构实现。
 * 数据元素的优先级别的高低依据优先数的大小来鉴定，优先数越小，优先级别就越高。
 */
public class PriorityQData {
	public Object elem;				//结点的数据元素值
	public int priority;				//结点的优先数
	public PriorityQData(Object elem,int priority){
		this.elem = elem;
		this.priority = priority;
	}
}
