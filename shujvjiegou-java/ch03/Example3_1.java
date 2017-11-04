package ch03;

import java.util.Scanner;

/*
 * 用链栈判断java语句中 分隔符是否正确
 */
public class Example3_1 {
	private final int LEFT=0;	//记录左分隔符
	private final int RIGHT=1;		//记录右分隔符
	private final int ORTHER=2;			//记录其他字符
	public int verifyFlag(String str){			//判断字符类型，三种：左右其他
		if("(".equals(str)||"[".equals(str)||"{".equals(str)
			||"/*".equals(str))			//左分隔符
			return LEFT;
		else if(")".equals(str)||"]".equals(str)||"}".equals(str)||"*/".equals(str))
			return RIGHT;			//右分隔符
		else
			return ORTHER;			//其他
	}
	//检验左分隔符str1和右分隔符str2是否匹配
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
			SqStack S =new SqStack(20);			//新建存储空间为20的顺序栈
			int length =str.length();			
			for(int i=0;i<length;i++){
				char c =str.charAt(i);		//指定索引出的char值
				String t =String.valueOf(c);			//转换为字符类型
				if(i!=length){
					if(('/' ==c&&'*'==str.charAt(i+1))
							||('*'==c&&'/'==str.charAt(i+1)))//是分隔符/*或*/
						t=t.concat(String.valueOf(str.charAt(i+1)));
					++i;
				}
				if(LEFT ==verifyFlag(t)){		//为左分隔符
					S.push(t);					//压入栈
				}else if(RIGHT ==verifyFlag(t)){	//为右分隔符
					if(S.isEmpty()||!matches(S.pop().toString(),t)){
						throw new Exception("错误：JAVA语法不合法");		//抛出异常
				}
				}
			}
			if(!S.isEmpty())
				throw new Exception("错误：JAVA语句不合法");
			return true;
		}else
			throw new Exception("错误：java语句为空");
		}
	public static void main(String arg[])throws Exception{
		Example3_1 e=new Example3_1();
		System.out.println("请输入分java语句");
		@SuppressWarnings("resource")
		Scanner sc =new Scanner(System.in);
		if(e.ifLegal(sc.nextLine()))
			System.out.println("JAVA语句合法");
		else
			System.out.println("错误：java语句不合法");
	}
}