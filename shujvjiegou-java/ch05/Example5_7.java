package ch05;
/*
 * ���ݶ�������˳��洢�ṹ����һ�ö���������ʽ�洢�ṹ
 * ����ö��������и��������к����
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
		System.out.println("�и�������");
		T.inRootTraverse();
		System.out.println();
		search e3 = new search();
		System.out.println("�������Ϊ ��" + e3.getDepth(root));
	}

}
