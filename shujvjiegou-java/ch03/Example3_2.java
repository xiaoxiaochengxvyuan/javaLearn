package ch03;
/*
 * ʵ�����������ļӷ����㣬�����ַ���ջ�н�� ���У���λ��ʾ��ʵ���Ǿ���Ҫ��Ҫ��λ�������λ��
 * ������һλ��ӵ�ʱ���ټ�һ��pop()��ջ�е�ɾ������
 */

public class Example3_2 {
	public String add(String a,String b)throws Exception{
		LinkStack sum =new LinkStack();				//�����ĺ�
		LinkStack sA =numSplit(a);				//�����ַ��Ե����ַ�����ʽ����ջ��
		LinkStack sB =numSplit(b);				//�������ַ��Ե����ַ�����ʽ����ջ��
		int partialSum;							//��������λ�����
		boolean isCarry =false;						//��λ��ʾ
		while(!sA.isEmpty() && !sB.isEmpty()){			//����ջ�뱻����ջ�ǿ�ʱ
			partialSum =(Integer)sA.pop() +(Integer)sB.pop();	//��ջ��ȥ�������뱻�����еĸ�λ
			if(isCarry){						//��λ��λ
				partialSum ++;						//�ӵ���λ��
				isCarry =false;					//�����ý�λ��ʾ
			}
			if(partialSum >=10){				//��Ҫ��λ
				partialSum -= 10;
				sum.push(partialSum);
				isCarry =true;		//��ʶ��λ
			}
			else {							//λ�Ͳ���Ҫ��λ
				sum.push(partialSum);			//�ͷ���ջ��
			}
		}
		LinkStack temp = !sA.isEmpty()?sA:sB;			//����ָ������ͱ������е�ջ
		while(!temp.isEmpty()){
			if(isCarry){								//���һ��ִ�мӷ�������Ҫ��λ
				int t=(Integer)temp.pop();				//ȡ�������򱻼���û�вμӵ�λ
				++t;									//��λ�ӵ���λ
				if(t >=10){
					t -= 10;						//��Ҫ��λ
					sum.push(t);
				}
				else{
					sum.push(t);
					isCarry =false;			//���ý�Ϊ��ʾ
				}
			}
			else
					sum.push(temp.pop());			//���һ�μӲ���Ҫ��λ���Ѽ����򱻼����зǿյ�ֵ�������
		}
		if(isCarry){								//���λ��Ҫ��λ
			sum.push(1);							//��λ����ջ��
		}
		String str =new String();
		while(!sum.isEmpty())			//��ջ��Ԫ��ת��Ϊ�ַ���
			str =str.concat(sum.pop().toString());
		return str;
	}
	//�ַ����Ե����ַ�����ʽ����ջ�У���ȥ���ַ����пո񣬷����Ե����ַ�ΪԪ�ص�ջ
	public LinkStack numSplit(String str) throws Exception{
		LinkStack s = new LinkStack();
		for(int i=0;i<str.length();i++){
			char c= str.charAt(i);				//ָ����������charֵ
			if(' ' ==c)
				continue;
			else if('0'<=c&&'9'>=c)
				s.push(Integer.valueOf(String.valueOf(c)));
			else
				throw new Exception("���������˷��������ַ���");
		}
		return s;
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
			Example3_2 e = new Example3_2();
			System.out.println("���������ĺ�Ϊ"+e.add("18452543389943209752345473", "8123542678432986899344"));
	}

}
