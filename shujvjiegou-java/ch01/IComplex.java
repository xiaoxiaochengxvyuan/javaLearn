package ch01;
/*
 * 复数抽象数据类型的接口表示
 */
public interface IComplex {
	public double getReal();		//取实部
	public void setReal(double real);	//修改实部
	public double getImag();			//取虚部
	public void setImag(double imag);	//修改虚部
	public void add(IComplex Z);		//俩个复数的求和
}
