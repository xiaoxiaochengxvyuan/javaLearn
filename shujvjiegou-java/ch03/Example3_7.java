package ch03;

import java.text.DecimalFormat;
import java.util.GregorianCalendar;
import java.util.Scanner;

/*
 * ģ��ͣ������������
 * ͣ������Ϊһ��ջ������ͣ������λ�ǹ̶��ģ�����ʹ��˳��ջ��ʵ�֡�
 * ���Ϊһ�����У����ڱ������Ŀ�ǲ��̶��ģ�����ʹ����������ʵ�֡�
 * Ϊ�˸���ģ��ͣ�����������Դ��ն˶��������������ȥ�����ݣ�ÿ������Ӧ����
 * 1.���ﻹ����ȥ��2.�������գ�3.�������ȥ��ʱ�̡�
 * ���˸о����������ʵ��̫����...
 */
public class Example3_7 {
	private SqStack S = new SqStack(100);					//˳��ջ���ͣ�����ڵĳ�����Ϣ
	private LinkQueue Q = new LinkQueue();					//�����д�ű���ϵĳ�����Ϣ
	private double fee =2;									//ÿ����ͣ������
	public final static int DEPARTURE=0;				//��ʾ�����뿪
	public final static  int ARRIVAL =1 ;   			//��ʶ��������
	//�ڲ������ڴ�ų�����Ϣ
	public class CarInfo{
		public int state;					//����״̬   �뿪���ǵ���
		public GregorianCalendar arrTime;			//��������ʱ��
		public GregorianCalendar depTime;				//�����뿪ʱ��
		public String license;					//���ƺ�
	}
	//ͣ������������license��ʾ���ƺ��룬action��ʾ�˳����Ķ��� ��������뿪
	public void parkingManag(String license, String action)throws Exception{
		if("arrive".equals(action)){				//��������
			CarInfo info =new CarInfo();				//����һ��������Ϣʵ��
			info.license =license;			//д�복�ƺ�
			if(S.length()<100){					//ͣ����δ��
				info.arrTime =(GregorianCalendar) GregorianCalendar.getInstance(); //��ǰʱ�� ��ʼ������ʱ��
				info.state = ARRIVAL;				//�޸�״̬��
				S.push(info);
				System.out.println(info.license +"ͣ����ͣ������" +S.length() +"��λ��");
			}
			else{
				Q.offer(info);  			//ͣ�������������������ȴ�ͣ��λ
				System.out.println(info.license+"ͣ���ڱ����" + Q.length()+"��λ��");
			}
		}
		else if("depart".equals(action)){				//�����뿪
			CarInfo info = null;
			int location = 0;	
			//����һ����ջ���ڴ�������뿪�����µ�����������ʱ�˳�����
			SqStack S2 =new SqStack(S.length());
			for(int i = S.length();i>0;i--){
				info =(CarInfo) S.pop();
						if(info.license.equals(license)){
							info.depTime =(GregorianCalendar)GregorianCalendar.getInstance();
							//��ǰʱ������ʼ���뿪ʱ��
							info.state = DEPARTURE;
							location=i;								//ȡ�ó���λ����Ϣ
							break;
						}
						else 							//����������ʱ�˳�����
							S2.push(info);
			}
			while(!S2.isEmpty())
				S.push(S2.pop());   			//�����������½���ͣ����
			if(location != 0){
				//����ͣ��ʱ�䣬�Ѻ��뻻�ɷ���
				double time =(info.depTime.getTimeInMillis()-info.arrTime.getTimeInMillis())/(1000*60);
				DecimalFormat df = new DecimalFormat("0.0");		//��double���и�ʽ����������λС��
				System.out.println(info.license+"ͣ�ţ�"+df.format(time)+"���ӣ�����Ϊ��"
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
			pm.parkingManag(String.valueOf(i), "arrive");			//��ʼ��12���������ƺ�Ϊ1..12����
		//10��ͣ�ڳ����ڣ�2��ͣ�ڱ����
		Scanner sc =new Scanner(System.in);
		System.out.println("�����복�ƺţ�");
		String license =sc.next();
		System.out.println("arrive or depart��");
		String action = sc.next();
		pm.parkingManag(license, action);    			//����ͣ����������
	}

}
