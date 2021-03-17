package com.huawei.ODExam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author weiwanqiang
 * 长整数相加
 * 给定一组长整数，求相加的结果。
 * 第一行：整数数量（范围2-5）
 * 第二行及以后，每行一个长整数，如11111111111111111111111111111111111，最长不超过100；
 * 最后一行数据后加回车换行，输出所有长整数相加后的结果
 * 3
 * 11111111111111111111111111111111111
 * 1111
 * 134567324
 * 
 * 
 *
 */
public class D20210224_LongNumberAdd {
	@SuppressWarnings("resource")
	public static String getSum() {
		Scanner rows = new Scanner(System.in);//输入长整数的行数
		Scanner input = new Scanner(System.in);//输入每行的长整数字符串
		int row = rows.nextInt();//长整数的行数
		String[] inputs = new String[row];//用来接收每一行长整数字符串
		int addone = 0;//进位
		int maxlen = 0;//最长长整数长度
		for(int i=0;i<row;i++) {
			inputs[i] = input.next();//每一行长整数长度
		}
		for(int i=0;i<row;i++) {
			//获取最长长整数长度
			maxlen = maxlen > inputs[i].length() ? maxlen : inputs[i].length();
		}
		int[] sum = new int[maxlen+1];//新创建一个存储整数和的数组，数组长度为maxlen+1（最高位之和可能大于10）

		for(int j=0;j<row;j++) {//遍历每一行
			while(maxlen-inputs[j].length()>0) {
				//每行的长整数的长度小于最长长整数长度时，长整数的剩余高位用0补充，使每行的长度一致
				inputs[j] = "0"+inputs[j];
			}
			for(int k=inputs[j].length()-1;k>=0;k--) {//从最后一位字符开始遍历每一行每一字符
				//Integer.parseInt(String)将数字字符串转化成数字
				int item = Integer.parseInt(inputs[j].charAt(k)+"");
				int sumk = sum[k+1];//赋值和数组每一位的字符的值，初始值为0；
				sum[k+1] = (sumk + item + addone) % 10;//每一位和取每一行相加和与进位的和与10的模
				addone = (sumk + item + addone)/10;//进位的值是各位和除以10后的整数
				if(k==0 && addone > 0) {
					sum[0] += addone;//如果最高位的和的进位>0,则和数组的最高位取该进位的值
				}
			}
		}
		
		ArrayList<Integer> lst = new ArrayList<Integer>();//创建数组列表
		String res = "";//创建结果字符串
		for(int i=0;i<sum.length;i++) {
			lst.add(sum[i]);
			//如果最高位是0，则删除最高位
			if(lst.get(0) == 0) {
				lst.remove(0);
			}
			
		}
		for(int s : lst) {
			res = res+s;//将数组列表中的每一位元素拼接成最终结果
		} 
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(getSum());
	}
}
