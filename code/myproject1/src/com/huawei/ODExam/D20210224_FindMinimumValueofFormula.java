package com.huawei.ODExam;

import java.util.ArrayList;

/**
 * 
 * @author weiwanqiang
 * ������ʽ��Сֵ
 * ����10����������������ѡ������������ʽX+XY-Y+Z,Ҫ����ʽ�����Сֵ�������������ķ�Χ��[-512��512].
 * 
 * ����10������ 1 1 3 1 1 1 1 1 1 1
 * ��ʽ��Сֵ -4
 */
public class D20210224_FindMinimumValueofFormula {

	public static void main(String[] args) {
		int[] arr = {-512,1,1,3,1,1,1,1,1,1,1,3,0,2,4,1,3,1,3,1,1,3,1,1,1,1,3,1,2,1,1,2,3,4,4,5,2};
//		int[] arr = {-1,0,0,0,0,0,3,0,0,2};
		long start = System.currentTimeMillis();
		int sum = BruteForce(arr);
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		System.out.println(sum);
	}
	public static int BruteForce(int[] arr) {
		int len = arr.length;
		int[] arr_y = new int[len];
		int[] arr_z = new int[len];
		int minsum = Integer.MAX_VALUE;
		ArrayList<Integer> arrlst = new ArrayList<Integer>();
		for(int i=0;i<len;i++) {
			arr_y[i] = arr[i];
			arr_z[i] = arr[i];
		}
		for(int i=0;i<len;i++) {
			for(int j=0;j<len;j++) {
				for(int m=0;m<len;m++) {
					if(i != j && i != m && j != m) {
						int x = arr[i];
						int y = arr_y[j];
						int z = arr_z[m];
						int sum = x*x +x*y - y*y + z;
						minsum = minsum < sum ? minsum : sum;
					}
				}
			}
		
		}
		return minsum;
	}
	

}
