package ch03;
/*
 * ���ʽ��ֵ����
 * 
 */

public class Example3_3 {
	//���������ʽת��Ϊ��׺���ʽ�ĺ�����������ַ�������ʽ����
	public String convertToPostfix(String expression)throws Exception{
		 LinkStack st = new LinkStack();// �����ջ  
	        String postFix = "";// ��׺���ʽ  
	        for (int i = 0; expression != null && i < expression.length(); i++) {  
	            char c = expression.charAt(i);// ����������ǲ�����������ǲ�����  
	            if (' ' != c) {// �ַ�����Ϊ��  
	                if (isOpenParenthesis(c)) {// ������  
	                    // �����ž���ջ  
	                    st.push(c);  
	                } else if (isCloseParenthesis(c)) {// ������  
	                    // �����žͰ����еĲ�������ջ֪������һ��������Ϊֹ��Ȼ�󽫸������ų�ջ������  
	                    Character ac = (Character) st.pop();  
	                    while (!isOpenParenthesis(ac)) {  
	                        postFix += ac.toString();  
	                        ac = (Character) st.pop();// ���ȡ�����������ţ�����Ȼ�Ͷ�����  
	                    }  
	                } else if (isOperator(c)) {// ������  
	                    /* 
	                     * ���ջΪ�գ�ֱ�ӽ�ջ�� ���ջ�ǿգ�����Ҫ��ջ������������ȼ���Ҫ��ջ������������ȼ����бȽ� 
	                     * ��ջ�б�Ҫ��ջ����������ȼ��ߵ����������ջ��Ȼ�󽫸��������ջ 
	                     */  
	                    if (!st.isEmpty()) { // ���ջ�ǿգ�����Ҫ�ж�  
	                        Character ac = (Character) st.pop();  
	                        while (ac != null  
	                                && priority(ac.charValue()) > priority(c)) {  
	                            postFix += ac;  
	                            ac = (Character) st.pop();  
	                            // ��Ϊ����ȡ�������ж��ǣ������������ѭ�� ��Ҫ�����һ��ȡ���Ĳ�����ѹ��ջ  
	                        }  
	                        // �����һ��ȡ�������ȼ��͵��������ջ  
	                        if (ac != null) {  
	                            st.push(ac);  
	                        }  
	                    }  
	                    // ��󣬽����������ջ  
	                    st.push(c);  
	                } else {// ��������ֱ����ӵ���׺���ʽ ��  
	                    postFix += c;  
	                }  
	            }  
	        }  
	        // ����ʱ�����ջ�ǿգ�����Ҫջ�е����е��������������׺���ʽ��ĩβ  
	        while (!st.isEmpty()) {  
	            postFix += st.pop().toString();  
	        }  
	        return postFix;  
	    }  
		//�Ժ�׺���ʽ������ֵ����ĺ���
	 public double numberCalculate(String postFix) throws Exception {  
	        LinkStack st = new LinkStack();// ������ջ  
	        for (int i = 0; i < postFix.length(); i++) {  
	            char c = postFix.charAt(i);  
	            if (isOperator(c)) { 
	                double d2 = Double.valueOf(st.pop().toString());  
	                double d1 = Double.valueOf(st.pop().toString());  
	                double d3 = 0;  
	                switch (c) {  
	                case '+':  
	                    d3=d1+d2;  
	                    break;  
	                case '-':  
	                    d3=d1-d2;  
	                    break;  
	                case '*':  
	                    d3=d1*d2;  
	                    break;  
	                case '/':  
	                    d3=d1/d2;  
	                    break;  
	                case '%':  
	                    d3=d1%d2;  
	                    break;  
	                case '^':  
	                    d3=Math.pow(d1, d2);  
	                    break;  
	                  
	                default:  
	                    break;  
	                }  
	                  
	                st.push(d3);//��������Ľ����ջ  
	            }else{//���ǲ�����ʱ����ֱ�ӽ�������ջ  
	                st.push(c);  
	            }  
	  
	        }  
	  
	        return (double) st.pop();  
	    }  
	  
	    /** 
	     * @Describe_������������ȼ� 
	     */  
	    private int priority(char c) {  
	        switch (c) {  
	        case '^':  
	            return 3;  
	        case '*':  
	        case '/':  
	        case '%':  
	            return 2;  
	        case '+':  
	        case '-':  
	            return 1;  
	        }  
	        return 0;  
	    }  
	  
	    /** @Describe�Ƿ���һ��������_ 
	     */  
	    private boolean isOperator(char c) {  
	        if ('+' == c || '-' == c || '*' == c || '/' == c || '^' == c  
	                || '%' == c) {  
	            return true;  
	        }  
	        return false;  
	    }  

	    private boolean isCloseParenthesis(char c) {  
	        return ')' == c;  
	    }  
	    private boolean isOpenParenthesis(char c) {  
	        return '(' == c;  
	    }
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Example3_3 p =new Example3_3();
		String postfix =p.convertToPostfix("(1+2)*(5-2)/2^2+5%3");
		System.out.println("���ʽ�ļ�����Ϊ��"+p.numberCalculate(postfix));
	}

}
