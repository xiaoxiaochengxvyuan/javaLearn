package ch03;

import java.text.DecimalFormat;
import java.util.GregorianCalendar;
import java.util.Scanner;

/*
 * 模拟停车场管理问题
 * 停车场内为一个栈，对于停车场车位是固定的，所以使用顺序栈来实现。
 * 便道为一个队列，由于便道的数目是不固定的，所以使用链队列来实现。
 * 为了更好模拟停车场管理，可以从终端读入汽车到达或离去的数据，每组数据应包括
 * 1.到达还是离去，2.汽车牌照，3.到达或离去的时刻。
 * 个人感觉这个程序其实不太合理...
 */
public class Example3_7 {
	private SqStack S = new SqStack(100);					//顺序栈存放停车场内的车辆信息
	private LinkQueue Q = new LinkQueue();					//链队列存放便道上的车辆信息
	private double fee =2;									//每分钟停车费用
	public final static int DEPARTURE=0;				//表示车辆离开
	public final static  int ARRIVAL =1 ;   			//标识车辆到达
	//内部类用于存放车辆信息
	public class CarInfo{
		public int state;					//车辆状态   离开还是到达
		public GregorianCalendar arrTime;			//车辆到达时间
		public GregorianCalendar depTime;				//车辆离开时间
		public String license;					//车牌号
	}
	//停车场管理，参数license表示车牌号码，action表示此车辆的动作 到达或者离开
	public void parkingManag(String license, String action)throws Exception{
		if("arrive".equals(action)){				//车辆到达
			CarInfo info =new CarInfo();				//构造一个车辆信息实例
			info.license =license;			//写入车牌号
			if(S.length()<100){					//停车场未满
				info.arrTime =(GregorianCalendar) GregorianCalendar.getInstance(); //当前时间 初始化到达时间
				info.state = ARRIVAL;				//修改状态。
				S.push(info);
				System.out.println(info.license +"停放在停车场第" +S.length() +"个位置");
			}
			else{
				Q.offer(info);  			//停车场已满，进入便道，等待停车位
				System.out.println(info.license+"停放在便道第" + Q.length()+"个位置");
			}
		}
		else if("depart".equals(action)){				//车辆离开
			CarInfo info = null;
			int location = 0;	
			//构造一个新栈用于存放因车辆离开而导致的其他车辆暂时退出车场
			SqStack S2 =new SqStack(S.length());
			for(int i = S.length();i>0;i--){
				info =(CarInfo) S.pop();
						if(info.license.equals(license)){
							info.depTime =(GregorianCalendar)GregorianCalendar.getInstance();
							//当前时间来初始化离开时间
							info.state = DEPARTURE;
							location=i;								//取得车辆位置信息
							break;
						}
						else 							//其他车辆暂时退出车场
							S2.push(info);
			}
			while(!S2.isEmpty())
				S.push(S2.pop());   			//其他车辆重新进入停车场
			if(location != 0){
				//计算停放时间，把毫秒换成分钟
				double time =(info.depTime.getTimeInMillis()-info.arrTime.getTimeInMillis())/(1000*60);
				DecimalFormat df = new DecimalFormat("0.0");		//对double进行格式化，保留俩位小数
				System.out.println(info.license+"停放："+df.format(time)+"分钟，费用为："
				+df.format(time *fee));
			}
			if(!Q.isEmpty()){
				info = (CarInfo)Q.poll();
				info.arrTime = (GregorianCalendar)GregorianCalendar.getInstance();
				info.state = ARRIVAL;
				S.push(info);
			}
		}
		
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Example3_7  pm = new Example3_7();
		for(int i=1;i<=12;i++)
			pm.parkingManag(String.valueOf(i), "arrive");			//初始化12辆车，车牌号为1..12其中
		//10辆停在车场内，2辆停在便道上
		Scanner sc =new Scanner(System.in);
		System.out.println("请输入车牌号：");
		String license =sc.next();
		System.out.println("arrive or depart？");
		String action = sc.next();
		pm.parkingManag(license, action);    			//调用停车场管理函数
	}

}
