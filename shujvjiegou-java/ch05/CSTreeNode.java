package ch05;

import ch03.LinkQueue;

/*
 * �����ֵ�����洢�ṹ��һ������Ĳ�������ͨ�������ʽ ת���ɶԶ������Ĳ�����
 */
public class CSTreeNode {
	public Object data;			//����������
	public CSTreeNode firstchid,nextbling;		//���ӣ����ֵ�
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
			preRootTraverse(T.firstchid);   			//�ȸ��������и��ڵ�ĵ�һ������
			preRootTraverse(T.nextbling);		//�ȸ��������и��ڵ����������
		}
	}
	//���ĺ�������ݹ��㷨
	public void postRootTraverse(CSTreeNode T){
		if(T != null){
			postRootTraverse(T.firstchid);
			System.out.println(T.data);
			postRootTraverse(T.nextbling);
		}
	}
	//��α���
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
