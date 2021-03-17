package com.huawei.OD;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * 
 * @author weiwanqiang
 * 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。
 * 若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水
 * 域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/pond-sizes-lcci
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	输入：
	[
  		[0,2,1,0],
  		[0,1,0,1],
  		[1,1,0,1],
  		[0,1,0,1]
	]
输出： [1,2,4]
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
