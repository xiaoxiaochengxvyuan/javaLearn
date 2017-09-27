package ch02;

import java.util.Scanner;

public class LinkList implements IList{
	public Node head;		//单链表的头结点
	public LinkList(){
		head =new Node();		//初始化头结点
	}
	public LinkList(int n,boolean Order) throws Exception{		//构造一个长度为n的单链表
		this();					//初始化头节点
		if(Order){
			create1(n);
			}				//用尾插法顺序建立单链表
			else 
				create2(n);			//用头插法逆位序建立单链表	
		}
	//用尾插法顺序建立单链表，其中n为单链表的结点个数
	public void create1(int n) throws Exception{
		Scanner sc =new Scanner(System.in);				//构造用于输入的对象
		for(int j=0;j<n;j++){
			insert(length(),sc.next());						//逆序输入n个节点的数据域，生成新结点，插入到表头
		}
	}
	//用头插法逆位序建立单链表，其中n为单链表的结点个数
	public void create2(int n) throws Exception{
		Scanner sc =new Scanner(System.in);				//构造用于输入的对象
		for(int j=0;j<n;j++){
			insert(0,sc.next());						//逆序输入n个节点的数据域，生成新结点，插入到表头
		}
	}
	@Override
	//将一个已经存在的带头结点单链表置成空表
	public void clear() {
		// TODO Auto-generated method stub
		head.data=null;
		head.next=null;
	}

	@Override
	//判断带头结点的单链表是否为空
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return head.next ==null;
	}

	@Override
	//求带头结点的单链表的长度
	public int length() {
		// TODO Auto-generated method stub
		Node p = head.next;				//初始化，p指向首结点，length为计数器
		int length=0;
		while(p!=null){					//从首结点开始向后查找，直到p为空
			p =p.next;					//指向后继结点
			++length;					//长度加一
		}
		return length;
	}

	@Override
	//读取带头结点的单链表中的第i个结点
	public Object get(int i) throws Exception {
		// TODO Auto-generated method stub
		Node p=head.next;			//初始化，p指向首结点，j为计数器
		int j=0;
		while(p!=null&&j<i){		//从首结点开始向后查找，直到p指向第i个结点或者p为空
			p =p.next;				//指向后继结点
			++j;					//计数器的值+1
		}
		if(j>i||p==null){
			throw new Exception("第"+i+"个元素不存在");
		}
		return p.data;				//返回结点P的数据域值。
	}

	@Override
	//在带头结点的单链表中的第i个结点之前插入一个值为x的新结点。
	public void insert(int i, Object x) throws Exception {
		// TODO Auto-generated method stub
		Node p =head;				//初始化p为头结点，j为计数器
		int j=-1;
		while(p!=null&&j<i-1){		//寻找第i个结点的前驱
			p=p.next;
			++j;
		}
		if(j>i-1||p==null){
			throw new Exception("插入位置不合法");
			}
		Node s =new Node(x);		//生成新结点
		s.next =p.next;				//修改链，使新结点插入单链表中,先把p的指针给s，在修改p的指针为s。
										//操作顺序不能修改
		p.next =s;
	}

	@Override
	//删除带头结点的单链表中的第i个结点
	public void remove(int i) throws Exception {
		// TODO Auto-generated method stub
		Node p =head;
		int j=-1;
		while(p.next !=null&&j<i-1){			//寻找第i个结点的前驱
			p =p.next;
			++j;
		}
		if(j>i-1||p.next ==null){
			throw new Exception("删除位置不合法");
		}
		p.next =p.next.next;			//修改链指针，使待删除结点从单链表中脱离出来
		
	}

	@Override
	//在带头结点的单链表中查找值为x的结点,返回值是j，也就是值为x的结点所在位置。
	public int indexOf(Object x) {
		Node p =head.next;				//初始化，p指向首结点，j为计数器
		int j=0;						
		//下面从单链表中的首结点开始查找，直到p.data为x或者到达单链表的表尾
		while (p!=null&&p.data.equals(x)){
			p=p.next;
			++j;				//指向下一个结点，计数器加一
		}
		if(p!=null)
			return j;				//返回值为x的结点在单链表中的位置
		else 
			return -1;				//值为x的节点不在链表中，返回-1
	}

	@Override
	//输出单链表中的所有结点
	public void display() {
		// TODO Auto-generated method stub
		Node node =head.next;				//取出带头结点的单链表中的首结点
		while(node!=null){
			System.out.println(node.data+"");	//取出节点的值
			node =node.next;					//取下一个结点
		}
		System.out.println();					//换行
	}
}
