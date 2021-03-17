package com.huawei.ODExam;


/**
 * 
 * @author weiwanqiang
 * 给出一组整数，从第一个数向最后一个数方向跳跃，
 * 每个数的值表示你从这个位置可以跳跃的最长长度，
 * 计算如何以最少的跳跃次数跳到最后一个数
 * 123112
 * 3
 *
 */
public class D20210301_JumpGame {
	public static int jump(int[] nums) {
		int maxreach = 0;
		int end = 0;
		int step = 0;
		for(int i=0;i<nums.length-1;i++) {
			maxreach = Math.max(maxreach, nums[i]+i);
			if(i == end) {
				if(end == maxreach) {
					return -1;
				}
				end = maxreach;
				step ++;
			}
		}
		return step;
    }
	public static void main(String[] args) {
		int[] arr = {1,2,1,1,0,2};
		System.out.println(jump(arr));
	}
}
