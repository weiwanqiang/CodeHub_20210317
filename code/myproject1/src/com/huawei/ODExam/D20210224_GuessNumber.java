package com.huawei.ODExam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author weiwanqiang
 * xAyB��������Ϸ
 * �����������֣�ÿ�����ְ���4���Ǹ�������ͬһ���е�4�����ֻ�����ͬ�����ּ��Կո�ָ���
 * ��һ������Ϊ��������Ϸ����ȷ�𰸣��ڶ�������Ϊ������µĴ𰸣��������£�
 * ��������ֵĽ��xAyB.
 * ����һ�����������ͬ��λ����ͬ�����һ��A
 * ����������������ͬ��λ�ò�ͬ�����һ��B
 * 
 * ����ȷ��Ϊ1 2 3 4����Ҳ²�1 2 5 3������Ϊ2A1B����������1��2�������һ��
 * ����3����������
 */
public class D20210224_GuessNumber {
	public static String Guesresulte() {
		String[] ans = new String[4];
		String[] guess = new String[4];
		Scanner input = new Scanner(System.in);
		Scanner output = new Scanner(System.in);
		ans = input.nextLine().split(" ");
		guess = input.nextLine().split(" ");
		int num1 = 0;
		int num2 = 0;
		for(int i=0;i<ans.length;i++) {
			for(int j=0;j<guess.length;j++) {
				if(i==j && ans[i].equals(guess[j])) {
					num1 += 1;
				}
				if(i !=j && ans[i].equals(guess[j]) ) {
					num2 += 1;
				}
			}
		}
		String res = num1 +"A" + num2 +"B";
		return res;
		
	}
	public static void main(String[] args) {
		System.out.println(Guesresulte());
	}
}
