package ch04;

/*
 * �ַ������Գ��򣬲���˳��SeqString���½������룬ɾ����ȡ�Ӵ�����
 * ��������hascode���⣬���� s3�޷����������
 * ���˲��30�������¼�����´��룬�������ַ����������⣬
 * ������curlen�����֣���һ�����췽����û�����curlen�����³���s3�޷��������⡣
 * 
 */
public class Example4_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] chararray ={'w','o','r','l','d'};
		SeqString s1= new SeqString();
		SeqString s2 = new SeqString("hello");
		SeqString s3 =new SeqString(chararray);
		System.out.println("��s1=" +s1+",s2="+s2+",s3="+s3);
		s1.insert(0, s2);
		System.out.println("��s1�ڵ�0���ַ�ǰ����s2��s1="+s1);
		s1.insert(1, s3);
		System.out.println("��s1�ڵ�1���ַ�ǰ����s3��s1="+s1);
		s1.delete(1, 4);
		System.out.println("��s2��ɾ����һ���������ַ���,s1="+s1);
		System.out.println("��s1�дӵڶ���������ַ���ɵ��Ӵ��ǣ�"+s1.substring(2,6));
	}

}
