package ch05;
/*
 * �ɱ������������ȸ��������н���һ�Ŷ�����
 */
public class Example5_6 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		String preStr ="AB##CD###";
		BiTree T = new BiTree(preStr);
		System.out.println("�ȸ�����:");
		T.preRootTraverse();
		System.out.println();
		System.out.println("�и�����");
		T.inRootTraverse();
		System.out.println();
		System.out.println("�������");
		T.postRootTraverse();
		System.out.println();
	}

}
