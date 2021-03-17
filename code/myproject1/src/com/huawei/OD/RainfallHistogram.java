package com.huawei.OD;

import java.util.Stack;

/**
 * 
 * @author weiwanqiang
 * ��ˮֱ��ͼ
 * ����ջ
 * ͨ��
 */
public class RainfallHistogram {

	public static void main(String[] args) {
		int[] height = {2,1,0,2};
		System.out.println(getArea(height));

	}
	public static int getArea(int[] height) {
		int area = 0; //��ʼ�������ˮ����Ϊ0
		Stack<Integer> indexstack = new Stack<Integer>();//����ջ
		for(int i=0;i<height.length;i++) {
			int curheight = height[i];
			//��ջ��Ϊ���ҵ�ǰ���ʵ�ֱ��ͼ�ĸ߶ȴ��ڵ���ջ��ֱ��ͼ�ĸ߶�ʱ��ջ��������ջ
			while(indexstack.size()>0 && curheight >= height[indexstack.peek()]) {
				int lowestindex = indexstack.pop();
				int lowestheight = height[lowestindex];
				if (indexstack.size()>0) {
					int preheight = height[indexstack.peek()];
					int breadth = i-indexstack.peek()-1;
					int lower = curheight > preheight?preheight:curheight;
					area += (lower-lowestheight)*breadth;
				}
			}
			indexstack.push(i);
		}
		return area;
	}

}
