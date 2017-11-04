package ch03;
/*
 * 表达式求值问题
 * 
 */

public class Example3_3 {
	//将算术表达式转换为后缀表达式的函数，结果以字符串的形式返回
	public String convertToPostfix(String expression)throws Exception{
		 LinkStack st = new LinkStack();// 运算符栈  
	        String postFix = "";// 后缀表达式  
	        for (int i = 0; expression != null && i < expression.length(); i++) {  
	            char c = expression.charAt(i);// 遍历，如果是操作数，如果是操作符  
	            if (' ' != c) {// 字符不能为空  
	                if (isOpenParenthesis(c)) {// 左括号  
	                    // 左括号就入栈  
	                    st.push(c);  
	                } else if (isCloseParenthesis(c)) {// 右括号  
	                    // 右括号就把所有的操作符出栈知道遇到一个左括号为止，然后将该左括号出栈并丢弃  
	                    Character ac = (Character) st.pop();  
	                    while (!isOpenParenthesis(ac)) {  
	                        postFix += ac.toString();  
	                        ac = (Character) st.pop();// 如果取出的是左括号，很显然就丢弃了  
	                    }  
	                } else if (isOperator(c)) {// 操作符  
	                    /* 
	                     * 如果栈为空，直接进栈。 如果栈非空，则需要将栈顶运算符的优先级和要入栈的运算符的优先级进行比较 
	                     * 将栈中比要入栈的运算符优先级高的运算符都出栈，然后将该运算符入栈 
	                     */  
	                    if (!st.isEmpty()) { // 如果栈非空，则需要判断  
	                        Character ac = (Character) st.pop();  
	                        while (ac != null  
	                                && priority(ac.charValue()) > priority(c)) {  
	                            postFix += ac;  
	                            ac = (Character) st.pop();  
	                            // 因为是先取出来后判断是，所以如果跳出循环 需要将最后一次取出的操作符压入栈  
	                        }  
	                        // 将最后一次取出的优先级低的运算符入栈  
	                        if (ac != null) {  
	                            st.push(ac);  
	                        }  
	                    }  
	                    // 最后，将该运算符入栈  
	                    st.push(c);  
	                } else {// 操作数，直接添加到后缀表达式 中  
	                    postFix += c;  
	                }  
	            }  
	        }  
	        // 最后的时候，如果栈非空，则需要栈中的所有的运算符串联到后缀表达式的末尾  
	        while (!st.isEmpty()) {  
	            postFix += st.pop().toString();  
	        }  
	        return postFix;  
	    }  
		//对后缀表达式进行求值计算的函数
	 public double numberCalculate(String postFix) throws Exception {  
	        LinkStack st = new LinkStack();// 操作数栈  
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
	                  
	                st.push(d3);//将操作后的结果入栈  
	            }else{//当是操作数时，就直接进操作数栈  
	                st.push(c);  
	            }  
	  
	        }  
	  
	        return (double) st.pop();  
	    }  
	  
	    /** 
	     * @Describe_求运算符的优先级 
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
	  
	    /** @Describe是否是一个操作符_ 
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
		System.out.println("表达式的计算结果为："+p.numberCalculate(postfix));
	}

}
