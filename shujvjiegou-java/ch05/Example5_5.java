package ch05;
/*
 * ���ȸ����и��������н���һ�ö�����
 */
public class Example5_5 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String preOrder ="ABDEGCFH";
		String inOrder ="DBGEAFHC";
		BiTree T= new BiTree(preOrder,inOrder,0,0,preOrder.length());
		System.out.println("������� �� ");
		T.postRootTraverse();
	}

}
