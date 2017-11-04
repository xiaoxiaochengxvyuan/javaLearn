package ch05;

public class BiTreeNode {
	public Object data;
	public BiTreeNode lchild,rchild;
	public BiTreeNode(){
		
	}
	//构造一个左孩子，右孩子域为空的二叉树
	public BiTreeNode(Object data){
		this(data,null,null);
	}
	public BiTreeNode(Object data,BiTreeNode lchild,BiTreeNode rchild){
		this.data = data;
		this.lchild = lchild;
		this.rchild = rchild;
	}
}
