package ch04;

/*
 * 字符串测试程序，测试顺序串SeqString的新建，插入，删除，取子串操作
 * 解决完输出hascode问题，出现 s3无法插入的问题
 * 花了差不多30分钟重新检查了下代码，发现是字符串计数问题，
 * 查了下curlen，发现，有一个构造方法中没有添加curlen，导致出现s3无法插入问题。
 * 
 */
public class Example4_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] chararray ={'w','o','r','l','d'};
		SeqString s1= new SeqString();
		SeqString s2 = new SeqString("hello");
		SeqString s3 =new SeqString(chararray);
		System.out.println("串s1=" +s1+",s2="+s2+",s3="+s3);
		s1.insert(0, s2);
		System.out.println("串s1在第0个字符前插入s2后，s1="+s1);
		s1.insert(1, s3);
		System.out.println("串s1在第1个字符前插入s3后，s1="+s1);
		s1.delete(1, 4);
		System.out.println("串s2在删除第一到第三个字符后,s1="+s1);
		System.out.println("串s1中从第二到第五个字符组成的子串是："+s1.substring(2,6));
	}

}
