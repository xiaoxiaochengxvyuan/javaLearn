package ch03;
/*
 * 队列接口。
 */
public interface Iqueue {
	public void clear();			//置空操作
	public boolean isEmpty();		//判空操作
	public int length();			//求队列长度
	public Object peek();			//读取队列首元素返回其值
	public void offer(Object x ) throws Exception;		//入队操作。
	public Object poll();							//删除队首元素返回其值，若为空，则返回Null
}
