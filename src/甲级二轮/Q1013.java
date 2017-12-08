package ¼×¼¶¶þÂÖ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Q1013 {
	static boolean[][] tmp;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		String[] arr;
		int cityNum, pathNum, count, city, start, end, number;
		boolean[][] path;
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		arr = buf.readLine().split(" ");
		cityNum = Integer.parseInt(arr[0]);
		pathNum = Integer.parseInt(arr[1]);
		count = Integer.parseInt(arr[2]);
		path = new boolean[cityNum][cityNum];
		tmp = new boolean[cityNum][cityNum];
		visited = new boolean[cityNum];
		for (int i = 0; i < pathNum; i++) {
			arr = buf.readLine().split(" ");
			start = Integer.parseInt(arr[0]) - 1;
			end = Integer.parseInt(arr[1]) - 1;
			path[start][end] = path[end][start]= true;
		}
		arr = buf.readLine().split(" ");
		buf.close();
		
		for (int i = 0; i < count; i++) {
			number = 0;
			city = Integer.parseInt(arr[i]) - 1;
			// initial
			for (int m = 0; m < cityNum; m++) {
				for (int n = m; n < cityNum; n++) {
					tmp[m][n] = tmp[n][m] = path[m][n];
				}
			}
			for (int j = 0; j < cityNum; j++) {
				visited[j] = false;
				tmp[j][city] = tmp[city][j] = false;
			}
			for (int j = 0; j < cityNum; j++) {
				if (!visited[j]) {
					DFS(j);
					number++;
				}
			}
			System.out.println(number - 2);
		}
	}
	static void DFS(int index) {
		visited[index] = true;
		for (int i = visited.length - 1; i >= 0; i--) {
			if (!visited[i] && tmp[index][i]) {
				DFS(i);
			}
		}
	}
}
