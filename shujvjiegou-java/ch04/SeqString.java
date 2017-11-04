package ch04;

import java.util.Arrays;

public class SeqString implements IString{
	private char[] strvalue;			//�ַ����飬��Ŵ�ֵ
	private int curlen;					//��ǰ���ĳ���
	public String toString(){
		return Arrays.toString(strvalue);
	}
	//���췽��1������һ���մ�
	public SeqString(){
		strvalue = new char[0];		
		curlen=0;
	}
	//���췽��2�����ַ����������촮����
	public SeqString(String str){
		char[] tempchararray =  str.toCharArray();
		strvalue =tempchararray;
		curlen = tempchararray.length;
	}
	//���췽��3�����ַ������鹹�촮����
	public SeqString(char[] value){
		this.strvalue =new char[value.length];
		for(int i =0;i<value.length;i++){		//��������
			this.strvalue[i] = value[i];
		}
		curlen = value.length;
	}
	@Override
	//�ÿ�
	public void clear() {
		// TODO Auto-generated method stub
		this.curlen=0;
	}

	@Override
	//�п�
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return curlen==0;
	}

	@Override
	//�󳤶�
	public int length() {
		// TODO Auto-generated method stub
		return curlen;
	}

	@Override
	//��ȡ�ַ�
	public char charAt(int index) {
		// TODO Auto-generated method stub
		if((index<0)||(index>=curlen)){
			throw new StringIndexOutOfBoundsException(index);
		}
		return strvalue[index];
	}

	//�����ַ����洢�ռ�����������ָ������
	public void allocate(int newCapacity){
		char[ ] temp =strvalue;
		strvalue =new char[newCapacity];
		for(int i=0;i<temp.length;i++){
			strvalue[i] = temp[i];
		}
	}
	//���ش�����Ŵ�begin��ʼ��end-1���Ӵ�
	public IString substring(int begin, int end) {
		// TODO Auto-generated method stub
		if(begin<0){
			throw new StringIndexOutOfBoundsException("��ʼλ�ò���С��0");
		}
		if(end>curlen){
			throw new StringIndexOutOfBoundsException("����λ�ò��ܴ��ڴ��ĵ�ǰ����");
		}
		if(begin>end){
			throw new StringIndexOutOfBoundsException("��ʼλ�ò��ܴ��ڽ���λ��");
		}
		if(begin == 0 && end == curlen){
			return this;
		}else{
			char[] buffer = new char[end - begin];
			for(int i=0;i<buffer.length;i++){					//�����Ӵ�
				buffer[i] = this.strvalue[i +begin];
			}
			return new SeqString(buffer);
		}
	}

	@Override
	//���Ĳ������
	public IString insert(int offset, IString str) {
		// TODO Auto-generated method stub
		if((offset <0)||(offset>this.curlen)){
			throw new StringIndexOutOfBoundsException("����λ�ò��Ϸ�");
		}
		int len =str.length();
		int newCount =this.curlen+len;
		if(newCount>strvalue.length){
			allocate(newCount);
		}
		for(int i=this.curlen-1;i>=offset;i--){
			strvalue[len+i]=strvalue[i];
		}
		for(int i=0;i<len;i++){
			strvalue[offset + i]=str.charAt(i);
		}
		
		this.curlen=newCount;
		return this;
	}

	@Override
	//ɾ������
	public IString delete(int begin, int end) {
		// TODO Auto-generated method stub
		if(begin<0){
			throw new StringIndexOutOfBoundsException("��ʼλ�ò���С��0");
		}
		if(end>curlen){
			throw new StringIndexOutOfBoundsException("����λ�ò��ܴ��ڴ��ĵ�ǰ����");
		}
		if(begin >end){
			throw new StringIndexOutOfBoundsException("��ʼλ�ò��ܴ��ڽ���λ��");
		}
		for(int i =0;i<curlen -end;i++){
			strvalue[begin +i] = strvalue[end+i];
		}
		curlen =curlen -(end - begin);					//��ǰ�����ȼ�ȥ(end-begin)
		return this;
	}

	@Override
	//���ָ����str����ǰ��β
	public IString concat(IString str) {
		// TODO Auto-generated method stub
		return insert(curlen,str);
	}

	@Override
	//���ıȽϲ���
	public int comparaTo(SeqString str) {
		// TODO Auto-generated method stub
		int len1 =curlen;
		int len2 = str.curlen;
		int n =Math.min(len1, len2);
		char[] s1=strvalue;
		char[] s2 = str.strvalue;
		int k=0;
		while(k<n){
			char ch1 = s1[k];
			char ch2 = s2[k];
			if(ch1 != ch2){
				return ch1 -ch2;
			}
			k++;
		}
		return len1-len2;
	}

	@Override
	public int indexOf(IString str, int begin) {
		// TODO Auto-generated method stub
		if(this!=null&&str!=null&&str.length()>0&&this.length()>=str.length()){
			int slen,tlen,i=begin,j=0;								//��������ģʽ����ʱ���бȽ�
			slen = this.length();									//i��ʾ������ĳ���Ӵ������
			tlen = str.length();
			while((i<slen)&&(j<tlen)){
				if(this.charAt(i)==str.charAt(j)){					//jΪģʽ����ǰ�ַ����±�
					i++;
					j++;
				}else{
					i = i-j+1;										//�����ȽϺ����ַ�
					j=0;											//�����Ƚ������е���һ���Ӵ�
				}													//ģʽ���±��˻ص�0
			}
			if(j>=str.length())
				return i-tlen;										//ƥ��ɹ��������Ӵ����
		}
		else{
			return -1;	
		}
		return -1;							//ƥ��ʧ�ܷ���-1
}
	private int[] getNext(IString T){
		int[] next = new int[T.length()];
		int j=0;
		int k=-1;
		next[0]=-1;
		while(j<T.length()-1){
			if(k ==-1||T.charAt(j)== T.charAt(k)){
				j++;
				k++;
				if(T.charAt(j)!=T.charAt(k))
					next[j] =k;
				else
					next[j]=next[k];
			}else
				k = next[k];
		}
		return (next);
	}
	//KMP�㷨
	public int index_KMP(IString T,int start){
		int[] next = getNext(T);			//����ģʽ����next()ֵ
		int i=start;
		int j=0;
		while(i<this.length()&&j<T.length()){
			if(j == -1||this.charAt(i)==T.charAt(j)){
				i++;
				j++;
			}else{
				j = next[j];
			}
		}
		if(j<T.length()){
			return -1;
		}else{
			return(i-T.length());
		}
	}
}
