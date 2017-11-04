package ch05;
/*
 * 由先根和中根遍历序列建立一棵二叉树
 */
public class Example5_5 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String preOrder ="ABDEGCFH";
		String inOrder ="DBGEAFHC";
		BiTree T= new BiTree(preOrder,inOrder,0,0,preOrder.length());
		System.out.println("后根遍历 ： ");
		T.postRootTraverse();
	}

}
