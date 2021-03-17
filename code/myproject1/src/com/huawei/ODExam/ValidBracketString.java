package com.huawei.ODExam;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

/**
 * 
 * @author weiwanqiang
 * ��Ч�����ִ�
 * ���硰()(()()(������Ч�����ִ�����()��()(),�������Ч�����Ӵ�����Ϊ4��
 * �������Ч�����Ӵ��ĳ���
 * ���룺()(()()(
 * s�����4
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
