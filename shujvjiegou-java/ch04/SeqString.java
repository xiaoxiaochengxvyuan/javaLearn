package ch04;

import java.util.Arrays;

public class SeqString implements IString{
	private char[] strvalue;			//字符数组，存放串值
	private int curlen;					//当前串的长度
	public String toString(){
		return Arrays.toString(strvalue);
	}
	//构造方法1：构造一个空串
	public SeqString(){
		strvalue = new char[0];		
		curlen=0;
	}
	//构造方法2：以字符串常量构造串对象
	public SeqString(String str){
		char[] tempchararray =  str.toCharArray();
		strvalue =tempchararray;
		curlen = tempchararray.length;
	}
	//构造方法3：以字符串数组构造串对象
	public SeqString(char[] value){
		this.strvalue =new char[value.length];
		for(int i =0;i<value.length;i++){		//复制数组
			this.strvalue[i] = value[i];
		}
		curlen = value.length;
	}
	@Override
	//置空
	public void clear() {
		// TODO Auto-generated method stub
		this.curlen=0;
	}

	@Override
	//判空
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return curlen==0;
	}

	@Override
	//求长度
	public int length() {
		// TODO Auto-generated method stub
		return curlen;
	}

	@Override
	//截取字符
	public char charAt(int index) {
		// TODO Auto-generated method stub
		if((index<0)||(index>=curlen)){
			throw new StringIndexOutOfBoundsException(index);
		}
		return strvalue[index];
	}

	//扩充字符串存储空间容量，参数指定容量
	public void allocate(int newCapacity){
		char[ ] temp =strvalue;
		strvalue =new char[newCapacity];
		for(int i=0;i<temp.length;i++){
			strvalue[i] = temp[i];
		}
	}
	//返回串中序号从begin开始到end-1的子串
	public IString substring(int begin, int end) {
		// TODO Auto-generated method stub
		if(begin<0){
			throw new StringIndexOutOfBoundsException("起始位置不能小于0");
		}
		if(end>curlen){
			throw new StringIndexOutOfBoundsException("结束位置不能大于串的当前长度");
		}
		if(begin>end){
			throw new StringIndexOutOfBoundsException("开始位置不能大于结束位置");
		}
		if(begin == 0 && end == curlen){
			return this;
		}else{
			char[] buffer = new char[end - begin];
			for(int i=0;i<buffer.length;i++){					//复制子串
				buffer[i] = this.strvalue[i +begin];
			}
			return new SeqString(buffer);
		}
	}

	@Override
	//串的插入操作
	public IString insert(int offset, IString str) {
		// TODO Auto-generated method stub
		if((offset <0)||(offset>this.curlen)){
			throw new StringIndexOutOfBoundsException("插入位置不合法");
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
	//删除操作
	public IString delete(int begin, int end) {
		// TODO Auto-generated method stub
		if(begin<0){
			throw new StringIndexOutOfBoundsException("起始位置不能小于0");
		}
		if(end>curlen){
			throw new StringIndexOutOfBoundsException("结束位置不能大于串的当前长度");
		}
		if(begin >end){
			throw new StringIndexOutOfBoundsException("开始位置不能大于结束位置");
		}
		for(int i =0;i<curlen -end;i++){
			strvalue[begin +i] = strvalue[end+i];
		}
		curlen =curlen -(end - begin);					//当前串长度减去(end-begin)
		return this;
	}

	@Override
	//添加指定串str到当前串尾
	public IString concat(IString str) {
		// TODO Auto-generated method stub
		return insert(curlen,str);
	}

	@Override
	//串的比较操作
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
			int slen,tlen,i=begin,j=0;								//当主串比模式串长时进行比较
			slen = this.length();									//i表示主串中某个子串的序号
			tlen = str.length();
			while((i<slen)&&(j<tlen)){
				if(this.charAt(i)==str.charAt(j)){					//j为模式串当前字符的下标
					i++;
					j++;
				}else{
					i = i-j+1;										//继续比较后续字符
					j=0;											//继续比较主串中的下一个子串
				}													//模式串下标退回到0
			}
			if(j>=str.length())
				return i-tlen;										//匹配成功，返回子串序号
		}
		else{
			return -1;	
		}
		return -1;							//匹配失败返回-1
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
	//KMP算法
	public int index_KMP(IString T,int start){
		int[] next = getNext(T);			//计算模式串的next()值
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
