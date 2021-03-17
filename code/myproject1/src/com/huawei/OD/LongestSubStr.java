package com.huawei.OD;

import java.util.HashMap;

/**
 * 
 * @author weiwanqiang
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 */
public class LongestSubStr {

	public static void main(String[] args) {
		String s = "dvvdf";
		System.out.println(lengthOfLongestSubstring(s));
	}
	 public static int lengthOfLongestSubstring(String s) {
		 int left = 0;
		 int right = 0;
		 int sublen = 0;
		 int strlen = s.length();
		 HashMap<Character,Integer> dict = new HashMap<Character,Integer>();
		 if(strlen == 0) {
			 return 0;
		 }
		 for(;right<strlen;right++) {
			 char curchar = s.charAt(right);
			 if(dict.containsKey(curchar)) {
				 left = Math.max(dict.get(curchar), left);
			 }
			 sublen = Math.max(sublen,right-left+1);
			 dict.put(curchar, right+1);
		 }
		 return sublen;
	    }
}
