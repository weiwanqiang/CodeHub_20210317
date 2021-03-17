package com.huawei.ODExam;


/**
 * 
 * @author weiwanqiang
 * ����һ���������ӵ�һ���������һ����������Ծ��
 * ÿ������ֵ��ʾ������λ�ÿ�����Ծ������ȣ�
 * ������������ٵ���Ծ�����������һ����
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
