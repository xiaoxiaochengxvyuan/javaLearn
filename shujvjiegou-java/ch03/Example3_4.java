package ch03;
/*
 * 汉诺塔问题求解
 */
public class Example3_4 {
	private int c =0;				//全局变量，对搬动计数
	//将塔座x上将直径由小到大自上而下的编号为1至n的n个圆盘按规则移动到塔座z上，y用作辅助塔座
	public void hanoi(int n,char x,char y,char z){
		if( n ==1){
			move(x,1,z);				//将编号为1的圆盘从x移到z
		}else{
			hanoi(n-1,x,z,y);			//将x上编号为1至n-1的圆盘移动到y,z作辅助塔
			move(x,n,z);				//将编号为n的圆盘从x移到z
			hanoi(n-1,y,x,z);			//将y上编号为1至n-1的圆盘移到z，x作辅助塔座
		}
	}
	//移动操作，将编号n的圆盘移到z
	public void move(char x,int n,char z){
		System.out.println("第"+ ++c +"次移动:"+n+"号圆盘"+x+"--->"+z);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Example3_4 h=new Example3_4();
		h.hanoi(4, 'x', 'y', 'z');
	}

}
