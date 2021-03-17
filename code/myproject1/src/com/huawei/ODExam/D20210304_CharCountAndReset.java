package com.huawei.ODExam;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;


/**
 * 
 * @author weiwanqiang
 * �ַ�ͳ�Ƽ�����
 * ����һ����������ĸ���ַ������������ո�ͳ�Ƹ��ַ������ִ�Сд���ĸ�����
 * ��������ĸ���ֵĴ����Ӵ�С��˳�����������ĸ�����ִ�����Ϣ��
 * ���������ͬ������Ȼ˳���������
 */
public class D20210304_CharCountAndReset {
	public static void handChar(String str) {
		Map<Character, Integer> char_map = new HashMap<Character, Integer>();
		for(int i=0;i<str.length();i++) {
			if(char_map.containsKey(str.charAt(i))) {
				char_map.put(str.charAt(i), char_map.get(str.charAt(i))+1);
			}else {
				char_map.put(str.charAt(i), 1);
			}
		}
		System.out.println(char_map);
		
		List<Map.Entry<Character, Integer>> lst = new LinkedList<>(char_map.entrySet());
		Collections.sort(lst, new Comparator<Map.Entry<Character, Integer>>()
		{
			public  int compare(Entry<Character, Integer> o1,Entry<Character, Integer> o2) {
				return o1.getValue() - o2.getValue();
			}
		});
		
		for(int j = lst.size()-1;j>=0;j--) {
			System.out.println(lst.get(j).getKey()+":"+" "+lst.get(j).getValue()+"��");
		}
		
	}
	public static void main(String[] args) {
		handChar("AAzzzzAAsssaaaadddddddeeetr");
		
	}
}
