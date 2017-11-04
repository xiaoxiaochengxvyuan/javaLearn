package ch05;
/*
 * 根据二叉树的顺序存储结构建立一棵二叉树的链式存储结构
 * 输出该二叉树的中根遍历序列和深度
 */
public class Example5_7 {
	public BiTreeNode createBiTree(String sqBiTree,int index){
		BiTreeNode root =null;
		if(index<sqBiTree.length()){
			root = new BiTreeNode(sqBiTree.charAt(index));
			root.lchild = createBiTree(sqBiTree,2*index +1);
			root.rchild =createBiTree(sqBiTree,2*index+2);
		}
		return root;
	}
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Example5_7 e =new Example5_7();
		String sqBiTree ="ABCDEFGH";
		BiTreeNode root = e.createBiTree(sqBiTree, 0);
		BiTree T = new BiTree(root);
		System.out.println("中根遍历：");
		T.inRootTraverse();
		System.out.println();
		search e3 = new search();
		System.out.println("树的深度为 ：" + e3.getDepth(root));
	}

}
