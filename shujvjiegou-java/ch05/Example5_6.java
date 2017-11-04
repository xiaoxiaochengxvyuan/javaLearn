package ch05;
/*
 * 由标明空子树的先根便利序列建立一颗二叉树
 */
public class Example5_6 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		String preStr ="AB##CD###";
		BiTree T = new BiTree(preStr);
		System.out.println("先根遍历:");
		T.preRootTraverse();
		System.out.println();
		System.out.println("中根遍历");
		T.inRootTraverse();
		System.out.println();
		System.out.println("后根遍历");
		T.postRootTraverse();
		System.out.println();
	}

}
