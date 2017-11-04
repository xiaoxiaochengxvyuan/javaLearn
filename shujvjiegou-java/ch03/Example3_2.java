package ch03;
/*
 * 实现俩个大数的加法运算，把数字放入栈中解决 其中，进位标示其实就是决定要不要进位，如果进位，
 * 则在下一位相加的时候再加一。pop()是栈中的删除操作
 */

public class Example3_2 {
	public String add(String a,String b)throws Exception{
		LinkStack sum =new LinkStack();				//大数的和
		LinkStack sA =numSplit(a);				//加数字符以单个字符的形式放入栈中
		LinkStack sB =numSplit(b);				//被加数字符以单个字符的形式放入栈中
		int partialSum;							//对于俩个位的求和
		boolean isCarry =false;						//进位标示
		while(!sA.isEmpty() && !sB.isEmpty()){			//加数栈与被加数栈非空时
			partialSum =(Integer)sA.pop() +(Integer)sB.pop();	//在栈中去除加数与被加数中的该位
			if(isCarry){						//低位进位
				partialSum ++;						//加到此位上
				isCarry =false;					//再重置进位标示
			}
			if(partialSum >=10){				//需要进位
				partialSum -= 10;
				sum.push(partialSum);
				isCarry =true;		//标识进位
			}
			else {							//位和不需要进位
				sum.push(partialSum);			//和放入栈中
			}
		}
		LinkStack temp = !sA.isEmpty()?sA:sB;			//引用指向加数和被加数中的栈
		while(!temp.isEmpty()){
			if(isCarry){								//最后一次执行加法运算需要进位
				int t=(Integer)temp.pop();				//取出加数或被加数没有参加的位
				++t;									//进位加到此位
				if(t >=10){
					t -= 10;						//需要进位
					sum.push(t);
				}
				else{
					sum.push(t);
					isCarry =false;			//重置仅为标示
				}
			}
			else
					sum.push(temp.pop());			//最后一次加不需要进位，把加数或被加数中非空的值放入和中
		}
		if(isCarry){								//最高位需要进位
			sum.push(1);							//进位放入栈中
		}
		String str =new String();
		while(!sum.isEmpty())			//把栈中元素转换为字符串
			str =str.concat(sum.pop().toString());
		return str;
	}
	//字符串以单个字符的形式放入栈中，并去除字符串中空格，返回以单个字符为元素的栈
	public LinkStack numSplit(String str) throws Exception{
		LinkStack s = new LinkStack();
		for(int i=0;i<str.length();i++){
			char c= str.charAt(i);				//指定索引处的char值
			if(' ' ==c)
				continue;
			else if('0'<=c&&'9'>=c)
				s.push(Integer.valueOf(String.valueOf(c)));
			else
				throw new Exception("错误：输入了非数字型字符！");
		}
		return s;
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
			Example3_2 e = new Example3_2();
			System.out.println("俩个大数的和为"+e.add("18452543389943209752345473", "8123542678432986899344"));
	}

}
