package ch01;
/*
 * ���������������͵Ľӿڱ�ʾ
 */
public interface IComplex {
	public double getReal();		//ȡʵ��
	public void setReal(double real);	//�޸�ʵ��
	public double getImag();			//ȡ�鲿
	public void setImag(double imag);	//�޸��鲿
	public void add(IComplex Z);		//�������������
}
