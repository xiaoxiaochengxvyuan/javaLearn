package ch02;

import java.util.Scanner;

public class Example2_5 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		int m=0,n=0;
		System.out.println("������LA�н��ĸ���");
		m=sc.nextInt();
		System.out.println("�밴�ǵݼ��ķ�ʽ����"+m+"����");
		LinkList LA =new LinkList(m,true);
		System.out.println("������LB�н��ĸ���");
		n=sc.nextInt();
		System.out.println("�밴�ǵݼ��ķ�ʽ����"+n+"����");
		LinkList LB=new LinkList(n,true);
		System.out.println("��LA��LB�鲢���µ�����LA�ĸ���Ԫ�أ�");
		mergeList_L(LA,LB).display();
	}
	public static LinkList mergeList_L(LinkList LA,LinkList LB){
		Node pa =LA.head.next;
		Node pb = LB.head.next;
		Node pc =LA.head;
		int da,db;
		while(pa!=null&&pb!=null){
			da =Integer.valueOf(pa.data.toString());
			db =Integer.valueOf(pb.data.toString());
			if(da<=db){
				pc.next= pa;
				pc=pa;
				pa=pa.next;
			}else{
				pc.next =pb;
				pc =pb;
				pb =pb.next;
			}
		}
		pc.next=(pa !=null?pa:pb);
		
		return  LA;
	}

}
