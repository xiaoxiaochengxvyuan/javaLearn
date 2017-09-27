package ch02;

public class Example2_1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub	
		SqList L= new SqList(10);		//构造一个含有10个存储单元的存储空间的空顺序表
		L.insert(0, 'a');				//初始化顺序表中的前五个数据元素
		L.insert(1, 'z');
		L.insert(2, 'd');
		L.insert(3, 'm');
		L.insert(4, 'z');
		int order = L.indexOf('z');			//在顺序表中查找值为z的数据元素
		if(order !=-1)
			System.out.println("顺序表中第一次出现值为z的数据元素位置为："+order);
		else 
			System.out.println("找不到包含z的数据元素");
	}

}
