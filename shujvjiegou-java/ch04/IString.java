package ch04;

public interface IString {
	public void clear();								//串的置空操作
	public boolean isEmpty();							//串的判空操作
	public int length();								//返回串中的字符个数
	public char charAt(int index);						//取字符操作
	public IString substring(int begin,int end);		//截取子串操作
	public IString insert(int offset,IString str);		//插入操作
	public IString delete(int begin,int end);			//删除操作
	public IString concat(IString str);					//串的连接操作
	public int comparaTo(SeqString str);					//串的比较操作
	public int indexOf(IString str,int begin);			//子串定位操作，str不能为空串
}
