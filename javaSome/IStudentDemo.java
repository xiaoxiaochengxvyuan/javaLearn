package ttt;

public class IStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentDemo s =new StudentDemo();
		//s.age或者s.name 为无效的。
		//只能通过get方法来获取StudentDemo类中的属性，或者方法。
		//只能通过set方法来修改类中的属性。
		s.setAge(13);
		s.setName("略略略");
		System.out.println("姓名是————————————"+s.getName());
		System.out.println("年龄是-------------"+s.getAge());
	}

}
