package com.huawei.OD;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author weiwanqiang
 * 快速排序
 * 递归
 * 分而治之
 */
public class QuickSorting {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(9,1,12,54,96,2,1,2,3,8,2,4));
		System.out.println(quickSort(arr));
}
	static ArrayList<Integer> quickSort(ArrayList<Integer> arr) {
		int arrlen = arr.size();
		if(arrlen <= 1) {
			return arr;
		}
		else{
			int baseitem = arr.get(0);
			ArrayList<Integer> lesslist = new ArrayList<Integer>();
			ArrayList<Integer> greaterlist = new ArrayList<Integer>();
			ArrayList<Integer> finallist = new ArrayList<Integer>();
			for(int i=1;i<arrlen;i++) {
				if (arr.get(i) <= baseitem) {
					lesslist.add(arr.get(i));
				}
				else {
					greaterlist.add(arr.get(i));
				}
			}
			finallist.addAll(quickSort(lesslist));
			finallist.add(baseitem);
			finallist.addAll(quickSort(greaterlist));
			return finallist;
		}			
	}
}
