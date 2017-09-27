package ch02;

import java.util.Scanner;

public class Example2_2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int n=10;
		SqList L =new SqList(10);		//构造一个含有10个存储单元的存储空间的空顺序表
		for(int i=0;i<n;i++){			//将0,1,2,3...n-1依次插入到顺序表的表尾
			L.insert(i, i);
		}
		System.out.println("请输入i的值");
		int i=new Scanner(System.in).nextInt();
		if(0<i&&i<=n){
			System.out.println("第"+i+"个元素的值的直接前驱是"+L.get(i-1));
		}else
			System.out.println("第"+i+"个元素的直接前驱不存在");

	}

}
