package ch02;

public class Example2_4 {

	public static void main(String[] args) throws Exception {
		LinkList l =new LinkList();
		for(int i=0;i<10;i++){
			l.insert(i, i);
		}
		l.insert(4, 8);
		l.insert(3, 5);
		System.out.println("ɾ���ظ����ǰ������");
		l.display();
		removeRepeatElem(l);
		System.out.println("ɾ���ظ���������");
		l.display();
	}
	public static void removeRepeatElem(LinkList L)throws Exception{
		Node p=L.head.next,q;			//��ʼ����pָ���׽��
		while(p!=null){			//���׽�������ң�ֱ��pΪ��
			int order =L.indexOf(p.data);		//��¼p�ڵ������е�λ��
			q =p.next;
			while (q!=null){				//��p�����к�̽����бȽ�
				if((p.data).equals(q.data))			//ɾ���ظ��Ľڵ�
					L.remove(order);
				else
					++order;
				q=q.next;
			}
			p=p.next;
		}
	}
}
