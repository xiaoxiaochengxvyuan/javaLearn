package ttt;

public class IStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentDemo s =new StudentDemo();
		//s.age����s.name Ϊ��Ч�ġ�
		//ֻ��ͨ��get��������ȡStudentDemo���е����ԣ����߷�����
		//ֻ��ͨ��set�������޸����е����ԡ�
		s.setAge(13);
		s.setName("������");
		System.out.println("�����ǡ�����������������������"+s.getName());
		System.out.println("������-------------"+s.getAge());
	}

}
