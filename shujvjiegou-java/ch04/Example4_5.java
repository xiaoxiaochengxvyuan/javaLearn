package ch04;
/*
 * 设计一个类，分别统计模式匹配的BF算法和KMP算法的比较次数
 */
public class Example4_5 {
	public int indexBFCount(SeqString s,SeqString t,int begin){
		int slen ,tlen,i =begin,j=0;
		int count =0;
		slen=s.length();
		tlen =t.length();
		while((i<slen)&&(j<tlen)){
			if(s.charAt(i) == t.charAt(j)){
				i++;
				j++;
			}else{
				i = i-j+1;
				j=0;
			}
			count++;
		}
		return count;
	}
	public int indexKMPCount(SeqString s,SeqString t,int begin){
		int[] next =getNext(t);
		int i =begin;
		int j =0;
		int count =0;
		while(i<s.length()&&j<t.length()){
			if(j==-1||s.charAt(i)==t.charAt(j)){
				i++;
				j++;
			}else if(j == 0)
				i++;
			else{
				j = next[j];
			}
			count++;
		}
		return count;
	}
	public int[] getNext(SeqString T){
		int[] next =new int[T.length()];
		int j=1;
		int k=0;
		next[0]=-1;
		next[1]=0;
		while(j<T.length() -1){
			if(T.charAt(j)==T.charAt(k)){
				next[j+1]=k+1;
				j++;
				k++;
			}else if(k==0){
				next[j+1]=0;
				j++;
			}else{
				k = next[k];
			}
		}
		return (next);
	}
	public static void main(String[] args){
		SeqString s1 = new SeqString("cdbbacc");
		SeqString t1 = new SeqString("abcd");
		Example4_5 c = new Example4_5();
		System.out.println("测试1：主串 S=" + s1+",模式串T="+t1);
		System.out.println("BF算法比较次数" + c.indexBFCount(s1, t1, 0));
		System.out.println("KMP算法比较次数 " + c.indexKMPCount(s1, t1, 0));
		
		SeqString s2 = new SeqString("aaaaaaaaaa");
		SeqString t2 =new SeqString("aaaab");
		System.out.println("测试1：主串 S=" + s2+",模式串T="+t2);
		System.out.println("BF算法比较次数" + c.indexBFCount(s2, t2, 0));
		System.out.println("KMP算法比较次数 " + c.indexKMPCount(s2, t2, 0));
		
	}
}
