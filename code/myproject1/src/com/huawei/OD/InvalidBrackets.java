package com.huawei.OD;

import java.util.Stack;

public class InvalidBrackets {

	public static void main(String[] args) {
		String s1 = "[]({[]})";
		boolean res = isValide(s1);
		System.out.println(res);

	}
	public static boolean isValide(String s) {
		boolean isvalid = false;
		if(s.length() < 2 || null ==s) {
			return isvalid;
		}
		int strlen = s.length();
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<strlen;i++) {
			char curitem = s.charAt(i);
			if(stack.size() == 0) {
				stack.push(curitem);
				isvalid = false;
				continue;
			}
			char top = (char)stack.peek();
			if((curitem==')' && top == '(') || (curitem=='}' && top == '{') || (curitem==']' && top == '[')) {
					stack.pop();
			}
			else if((curitem !=')' && top == '(') || (curitem !='}' && top == '{') || (curitem !=']' && top == '[')) {
					stack.push(curitem);
			}	
			if(stack.size() == 0) {
				isvalid = true;
			}else{
				isvalid = false;
			}
			
		}
//		for(int i=0;i<stack.toArray().length;i++) {
//			System.out.println(stack.toArray()[i]);
//		}
		return isvalid;
	}

}
