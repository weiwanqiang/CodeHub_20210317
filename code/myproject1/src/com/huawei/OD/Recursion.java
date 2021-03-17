package com.huawei.OD;

import java.util.Stack;

/**
 * 
 * @author weiwanqiang
 * µ›πÈ«Û∫Õ
 */
public class Recursion {
	public static void main(String[] args) {
		Stack<Integer> arr = new Stack<Integer>();
//		arr.add(1);
//		arr.add(2);
//		arr.add(8);
//		arr.add(5);
		System.out.println(getSum(arr));
	}
	public static int getSum(Stack<Integer> arr) {
		if(arr.isEmpty()) {
			return 0;
		}
		if(arr.size() == 1) {
			return (int)arr.pop();
		}
		else {
			 int firstitem = (int)arr.pop();
			return firstitem + getSum(arr);
		}
	}
}
