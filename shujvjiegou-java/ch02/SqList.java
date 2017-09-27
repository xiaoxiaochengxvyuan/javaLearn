package ch02;

public class SqList implements IList {
	private Object[] listElem;			//线性表存储空间
	private int curLen;					//线性表当前长度
	public SqList(int maxSize){			//顺序表类的构造函数，构造一个存储空间容量为maxSize的线性表
		curLen = 0;						//置顺序表的当前长度为0
		listElem =new Object[maxSize];		//为顺序表分配maxSize个存储单元
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		curLen = 0;				//将一个已经存在的线性表置空为0。
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return curLen ==0;	//判断线性表中的数据元素的个数是否为0.若为0，返回TURE，否则返回FALSE
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return curLen;		//	返回顺序表的当前长度。
	}

	@Override
	//读取到线性表中的第i个数据元素并有函数返回值，其中i的取值0<=i<=length()-1
	//若i不在此范围，则抛出异常
	public Object get(int i) throws Exception{
		// TODO Auto-generated method stub
		if(i<0||i>curLen -1){				//i如果小于0或者大于表长-1 则抛出异常
			throw new Exception("第"+i+"个元素不存在");
			
		}
		return listElem[i];
	}

	@Override
	public void insert(int i, Object x) throws Exception{	//在线性表的第i个元素之前插入一个值为x的数据元素
		// TODO Auto-generated method stub
		if(curLen == listElem.length)			//判断顺序表是否已满
			throw new Exception("顺序表已满");		//抛出异常
		if(i<0||i>curLen)
			throw new Exception("插入位置不合法");		//抛出异常，i不合法
		for(int j=curLen;j>i;j--){
			listElem[j] = listElem[j-1];	//插入位置及其之后的所有数据元素向后移一位
		}
			listElem[i] = x;							//插入x
												
		
		curLen++;								//表长加一
	
	}


	@Override
	public void remove(int i) throws Exception {				//删除并返回线性表中的第i个元素。
		// TODO Auto-generated method stub
		if(i<0||i>curLen)
			throw new Exception("i不合法");
		for(int j =i;j<curLen -1;j++){
			listElem[j] =listElem[j+1];			//被删除元素之后的所有数据元素左移一位
		}
		curLen--;						//表长-1
		
	}

	@Override
	public int indexOf(Object x) {				//返回线性表中首次出现制定的数据元素的位序号，若不存在，返回-1
		// TODO Auto-generated method stub
		int j =0;			//j指示顺序表中待比较的数据元素，其初始值指示顺序表中第0个元素
		while (j<curLen&&!listElem[j].equals(x))		//依次比较
			j++;	
		if(j<curLen)									//判断j的位置是否位于顺序表中
			return j;
		else										
			return -1;									//值为x的数据元素在顺序表中不存在
	}

	@Override
	public void display() {		//输出线性表中的数据元素
		// TODO Auto-generated method stub
		for(int j=0;j<curLen;j++){
			System.out.print(listElem[j]+"  ");
			System.out.println();					//换行
		}
	}

}
