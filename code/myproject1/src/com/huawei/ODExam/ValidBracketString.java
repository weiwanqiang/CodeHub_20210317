package com.huawei.ODExam;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

/**
 * 
 * @author weiwanqiang
 * 有效括号字串
 * 例如“()(()()(”的有效括号字串包括()和()(),其最长的有效括号子串长度为4；
 * 返回最长有效括号子串的长度
 * 输入：()(()()(
 * s输出：4
 *
 */
public class ValidBracketString {
	public static int getLongestLen(String str){
		char[] ch = str.toCharArray();
		int ch_len = ch.length;
		ArrayList<Integer> index = new ArrayList<Integer>();
		Stack<Integer> sta = new Stack<Integer>();
		sta.push(-1);
		int max_sublen = 0;
		for(int i=0;i<ch_len;i++) {
			if(ch[i] == '(') {
				sta.push(i);
			}else {
				sta.pop();
				if(sta.isEmpty()) {
					sta.push(i);
				}
			}
			max_sublen = Math.max(max_sublen, i-sta.peek());
		}
		System.out.println(max_sublen);
		return max_sublen;
		
	}
	public static void main(String[] args) {
		getLongestLen("()(()()(");
	}
}
