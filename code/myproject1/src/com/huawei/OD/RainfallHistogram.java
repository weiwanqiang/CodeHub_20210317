package com.huawei.OD;

import java.util.Stack;

/**
 * 
 * @author weiwanqiang
 * 雨水直方图
 * 单调栈
 * 通过
 */
public class RainfallHistogram {

	public static void main(String[] args) {
		int[] height = {2,1,0,2};
		System.out.println(getArea(height));

	}
	public static int getArea(int[] height) {
		int area = 0; //初始面积（雨水量）为0
		Stack<Integer> indexstack = new Stack<Integer>();//创建栈
		for(int i=0;i<height.length;i++) {
			int curheight = height[i];
			//当栈不为空且当前访问的直方图的高度大于等于栈顶直方图的高度时出栈，否则入栈
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
