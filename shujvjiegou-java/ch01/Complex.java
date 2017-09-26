package ch01;

public class Complex implements IComplex{
	private double real;		//实部
	private double imag;		//虚部
	//构造一个实数
	public Complex(double real,double imag){
		this.imag = imag;
		this.real = real;
	}

	@Override
	public double getReal() {
		// TODO Auto-generated method stub
		return real;
	}

	@Override
	public void setReal(double real) {
		// TODO Auto-generated method stub
		this.real = real;
	}

	@Override
	public double getImag() {
		// TODO Auto-generated method stub
		return imag;
	}
	@Override
	public void setImag(double imag) {
		// TODO Auto-generated method stub
		this.imag = imag;
	}

	@Override
	public void add(IComplex Z) {
		// TODO Auto-generated method stub
		if(Z!=null){
			real += Z.getReal();
			imag += Z.getImag();
		}
	}
}
	
//求整型数组a中的最大值。
//public static int maxEle(int[] a){
//	int max =a[0];
//	for(int i=1;i<a.length;i++){
//		if(max<a[i]){
//			max =a[i];
//		}
//	}
//	return max;
//}



//public int[] reverse(int[] b){
//	int temp;
//	for(int i=0,j=b.length-1;i<j;i++,j--){
//		temp=b[i];
//		b[i]=b[j];
//		b[j]=temp;
//  }
//	return b;
//}

