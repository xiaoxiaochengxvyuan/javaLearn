package ch02;

import java.util.Scanner;

public class LinkList implements IList{
	public Node head;		//�������ͷ���
	public LinkList(){
		head =new Node();		//��ʼ��ͷ���
	}
	public LinkList(int n,boolean Order) throws Exception{		//����һ������Ϊn�ĵ�����
		this();					//��ʼ��ͷ�ڵ�
		if(Order){
			create1(n);
			}				//��β�巨˳����������
			else 
				create2(n);			//��ͷ�巨��λ����������	
		}
	//��β�巨˳��������������nΪ������Ľ�����
	public void create1(int n) throws Exception{
		Scanner sc =new Scanner(System.in);				//������������Ķ���
		for(int j=0;j<n;j++){
			insert(length(),sc.next());						//��������n���ڵ�������������½�㣬���뵽��ͷ
		}
	}
	//��ͷ�巨��λ��������������nΪ������Ľ�����
	public void create2(int n) throws Exception{
		Scanner sc =new Scanner(System.in);				//������������Ķ���
		for(int j=0;j<n;j++){
			insert(0,sc.next());						//��������n���ڵ�������������½�㣬���뵽��ͷ
		}
	}
	@Override
	//��һ���Ѿ����ڵĴ�ͷ��㵥�����óɿձ�
	public void clear() {
		// TODO Auto-generated method stub
		head.data=null;
		head.next=null;
	}

	@Override
	//�жϴ�ͷ���ĵ������Ƿ�Ϊ��
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return head.next ==null;
	}

	@Override
	//���ͷ���ĵ�����ĳ���
	public int length() {
		// TODO Auto-generated method stub
		Node p = head.next;				//��ʼ����pָ���׽�㣬lengthΪ������
		int length=0;
		while(p!=null){					//���׽�㿪ʼ�����ң�ֱ��pΪ��
			p =p.next;					//ָ���̽��
			++length;					//���ȼ�һ
		}
		return length;
	}

	@Override
	//��ȡ��ͷ���ĵ������еĵ�i�����
	public Object get(int i) throws Exception {
		// TODO Auto-generated method stub
		Node p=head.next;			//��ʼ����pָ���׽�㣬jΪ������
		int j=0;
		while(p!=null&&j<i){		//���׽�㿪ʼ�����ң�ֱ��pָ���i��������pΪ��
			p =p.next;				//ָ���̽��
			++j;					//��������ֵ+1
		}
		if(j>i||p==null){
			throw new Exception("��"+i+"��Ԫ�ز�����");
		}
		return p.data;				//���ؽ��P��������ֵ��
	}

	@Override
	//�ڴ�ͷ���ĵ������еĵ�i�����֮ǰ����һ��ֵΪx���½�㡣
	public void insert(int i, Object x) throws Exception {
		// TODO Auto-generated method stub
		Node p =head;				//��ʼ��pΪͷ��㣬jΪ������
		int j=-1;
		while(p!=null&&j<i-1){		//Ѱ�ҵ�i������ǰ��
			p=p.next;
			++j;
		}
		if(j>i-1||p==null){
			throw new Exception("����λ�ò��Ϸ�");
			}
		Node s =new Node(x);		//�����½��
		s.next =p.next;				//�޸�����ʹ�½����뵥������,�Ȱ�p��ָ���s�����޸�p��ָ��Ϊs��
										//����˳�����޸�
		p.next =s;
	}

	@Override
	//ɾ����ͷ���ĵ������еĵ�i�����
	public void remove(int i) throws Exception {
		// TODO Auto-generated method stub
		Node p =head;
		int j=-1;
		while(p.next !=null&&j<i-1){			//Ѱ�ҵ�i������ǰ��
			p =p.next;
			++j;
		}
		if(j>i-1||p.next ==null){
			throw new Exception("ɾ��λ�ò��Ϸ�");
		}
		p.next =p.next.next;			//�޸���ָ�룬ʹ��ɾ�����ӵ��������������
		
	}

	@Override
	//�ڴ�ͷ���ĵ������в���ֵΪx�Ľ��,����ֵ��j��Ҳ����ֵΪx�Ľ������λ�á�
	public int indexOf(Object x) {
		Node p =head.next;				//��ʼ����pָ���׽�㣬jΪ������
		int j=0;						
		//����ӵ������е��׽�㿪ʼ���ң�ֱ��p.dataΪx���ߵ��ﵥ����ı�β
		while (p!=null&&p.data.equals(x)){
			p=p.next;
			++j;				//ָ����һ����㣬��������һ
		}
		if(p!=null)
			return j;				//����ֵΪx�Ľ���ڵ������е�λ��
		else 
			return -1;				//ֵΪx�Ľڵ㲻�������У�����-1
	}

	@Override
	//����������е����н��
	public void display() {
		// TODO Auto-generated method stub
		Node node =head.next;				//ȡ����ͷ���ĵ������е��׽��
		while(node!=null){
			System.out.println(node.data+"");	//ȡ���ڵ��ֵ
			node =node.next;					//ȡ��һ�����
		}
		System.out.println();					//����
	}
}
