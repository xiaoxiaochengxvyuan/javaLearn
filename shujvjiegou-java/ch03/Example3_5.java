package ch03;

import ch02.SqList;

/*
 * 1-n����Ȼ�����гɻ��Σ�ʹ����������֮��Ϊ������
 * ������˳���Sqlist����������LinkQueue���ٴ���һ��Sqlist�Ķ���L��Ϊ˳������ڴ��������������Ԫ�أ�
 * ����LinkQueue�Ķ���Q����Ϊ�������ڴ�Ż�δ���뵽�������е���Ȼ����
 * ��ʼ��L��Q����1����˳���L����2-n����Ȼ��ȫ������Q
 * �����ӵĶ���Ԫ��P�����������һ������Ԫ��q��ӣ�������֮��Ϊ����������p���Ƕ����е����һ������Ԫ�ء�
 * ��p������������������ʾp��ʱ�޷����������ٴ���ӵȴ������ظ��˹��̡���pΪ��βԪ�أ�
 * ����Ҫ�ж��Ƿ�����������һ������Ԫ������Ƿ�������������ǣ�����룬�������������ǣ��ظ���ֱ������Ϊ��
 * �����ѶԶ�����ÿһ������Ԫ�ض�������һ�β���δ�ܼ��뵽������Ϊֹ��
 */
public class Example3_5 {
	//�ж��������Ƿ�Ϊ����
	public boolean isPrime(int num){
		if(num ==1 )
			return false;
		Double n = Math.sqrt(num);			//��ƽ����
		for(int i =2;i<=n.intValue();i++)
			if(num%i ==0)					//ģΪ0����false
				return false;
			return true;
	}
	//��n����������������������˳�����
	public SqList makePrimeRing(int n) throws Exception{
		if(n%2 != 0)							//nΪ������������������
			throw new Exception("������������");
			SqList L = new SqList(n);					//����һ��������
			L.insert(0, 1);								//��ʼ��˳�����׽��Ϊ1
			LinkQueue Q = new LinkQueue();					//����һ��������
			for(int i =2;i<=n;i++)
				Q.offer(i); 								//��ʼ��������
			return insertRing(L,Q,2,n); 						//����������
			}
	//��һ��˳����в����m������ʹ����˳����е�M-1�����ĺ�Ϊ��������m����n����Ҫ����
	//��m������1�ĺ�ҲΪ���������򷵻�˳���
	private SqList insertRing(SqList L, LinkQueue Q, int m, int n)
	throws NumberFormatException,Exception{
		// TODO Auto-generated method stub
		int count =0;				//��¼���������е�����Ԫ�صĸ�������ֹ��һ��ѭ�����ظ�����
		while(!Q.isEmpty() && count <= n-m){						//���зǿգ���δ�ظ���������
			int p =(Integer) Q.poll();
			int q =(Integer) L.get(L.length()-1);				//ȡ��˳����е����һ������Ԫ��
			if(m == n){												//Ϊ���������һ��Ԫ��
				if(isPrime(p+q)&&isPrime(p+1)){					//����������������
					L.insert(L.length(), p);					//���뵽˳���β
					return L;
					}
				else 										//����������������
					Q.offer(p);
			}
			else if(isPrime(p+q)){					//δ���������е����һ������Ԫ�أ�����������������
				L.insert(L.length(), p);
				if(insertRing(L, Q, m+1, n)!=null)			//�ݹ���ú�����������ֵ��Ϊ�գ��ɹ��ҵ�������������
					return L;
				L.remove(L.length()-1);   			//�Ƴ�˳����βλ�õ�����Ԫ��
				Q.offer(p);
			}
			else 
				Q.offer(p);   					//�������β��
			++count;
		}
		return null;
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Example3_5 r =new Example3_5();			//��������������
		SqList L = r.makePrimeRing(6);	//��������
		for(int i =0;i<L.length();i++)
			System.out.print(L.get(i)+" ");
	}

}
