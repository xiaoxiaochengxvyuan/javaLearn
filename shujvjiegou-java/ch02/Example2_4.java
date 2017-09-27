package ch02;

public class Example2_4 {

	public static void main(String[] args) throws Exception {
		LinkList l =new LinkList();
		for(int i=0;i<10;i++){
			l.insert(i, i);
		}
		l.insert(4, 8);
		l.insert(3, 5);
		System.out.println("删除重复结点前单链表：");
		l.display();
		removeRepeatElem(l);
		System.out.println("删除重复结点后单链表：");
		l.display();
	}
	public static void removeRepeatElem(LinkList L)throws Exception{
		Node p=L.head.next,q;			//初始化，p指向首结点
		while(p!=null){			//从首结点向后查找，直到p为空
			int order =L.indexOf(p.data);		//记录p在单链表中的位置
			q =p.next;
			while (q!=null){				//与p的所有后继结点进行比较
				if((p.data).equals(q.data))			//删除重复的节点
					L.remove(order);
				else
					++order;
				q=q.next;
			}
			p=p.next;
		}
	}
}
