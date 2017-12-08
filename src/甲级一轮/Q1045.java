package ¼×¼¶Ò»ÂÖ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1045 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		buf.readLine();
		String[] arr = buf.readLine().split(" ");
		int favoriteNum = Integer.parseInt(arr[0]);
		int[] favorite = new int[favoriteNum];
		for (int i = 0; i < favoriteNum; i++) {
			favorite[i] = Integer.parseInt(arr[i + 1]);
		}
		arr = buf.readLine().split(" ");
		int colorNum = Integer.parseInt(arr[0]);
		int[] color = new int[colorNum];
		for (int i = 0; i < colorNum; i++) {
			color[i] = Integer.parseInt(arr[i + 1]);
		}
		buf.close();
		
		int[] value = new int[colorNum];
		int[] border = new int[colorNum];
		if (favorite[0] == color[0]) {
			value[0] = 1;
			border[0] = 0;
		}
		int index, max;
		for (int i = 1; i < colorNum; i++) {
			index = max = -1;
			for (int j = 0; j < favoriteNum; j++) {
				if (color[i] == favorite[j]) {
					index = j;
					break;
				}
			}
			if (index != -1) {
				for (int j = i - 1; j >= 0; j--) {
					if (max < value[j] && index >= border[j]) {
						max = value[j];
					}
				}
				value[i] = max + 1;
				border[i] = index;
			}
		}
		max = 0;
		for (int i = 0; i < colorNum; i++) {
			if (max < value[i]) {
				max = value[i];
			}
		}
		System.out.print(max);
	}
}
