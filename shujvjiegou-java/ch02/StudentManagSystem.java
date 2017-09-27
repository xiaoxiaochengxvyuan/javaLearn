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
		throw new Exception("学号"+number+"不存在");	//	抛出异常
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
		throw new Exception("学号"+number+"不存在");
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
		System.out.println("学号"+node.number+"姓名"+node.name+"性别"+node.sex+"大学英语"+node.english
				+"数学"+node.math);
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int maxSize=100;
		Scanner sc =new Scanner(System.in);
		System.out.println("请输入学生总数");
		int n =sc.nextInt();
		System.out.println("请按学号，姓名，性别，英语，数学来输入学生信息");
		StudentManagSystem l = new StudentManagSystem(maxSize,n);
		l.display();
		System.out.println("请输入需要查询的学生的学号");
		l.displayNode(l.get(sc.nextInt()));
		System.out.println("请输入需要删除的学号");
		l.remove(sc.nextInt());
		System.out.println("删除成功");
		l.display();
		
		System.out.println("请输入需要增加学生的信息");
		l.insert(new StudentNode(sc));
		l.display();
	}

}
