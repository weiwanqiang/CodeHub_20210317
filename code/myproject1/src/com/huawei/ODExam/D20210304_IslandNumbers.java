package com.huawei.ODExam;

public class D20210304_IslandNumbers {
	public static void main(String[] args) {
		char[][] arr = {
				{'1','1','1','0','0'},
				{'1','1','0','1','0'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'}
		};
		System.out.println(getIslandNum(arr));
	}
	public static int getIslandNum(char[][] arr) {
		int island = 0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				if(arr[i][j] == '1') {
					recurision(arr, i, j);			
					island ++;
				}
			}
		}
		return island;		
	}
	public static void recurision(char[][] grid,int x,int y) {
		if(x<0 || x > grid.length-1 || y < 0 || y > grid[0].length-1 || grid[x][y] != '1') {
			return;
		}
		grid[x][y] = '0';
		//…œœ¬◊Û”“≤È’“
		recurision(grid, x-1, y);
		recurision(grid, x+1, y);
		recurision(grid, x, y+1);
		recurision(grid, x, y-1);
	}

}
