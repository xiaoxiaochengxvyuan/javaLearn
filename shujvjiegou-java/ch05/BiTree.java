package ch05;

import ch03.LinkQueue;
import ch03.LinkStack;

public class BiTree {
	private BiTreeNode root;				//树的根结点
	private int index = 0;
	public BiTree(){						//构造一颗空树
		this.root =null;
	}
	public BiTree(BiTreeNode root){				//构造一棵树
		this.root = root;
	}
	//由先根遍历建立一棵二叉树
	public BiTree(String preStr){
		char c = preStr.charAt(index++);
		if(c != '#'){
			root = new BiTreeNode(c);
			root.lchild = new BiTree(preStr).root;			//建立左子树
			root.rchild = new BiTree(preStr).root;				//建立右子树
		}else
			root =null;
	}
	//由先根遍历和中根遍历序列创建一棵二叉树的算法
	public BiTree(String preOrder,String inOrder,int preIndex,int inIndex,int count){
		if(count >0){
			char r =preOrder.charAt(preIndex);//取先根遍历序列中的第一个结点
			int i =0;
			for(;i<count;i++)
				if(r == inOrder.charAt(i+inIndex))
					break;
			root =new BiTreeNode(r);
			root.lchild = new BiTree(preOrder,inOrder,preIndex +1,inIndex,i).root;
			root.rchild = new BiTree(preOrder,inOrder,preIndex +i +1, inIndex +i +1,count -i-1).root;
		}
	}

	//先根遍历二叉树的递归算法
	public void preRootTraverse(BiTreeNode T){
		if(T !=null){
			System.out.println(T.data);
			preRootTraverse(T.lchild);
			preRootTraverse(T.rchild);
		}
	}
	//先根遍历二叉树的非递归算法
	public void preRootTraverse() throws Exception{
		BiTreeNode T = root;
		if (T!=null){
			LinkStack S = new LinkStack();					//构造栈
			S.push(T);										//根结点入栈
			while(!S.isEmpty()){
				T = (BiTreeNode)S.pop();				//移除栈顶结点，并返回其值
				System.out.println(T.data);				//访问结点
				while(T!=null){
					if(T.lchild != null)				//访问左孩子
						System.out.println(T.lchild.data);	//访问结点
					if(T.rchild != null)					//右孩子非空入栈
						S.push(T.rchild);
					T = T.lchild;
				}
			}
		}
	}
	//中根遍历二叉树的递归算法
	public void inRootTraverse(BiTreeNode T){
		if(T != null){
			inRootTraverse(T.lchild);
			System.out.println(T.data);
			inRootTraverse(T.rchild);
		}
	}
	//中根遍历二叉树的非递归算法
	public void inRootTraverse() throws Exception{
		BiTreeNode T = root;				
		if(T != null){
			LinkStack S = new LinkStack();				//构造链栈
			S.push(T);   						//根结点入栈
			while(!S.isEmpty()){
				while(S.peek() != null)				//将栈顶结点的左孩子结点相继入栈
					S.push(((BiTreeNode)S.peek()).lchild);
				S.pop();				//空左孩子 出栈
				if(!S.isEmpty()){				
					T =(BiTreeNode)S.pop();				//移除栈顶结点，返回其值
					System.out.print(T.data);
					S.push(T.rchild);						//结点的右孩子入栈
				}
			}
		}
	}
	//后根遍历二叉树的递归算法
	public void postRootTraverse(BiTreeNode T){
		if(T!=null){
			postRootTraverse(T.lchild);
			postRootTraverse(T.rchild);
			System.out.println(T.data);
		}
	}
	//后根遍历二叉树的非递归算法
	public void postRootTraverse() throws Exception{
		BiTreeNode T = root;
		if(T != null){
			LinkStack S =new LinkStack();
			S.push(T);
			Boolean flag;
			BiTreeNode p = null;
			while(!S.isEmpty()){
				while(S.peek()!= null)
					S.push(((BiTreeNode)S.peek()).lchild);
				S.pop();
				while(!S.isEmpty()){
					T =(BiTreeNode)S.peek();
					if(T.rchild ==null ||T.rchild ==p){
						System.out.print(T.data);
						S.pop();
						p = T;
						flag =true;
					}else{
						S.push(T.rchild);
						flag=false;
					}
					if(!flag)
						break;
				}
			}
		}
	}
	//层次遍历二叉树的算法（自左向右）
	public void levelTraverse() throws Exception{
		BiTreeNode T= root;
		if(T!=null){
			LinkQueue L =new LinkQueue();
			L.offer(T);
			while(!L.isEmpty()){
				T =(BiTreeNode)L.poll();
				System.out.println(T.data);
				if(T.lchild != null)
					L.offer(T.lchild);
				if(T.rchild != null)
					L.offer(T.rchild);
			}
		}
	}
	public BiTreeNode getRoot(){
		return root;
	}
	public void setRoot(BiTreeNode root){
		this.root = root;
	}
}
