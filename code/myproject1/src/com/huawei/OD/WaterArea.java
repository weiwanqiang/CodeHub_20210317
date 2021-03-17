package com.huawei.OD;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * 
 * @author weiwanqiang
 * ����һ�����ڱ�ʾһƬ���ص���������land���þ�����ÿ�����ֵ�����Ӧ�ص�ĺ��θ߶ȡ�
 * ��ֵΪ0���ʾˮ���ɴ�ֱ��ˮƽ��Խ����ӵ�ˮ��Ϊ�����������Ĵ�С��ָ�����ӵ�ˮ
 * ��ĸ�������дһ��������������������г����Ĵ�С������ֵ��Ҫ��С��������
	��Դ�����ۣ�LeetCode��
	���ӣ�https://leetcode-cn.com/problems/pond-sizes-lcci
	����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
	���룺
	[
  		[0,2,1,0],
  		[0,1,0,1],
  		[1,1,0,1],
  		[0,1,0,1]
	]
����� [1,2,4]
 *
 */
public class WaterArea {
	public static void main(String[] args) {
		int[][] land = {{0,2,1,0},{0,1,0,1},{1,1,0,1},{0,1,0,1}};
		int[] res = pondSizes(land);
		for(int i:res) {
			System.out.println(i);
		}
	}
	public static int[] pondSizes(int[][] land) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		for(int i=0;i<land.length;i++) {
			for(int j=0;j<land[0].length;j++) {
				if(land[i][j] == 0) {
					res.add(dfs(land,i,j));
				}	
			}
		}
		int[] intarr = new int[res.size()];
		for(int i=0;i<res.size();i++) {
			intarr[i] = res.get(i);
		}
		Arrays.sort(intarr);
		return intarr;
    } 
	public static int dfs(int[][] land, int x, int y) {
		int rows = land.length;
		int columns = land[0].length;
		int area = 0;
		if(land[x][y] != 0) {
			return 0;
		}
		land[x][y] = 1;
		area = 1;
		int[][] dir = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,1},{1,-1},{-1,-1}};
		for(int i=0;i<dir.length;i++) {
			int dx = dir[i][0];
			int dy = dir[i][1];
			int nextx = dx +x;
			int nexty = dy + y;
			if(nextx >=0 && nextx <rows && nexty >= 0 && nexty < columns && land[nextx][nexty]==0) {
				area += dfs(land,nextx,nexty);
			}
		}
		return area;
	}
}
