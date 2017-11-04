package ch05;

import ch03.LinkQueue;
import ch03.LinkStack;

public class BiTree {
	private BiTreeNode root;				//���ĸ����
	private int index = 0;
	public BiTree(){						//����һ�ſ���
		this.root =null;
	}
	public BiTree(BiTreeNode root){				//����һ����
		this.root = root;
	}
	//���ȸ���������һ�ö�����
	public BiTree(String preStr){
		char c = preStr.charAt(index++);
		if(c != '#'){
			root = new BiTreeNode(c);
			root.lchild = new BiTree(preStr).root;			//����������
			root.rchild = new BiTree(preStr).root;				//����������
		}else
			root =null;
	}
	//���ȸ��������и��������д���һ�ö��������㷨
	public BiTree(String preOrder,String inOrder,int preIndex,int inIndex,int count){
		if(count >0){
			char r =preOrder.charAt(preIndex);//ȡ�ȸ����������еĵ�һ�����
			int i =0;
			for(;i<count;i++)
				if(r == inOrder.charAt(i+inIndex))
					break;
			root =new BiTreeNode(r);
			root.lchild = new BiTree(preOrder,inOrder,preIndex +1,inIndex,i).root;
			root.rchild = new BiTree(preOrder,inOrder,preIndex +i +1, inIndex +i +1,count -i-1).root;
		}
	}

	//�ȸ������������ĵݹ��㷨
	public void preRootTraverse(BiTreeNode T){
		if(T !=null){
			System.out.println(T.data);
			preRootTraverse(T.lchild);
			preRootTraverse(T.rchild);
		}
	}
	//�ȸ������������ķǵݹ��㷨
	public void preRootTraverse() throws Exception{
		BiTreeNode T = root;
		if (T!=null){
			LinkStack S = new LinkStack();					//����ջ
			S.push(T);										//�������ջ
			while(!S.isEmpty()){
				T = (BiTreeNode)S.pop();				//�Ƴ�ջ����㣬��������ֵ
				System.out.println(T.data);				//���ʽ��
				while(T!=null){
					if(T.lchild != null)				//��������
						System.out.println(T.lchild.data);	//���ʽ��
					if(T.rchild != null)					//�Һ��ӷǿ���ջ
						S.push(T.rchild);
					T = T.lchild;
				}
			}
		}
	}
	//�и������������ĵݹ��㷨
	public void inRootTraverse(BiTreeNode T){
		if(T != null){
			inRootTraverse(T.lchild);
			System.out.println(T.data);
			inRootTraverse(T.rchild);
		}
	}
	//�и������������ķǵݹ��㷨
	public void inRootTraverse() throws Exception{
		BiTreeNode T = root;				
		if(T != null){
			LinkStack S = new LinkStack();				//������ջ
			S.push(T);   						//�������ջ
			while(!S.isEmpty()){
				while(S.peek() != null)				//��ջ���������ӽ�������ջ
					S.push(((BiTreeNode)S.peek()).lchild);
				S.pop();				//������ ��ջ
				if(!S.isEmpty()){				
					T =(BiTreeNode)S.pop();				//�Ƴ�ջ����㣬������ֵ
					System.out.print(T.data);
					S.push(T.rchild);						//�����Һ�����ջ
				}
			}
		}
	}
	//��������������ĵݹ��㷨
	public void postRootTraverse(BiTreeNode T){
		if(T!=null){
			postRootTraverse(T.lchild);
			postRootTraverse(T.rchild);
			System.out.println(T.data);
		}
	}
	//��������������ķǵݹ��㷨
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
	//��α������������㷨���������ң�
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
