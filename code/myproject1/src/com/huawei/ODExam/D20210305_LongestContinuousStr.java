package com.huawei.ODExam;

import java.util.ArrayList;


/**
 * 
 * @author weiwanqiang
 * Ѱ��������ִ�
 * ����һ���ַ���������Щ�ַ����������ֵ��ص㣬
 * ��Ѱ����Щ���������ַ�����Ĵ����������ִ��ж�������ASCII����С��һ��
 *
 */
public class D20210305_LongestContinuousStr {
	public static String LongestStr(String str) {
		str = str + " ";
		String maxstr = "";
		int left = 0;
		int right = 0;
		int maxstr_sum=0;
		int str_sum = 0;
		ArrayList<String> lst = new ArrayList<String>();
		while(right < str.length()) {
			if(str.charAt(right) != str.charAt(left)) {
				if(maxstr.length() < str.substring(left, right).length()) {
					maxstr = str.substring(left, right);
				}
				else if(maxstr.length() == str.substring(left, right).length()) {
					for(int i=0;i<maxstr.length();i++) {
						maxstr_sum += maxstr.charAt(i);
						str_sum += str.substring(left, right).charAt(i);
					}
					maxstr = maxstr_sum > str_sum ? maxstr:str.substring(left, right);
				}
				if(! lst.contains(str.substring(left, right))) {
					lst.add(str.substring(left, right));
				}
				left = right;
			}
			right ++;

		}
//		
//		System.out.println(lst);
//		System.out.println(maxstr);
		return maxstr;
		
	}
	public static void main(String[] args) {
		String string = "abcqqwwwewwwAAAAAaaaaa";
		System.out.println(LongestStr(string));
		System.out.println('b'-'a');
	}
}
