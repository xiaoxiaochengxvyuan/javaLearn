package ch02;

import java.util.Scanner;

public class Example2_3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int n=10;
		LinkList  l = new LinkList();		//ʵ�������� ������һ���յĵ�����
		for(int i=0;i<n;i++){					//��0.1.2.3.������һ�β����β
			l.insert(i, i);
		}
		System.out.println("������i��ֵ");
		int i=new Scanner(System.in).nextInt();		//��i��ֵ��ֵΪ���������int����
		if(0<i&&i<=n){
			System.out.println("��"+i+"��Ԫ�ص�ֱ��ǰ���ǣ�"+l.get(i-1));
		}
		else
			System.out.println("��"+i+"��Ԫ�ص�ǰ�������ڡ�");
	}

}
