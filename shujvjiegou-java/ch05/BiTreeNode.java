package ch05;

public class BiTreeNode {
	public Object data;
	public BiTreeNode lchild,rchild;
	public BiTreeNode(){
		
	}
	//����һ�����ӣ��Һ�����Ϊ�յĶ�����
	public BiTreeNode(Object data){
		this(data,null,null);
	}
	public BiTreeNode(Object data,BiTreeNode lchild,BiTreeNode rchild){
		this.data = data;
		this.lchild = lchild;
		this.rchild = rchild;
	}
}
