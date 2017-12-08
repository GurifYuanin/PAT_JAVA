package ¼×¼¶Ò»ÂÖ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1046_2 {
	public static void main(String[] args) throws IOException {
		// DP
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		int size = Integer.parseInt(arr[0]);
		int[] path = new int[size];
		int[][] dis = new int[size][size];
		for (int i = 0; i < size; i++) {
			path[i] = Integer.parseInt(arr[i + 1]);
		}
		int time = Integer.parseInt(buf.readLine());

		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				dis[i][j] = dis[j][i] = path[j - 1] + dis[i][j - 1];
			}
		}
		int tmp, start, end;
		for (int i = 0; i < size; i++) {
			for (int j = size - 1; j > i; j--) {
				tmp = dis[i][(j + 1) % size] + path[j];
				if (dis[i][j] > tmp) {
					dis[i][j] = dis[j][i] = tmp;
				}
			}
		}
		for(int i = 0; i < time; i++) {
			arr = buf.readLine().split(" ");
			start = Integer.parseInt(arr[0]) - 1;
			end = Integer.parseInt(arr[1]) - 1;
			System.out.println(dis[start][end]);
		}
		buf.close();
	}
}
