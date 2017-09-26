package ch01;
/*
 * 这是最大子序列之和问题的另一种怀疑的算法。
 * 经过验证，发现这是求子序列最高大上的算法。
 * 此算法的设计可所谓相当经典。
 * 首先，利用一个for循环，在求出序列之和的同时 ，进行判断操作。
 * 虽然一开始有这种想法，但是，是很难想到这种操作的。
 * 序列之中的元素在加了之后，进行给max赋值，只要比max小，就不用更新max，
 * 并且 如果前面几个元素之后都<0了， 直接重置sum值，可以抛弃前面几个元素了。
 * 
 */
public class zixvlie{
	public int maxSub_4(int[] sequence){
		int max=0;
		int sum=0;
		for(int i=0;i<sequence.length;i++){
			sum += sequence[i];
			if(sum>max){
				max =sum;
			}else if(sum<0){
				sum =0;
			}
		}
		return max;
	}
}
