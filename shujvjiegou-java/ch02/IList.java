package ch02;
/*
 * 定义对顺序表操作的接口。接下来是实现这个接口并完成对顺序表的操作。
 * 某种程度上说，数组是顺序表的代码实现方式。
 */

public interface IList {
	public void clear();
	public boolean isEmpty();
	public int length();
	public Object get(int i) throws Exception;
	public void insert(int i,Object x) throws Exception;
	public void remove(int i) throws Exception;
	public int indexOf(Object x);
	public void display();
}
