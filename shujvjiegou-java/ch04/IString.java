package ch04;

public interface IString {
	public void clear();								//�����ÿղ���
	public boolean isEmpty();							//�����пղ���
	public int length();								//���ش��е��ַ�����
	public char charAt(int index);						//ȡ�ַ�����
	public IString substring(int begin,int end);		//��ȡ�Ӵ�����
	public IString insert(int offset,IString str);		//�������
	public IString delete(int begin,int end);			//ɾ������
	public IString concat(IString str);					//�������Ӳ���
	public int comparaTo(SeqString str);					//���ıȽϲ���
	public int indexOf(IString str,int begin);			//�Ӵ���λ������str����Ϊ�մ�
}
