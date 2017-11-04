package ch05;

import ch03.LinkQueue;

/*
 * �������ϵĲ����㷨
 * ͨ�������ĵݹ���ã�ʵ�ֶ����������Ĳ���
 */
public class search{
	public BiTreeNode searchNode(BiTreeNode T,Object x){
		if(T!=null){
			if(T.data.equals(x))
				return T;
			else {
				BiTreeNode lresult = searchNode(T.lchild,x);
				return lresult !=null?lresult:searchNode(T.rchild,x);
			}
		}
		return null;
	}
	//���������������㷨(���õݹ�ģ�ͷ�����
	public int countNode1(BiTreeNode T){
		if(T ==null)
			return 0;
		else
			return countNode1(T.lchild)+countNode1(T.rchild);
	}
	//���������������㷨���ǵݹ�ģ�ͣ�
	public int countNode(BiTreeNode T) throws Exception{
		int count =0;
		if(T!=null){
			LinkQueue L = new LinkQueue();
			L.offer(T);
			while(!L.isEmpty()){
				T =(BiTreeNode) L.poll();
				++count;
				if(T.lchild ==null)
					L.offer(T.lchild);
				if(T.rchild == null)
					L.offer(T.rchild);
			}
		}
		return count;
	}
	//���������ȵ��㷨
	public int getDepth(BiTreeNode T){
		if(T!=null){
			int lDepth =getDepth(T.lchild);
			int rDepth =getDepth(T.rchild);
			return 1 +(lDepth>rDepth?lDepth:rDepth);
		}
		return 0;
	}
	public int getDepth1(BiTreeNode T){
		if(T==null)
			return 0;
		else if(T.lchild == null && T.rchild ==null)
			return 1;
		else
			return 1 + (getDepth1(T.lchild)>getDepth1(T.rchild)?getDepth1(T.lchild):getDepth1(T.rchild));
	}
	//�ж����ö������Ƿ����
	public boolean isEqual(BiTreeNode T1,BiTreeNode T2){
		if(T1 == null && T2 ==null)
			return true;
		if(T1 !=null && T2 !=null)
			if(T1.data.equals(T2.data))
				if(isEqual(T1.lchild,T2.lchild))
					if(isEqual(T1.rchild,T2.rchild))
						return true;
		return false;
	}
	public boolean isEqual1(BiTreeNode T1,BiTreeNode T2){
		if(T1 ==null&&T2==null)
			return true;
		else if(T1 != null && T2!=null)
			return (T1.data.equals(T2.data))&&(isEqual1(T1.lchild,T2.lchild))&&(isEqual1(T1.rchild,T2.rchild));
		else
			return false;
	}
}
