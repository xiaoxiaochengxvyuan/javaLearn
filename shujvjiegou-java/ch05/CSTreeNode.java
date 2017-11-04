package ch05;

import ch03.LinkQueue;

/*
 * 孩子兄弟链表存储结构，一般对树的操作都是通过这个方式 转换成对二叉树的操作。
 */
public class CSTreeNode {
	public Object data;			//结点的数据域
	public CSTreeNode firstchid,nextbling;		//左孩子，右兄弟
	public CSTreeNode(){
		this(null);
	}
	public CSTreeNode(Object data){
		this(data,null,null);
	}
	public CSTreeNode(Object data,CSTreeNode firstchild,CSTreeNode nextbling){
		this.data=data;
		this.firstchid = firstchild;
		this.nextbling =nextbling;
	}
	public void preRootTraverse(CSTreeNode T){
		if(T!= null){
			System.out.println(T.data);
			preRootTraverse(T.firstchid);   			//先根遍历树中根节点的第一颗子树
			preRootTraverse(T.nextbling);		//先根遍历树中根节点的其他子树
		}
	}
	//树的后根遍历递归算法
	public void postRootTraverse(CSTreeNode T){
		if(T != null){
			postRootTraverse(T.firstchid);
			System.out.println(T.data);
			postRootTraverse(T.nextbling);
		}
	}
	//层次遍历
	public void levelTraverse(CSTreeNode T) throws Exception{
		if(T != null){
			LinkQueue L = new LinkQueue();
			L.offer(T);
			while(!L.isEmpty())
				for(T =(CSTreeNode)L.poll();T != null; T = T.nextbling){
					System.out.println(T.data +" ");
					if(T.firstchid !=null)
						L.offer(T.firstchid);
				}
		}
	}
	
}
