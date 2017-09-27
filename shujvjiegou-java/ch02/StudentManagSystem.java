package ch02;

import java.util.Scanner;

public class StudentManagSystem  extends SqList{
	public StudentManagSystem(int maxSize,int n)throws Exception{
		super(maxSize);
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<n;i++){
			StudentNode node = new StudentNode(sc);
			if(node != null){
				insert(node);
			}else
				i--;
		}
	}
	public StudentNode get(int number)throws Exception{
		for(int i=0;i<length();i++){
			StudentNode node=(StudentNode)super.get(i);
			if(node.number ==number)
				return node;
		}
		throw new Exception("ѧ��"+number+"������");	//	�׳��쳣
	}
	public void insert(StudentNode node) throws Exception{
		super.insert(this.length(), node);
	}
	public void remove(int number)throws Exception{
		for(int i=0;i<length();i++){
			StudentNode node =(StudentNode)super.get(i);
			if(node.number == number){
				super.remove(i);
				return;
			}
		}
		throw new Exception("ѧ��"+number+"������");
	}
	public void display(){
		for(int i=0;i<length();i++){
			try{
				StudentNode node=(StudentNode)super.get(i);
				displayNode(node);
			}catch(Exception e){}
		}
	}
	public void displayNode(StudentNode node){
		System.out.println("ѧ��"+node.number+"����"+node.name+"�Ա�"+node.sex+"��ѧӢ��"+node.english
				+"��ѧ"+node.math);
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int maxSize=100;
		Scanner sc =new Scanner(System.in);
		System.out.println("������ѧ������");
		int n =sc.nextInt();
		System.out.println("�밴ѧ�ţ��������Ա�Ӣ���ѧ������ѧ����Ϣ");
		StudentManagSystem l = new StudentManagSystem(maxSize,n);
		l.display();
		System.out.println("��������Ҫ��ѯ��ѧ����ѧ��");
		l.displayNode(l.get(sc.nextInt()));
		System.out.println("��������Ҫɾ����ѧ��");
		l.remove(sc.nextInt());
		System.out.println("ɾ���ɹ�");
		l.display();
		
		System.out.println("��������Ҫ����ѧ������Ϣ");
		l.insert(new StudentNode(sc));
		l.display();
	}

}
