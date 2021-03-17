package com.huawei.OD;

import java.util.Arrays;

/**
 * 
 * @author weiwanqiang
 * ����ת��
 * ͨ��
 */
public class MatrixTranspose {

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(Arrays.deepToString(matrix));
		System.out.println(Arrays.deepToString(getAnns(matrix)));
	}
	public static int[][] getAnns(int[][] matrix){
		//row �У�column �У�
		int row = matrix.length;
		int column = matrix[0].length;
		int[][] anns = new int[column][row];
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				anns[j][i] = matrix[i][j];
			}
		}
		System.out.println(Arrays.deepToString(anns));
		return anns;
	}

}
