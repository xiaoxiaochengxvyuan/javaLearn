package ch02;

import java.util.Scanner;

public class Example2_2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int n=10;
		SqList L =new SqList(10);		//����һ������10���洢��Ԫ�Ĵ洢�ռ�Ŀ�˳���
		for(int i=0;i<n;i++){			//��0,1,2,3...n-1���β��뵽˳���ı�β
			L.insert(i, i);
		}
		System.out.println("������i��ֵ");
		int i=new Scanner(System.in).nextInt();
		if(0<i&&i<=n){
			System.out.println("��"+i+"��Ԫ�ص�ֵ��ֱ��ǰ����"+L.get(i-1));
		}else
			System.out.println("��"+i+"��Ԫ�ص�ֱ��ǰ��������");

	}

}
