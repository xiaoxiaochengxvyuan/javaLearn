package ch01;
/*
 * �������������֮���������һ�ֻ��ɵ��㷨��
 * ������֤��������������������ߴ��ϵ��㷨��
 * ���㷨����ƿ���ν�൱���䡣
 * ���ȣ�����һ��forѭ�������������֮�͵�ͬʱ �������жϲ�����
 * ��Ȼһ��ʼ�������뷨�����ǣ��Ǻ����뵽���ֲ����ġ�
 * ����֮�е�Ԫ���ڼ���֮�󣬽��и�max��ֵ��ֻҪ��maxС���Ͳ��ø���max��
 * ���� ���ǰ�漸��Ԫ��֮��<0�ˣ� ֱ������sumֵ����������ǰ�漸��Ԫ���ˡ�
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
