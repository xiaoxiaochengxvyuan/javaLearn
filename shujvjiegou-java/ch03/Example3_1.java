package ch03;

import java.util.Scanner;

/*
 * ����ջ�ж�java����� �ָ����Ƿ���ȷ
 */
public class Example3_1 {
	private final int LEFT=0;	//��¼��ָ���
	private final int RIGHT=1;		//��¼�ҷָ���
	private final int ORTHER=2;			//��¼�����ַ�
	public int verifyFlag(String str){			//�ж��ַ����ͣ����֣���������
		if("(".equals(str)||"[".equals(str)||"{".equals(str)
			||"/*".equals(str))			//��ָ���
			return LEFT;
		else if(")".equals(str)||"]".equals(str)||"}".equals(str)||"*/".equals(str))
			return RIGHT;			//�ҷָ���
		else
			return ORTHER;			//����
	}
	//������ָ���str1���ҷָ���str2�Ƿ�ƥ��
	public boolean matches(String str1,String str2){
		if(("(".equals(str1)&&")".equals(str2))
				||("[".equals(str1)&&"]".equals(str2))
				||(("{").equals(str1)&&"}".equals(str2))
				||(("/*").equals(str1)&&"*/".equals(str2)))
			return true;
		else
			return false;
	}
	private boolean ifLegal(String str) throws Exception{
		if(!"".equals(str)&&str!=null){
			SqStack S =new SqStack(20);			//�½��洢�ռ�Ϊ20��˳��ջ
			int length =str.length();			
			for(int i=0;i<length;i++){
				char c =str.charAt(i);		//ָ����������charֵ
				String t =String.valueOf(c);			//ת��Ϊ�ַ�����
				if(i!=length){
					if(('/' ==c&&'*'==str.charAt(i+1))
							||('*'==c&&'/'==str.charAt(i+1)))//�Ƿָ���/*��*/
						t=t.concat(String.valueOf(str.charAt(i+1)));
					++i;
				}
				if(LEFT ==verifyFlag(t)){		//Ϊ��ָ���
					S.push(t);					//ѹ��ջ
				}else if(RIGHT ==verifyFlag(t)){	//Ϊ�ҷָ���
					if(S.isEmpty()||!matches(S.pop().toString(),t)){
						throw new Exception("����JAVA�﷨���Ϸ�");		//�׳��쳣
				}
				}
			}
			if(!S.isEmpty())
				throw new Exception("����JAVA��䲻�Ϸ�");
			return true;
		}else
			throw new Exception("����java���Ϊ��");
		}
	public static void main(String arg[])throws Exception{
		Example3_1 e=new Example3_1();
		System.out.println("�������java���");
		@SuppressWarnings("resource")
		Scanner sc =new Scanner(System.in);
		if(e.ifLegal(sc.nextLine()))
			System.out.println("JAVA���Ϸ�");
		else
			System.out.println("����java��䲻�Ϸ�");
	}
}