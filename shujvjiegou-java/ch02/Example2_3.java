package ch02;

import java.util.Scanner;

public class Example2_3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int n=10;
		LinkList  l = new LinkList();		//实例化对象 ，创建一个空的单链表
		for(int i=0;i<n;i++){					//将0.1.2.3.。。。一次插入表尾
			l.insert(i, i);
		}
		System.out.println("请输入i的值");
		int i=new Scanner(System.in).nextInt();		//给i赋值，值为键盘输入的int类型
		if(0<i&&i<=n){
			System.out.println("第"+i+"个元素的直接前驱是："+l.get(i-1));
		}
		else
			System.out.println("第"+i+"个元素的前驱不存在。");
	}

}
