package ch03;

import ch02.SqList;

/*
 * 1-n个自然数排列成环形，使得相邻俩数之和为素数。
 * 先引入顺序表Sqlist和链队列类LinkQueue，再创建一个Sqlist的对象L作为顺序表，用于存放素数环的数据元素，
 * 创建LinkQueue的对象Q，作为队列用于存放还未加入到素数环中的自然数。
 * 初始化L和Q，将1加入顺序表L，将2-n的自然数全部加入Q
 * 将出队的队首元素P与素数环最后一个数据元素q相加，若俩数之和为素数，并且p不是队列中的最后一个数据元素。
 * 则将p加入素数环，否则，提示p暂时无法处理，必须再次入队等待，再重复此过程。若p为队尾元素，
 * 还需要判断是否与素数环第一个数据元素相加是否等于素数，若是，则加入，求解结束，若不是，重复，直到队列为空
 * 或者已对队列中每一个数据元素都遍历了一次并且未能加入到素数环为止。
 */
public class Example3_5 {
	//判断正整数是否为素数
	public boolean isPrime(int num){
		if(num ==1 )
			return false;
		Double n = Math.sqrt(num);			//求平方根
		for(int i =2;i<=n.intValue();i++)
			if(num%i ==0)					//模为0返回false
				return false;
			return true;
	}
	//求n个正整数的素数环，并以顺序表返回
	public SqList makePrimeRing(int n) throws Exception{
		if(n%2 != 0)							//n为奇数则素数环不存在
			throw new Exception("素数环不存在");
			SqList L = new SqList(n);					//构造一个素数表
			L.insert(0, 1);								//初始化顺序表的首结点为1
			LinkQueue Q = new LinkQueue();					//构造一个链队列
			for(int i =2;i<=n;i++)
				Q.offer(i); 								//初始化链队列
			return insertRing(L,Q,2,n); 						//返回素数环
			}
	//在一个顺序表中插入第m个数，使其与顺序表中第M-1个数的和为素数，若m等于n，则还要满足
	//第m个数与1的和也为素数，程序返回顺序表
	private SqList insertRing(SqList L, LinkQueue Q, int m, int n)
	throws NumberFormatException,Exception{
		// TODO Auto-generated method stub
		int count =0;				//记录遍历队列中的数据元素的个数，防止再一次循环中重复遍历
		while(!Q.isEmpty() && count <= n-m){						//队列非空，且未重复遍历队列
			int p =(Integer) Q.poll();
			int q =(Integer) L.get(L.length()-1);				//取出顺序表中的最后一个数据元素
			if(m == n){												//为队列中最后一个元素
				if(isPrime(p+q)&&isPrime(p+1)){					//满足素数环的条件
					L.insert(L.length(), p);					//插入到顺序表尾
					return L;
					}
				else 										//不满足素数环条件
					Q.offer(p);
			}
			else if(isPrime(p+q)){					//未遍历到队列的最后一个数据元素，且满足素数环条件
				L.insert(L.length(), p);
				if(insertRing(L, Q, m+1, n)!=null)			//递归调用函数，若返回值不为空，成功找到素数环，返回
					return L;
				L.remove(L.length()-1);   			//移除顺序表表尾位置的数据元素
				Q.offer(p);
			}
			else 
				Q.offer(p);   					//加入队列尾部
			++count;
		}
		return null;
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Example3_5 r =new Example3_5();			//构造素数环对象
		SqList L = r.makePrimeRing(6);	//求素数环
		for(int i =0;i<L.length();i++)
			System.out.print(L.get(i)+" ");
	}

}
