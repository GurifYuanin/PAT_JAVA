package ¼×¼¶¶þÂÖ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1045 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		buf.readLine();
		String[] arr = buf.readLine().split(" ");
		int len1 = Integer.parseInt(arr[0]) + 1;
		int[] arr1 = new int[len1];
		for (int i = 1; i < len1; i++) {
			arr1[i] = Integer.parseInt(arr[i]);
		}
		arr = buf.readLine().split(" ");
		int len2 = Integer.parseInt(arr[0]) + 1;
		int[] arr2 = new int[len2];
		for (int i = 1; i < len2; i++) {
			arr2[i] = Integer.parseInt(arr[i]);
			
		}
		buf.close();		
		// Initial the table
		int[][] table = new int[len1][len2];
		Arrays.fill(table[0], 0);
		for (int i = 0; i < len1; i++) {
			table[i][0] = 0;
		}
		// Write the able
		for (int i = 1; i < len1; i++) {
			for (int j = 1; j < len2; j++) {
				if (arr1[i] == arr2[j]) {
					table[i][j] = table[i][j - 1] + 1;
				} else {
					table[i][j] = Math.max(table[i][j - 1], table[i - 1][j]);
				}
			}
		}
		System.out.print(table[len1 - 1][len2 - 1]);
	}
}
