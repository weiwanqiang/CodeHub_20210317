package com.huawei.ODExam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author weiwanqiang
 * xAyB猜数字游戏
 * 输入两组数字，每组数字包含4个非负整数，同一组中的4个数字互不相同，数字间以空格分隔。
 * 第一组数字为猜数字游戏的正确答案，第二组数字为玩家所猜的答案，规则如下，
 * 输出猜数字的结果xAyB.
 * 规则一：如果数字相同且位置相同，则得一个A
 * 规则二：如果数字相同但位置不同，则得一个B
 * 
 * 如正确答案为1 2 3 4，玩家猜测1 2 5 3，则结果为2A1B，其中数字1，2满足规则一，
 * 数字3满足规则二。
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
