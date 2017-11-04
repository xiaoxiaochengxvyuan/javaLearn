package ch03;
/*
 * ��ŵ���������
 */
public class Example3_4 {
	private int c =0;				//ȫ�ֱ������԰ᶯ����
	//������x�Ͻ�ֱ����С�������϶��µı��Ϊ1��n��n��Բ�̰������ƶ�������z�ϣ�y������������
	public void hanoi(int n,char x,char y,char z){
		if( n ==1){
			move(x,1,z);				//�����Ϊ1��Բ�̴�x�Ƶ�z
		}else{
			hanoi(n-1,x,z,y);			//��x�ϱ��Ϊ1��n-1��Բ���ƶ���y,z��������
			move(x,n,z);				//�����Ϊn��Բ�̴�x�Ƶ�z
			hanoi(n-1,y,x,z);			//��y�ϱ��Ϊ1��n-1��Բ���Ƶ�z��x����������
		}
	}
	//�ƶ������������n��Բ���Ƶ�z
	public void move(char x,int n,char z){
		System.out.println("��"+ ++c +"���ƶ�:"+n+"��Բ��"+x+"--->"+z);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Example3_4 h=new Example3_4();
		h.hanoi(4, 'x', 'y', 'z');
	}

}
