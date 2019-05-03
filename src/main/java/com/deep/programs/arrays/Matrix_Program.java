package com.deep.programs.arrays;

//Check correct Program Number_Pattern
public class Matrix_Program {
	public static void main(String[] args) {

		int rownum = 5;
		int odd = rownum * rownum, even = (rownum) * (rownum - 1);

		int arr[][] = new int[rownum][rownum];

		for (int i = 0; i < rownum; i++) {
			if (i % 2 == 0) {
				for (int j = rownum - 1; j >= 0; j--) {
					arr[i][j] = odd;
					odd--;
				}
				odd = odd - rownum;
			} else {
				for (int k = 0; k < rownum; k++) {
					arr[i][k] = even;
					even--;
				}
				even = even - rownum;
			}
		}

		for (int i = 0; i < rownum; i++) {
			for (int j = 0; j < rownum; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();

		}

	}
}
