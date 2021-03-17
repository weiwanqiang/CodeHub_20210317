package com.huawei.ODExam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class D20210309_SuShuDui {
	public static ArrayList<Integer> sushu(){
		int left = 0;
		int right = 0;
		Map<Integer, Integer> sushudic = new HashMap<Integer, Integer>();
		ArrayList<Integer> sushulst = new ArrayList<Integer>();
		for(int i=1;i<=100;i++) {
			if(isSuShu(i)) {
				sushulst.add(i);
			}
		}
		System.out.println(sushulst);
		while(right < sushulst.size()) {
			if(sushulst.get(right)-sushulst.get(left) == 2) {
				sushudic.put(sushulst.get(right), sushulst.get(left));
				left ++;
				right++;
			}else if(sushulst.get(right)-sushulst.get(left) < 2){
				right ++;
			}else {
				left++;
				
			}
		}
		System.out.println(sushudic);
		return sushulst;
	}
	public static boolean isSuShu(int n) {
		boolean sushu = true;
		for(int i=2;i<=9;i++) {
			if(i != n && n % i == 0) {
					sushu = false;
			}
		}
		return sushu;	
	}
	public static void main(String[] args) {
		int a = 1;
		System.out.println(isSuShu(a));
		sushu();
	}
}
