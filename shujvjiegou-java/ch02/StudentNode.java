package ch02;

import java.util.Scanner;

public class StudentNode {
	public int number;
	public String name;
	public String sex;
	public double english;
	public double math;
	public StudentNode(){
		this(0,null,null,0.0,0.0);
	}
	public StudentNode(int number,String name,String sex,double english,double math){
		this.number=number;
		this.name=name;
		this.sex=sex;
		this.english=english;
		this.math=math;
	}
	public StudentNode(Scanner sc){
		this(sc.nextInt(),sc.next(),sc.next(),sc.nextDouble(),sc.nextDouble());
		System.out.println("学生信息如下："+number+"姓名"+name+"性别"+sex+"英语"+english+"数学："+math);
	}
}
