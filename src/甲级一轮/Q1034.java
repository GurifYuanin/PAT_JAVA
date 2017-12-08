package 甲级一轮;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Q1034 {
	public static void main(String[] args) throws IOException {
		/*
		 * 输入：电话数 帮派最短通话时长
		 * 			 甲 乙 通话时长
		 * 			 ...
		 * 输出：总帮派数
		 * 			 头领 帮派规模
		 * 			 ...
		 * */
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		int phone = Integer.parseInt(arr[0]);
		int threshold = Integer.parseInt(arr[1]);
		String[] line = new String[phone];
		for (int i = 0; i < phone; i++) {
			line[i] = buf.readLine();
		}
		buf.close();
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0, j = 0; i < phone; i++) {
			arr = line[i].split(" ");
			if (!map.containsKey(arr[0])) {
				map.put(arr[0], j);
				j++;
			}
			if (!map.containsKey(arr[1])) {
				map.put(arr[1], j);
				j++;
			}
		}
		int people = map.size();
		int[][] weight = new int[people][people];
		for (int i = 0; i < phone; i++) {
			arr = line[i].split(" ");
			int a = map.get(arr[0]);
			int b = map.get(arr[1]);
			int c = Integer.parseInt(arr[2]);
			weight[a][b] =  weight[b][a] += c;
		}
		boolean[] visited = new boolean[people];
		Arrays.fill(visited, false);
		int[] time = new int[people];
		int count = 0;
		for (int i = 0; i < people; i++) {
			for (int j = 0; j < people; j++) {
				time[i] += weight[i][j];
			}
			if (time[i] > threshold) {
				count++;
			}
		}
		System.out.print(count);
	}
	static void DFS(int[][] path, boolean[] visited, int index) {
		visited[index] = true;
		int size = path[0].length;
		for (int i = 0; i < size; i++) {
			if (path[index][i] != 0 && !visited[i]) {
				DFS (path, visited, i);
			}
		}
	}
}
