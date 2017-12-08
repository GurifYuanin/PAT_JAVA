package ¼×¼¶¶þÂÖ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1046 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		int nodeNum = Integer.parseInt(arr[0]);
		int[] path = new int[nodeNum];
		int[][] dis = new int[nodeNum][nodeNum];
		for (int i = 0; i  < nodeNum; i++) {
			path[i] = Integer.parseInt(arr[i + 1]);
		}
		for (int i = 0; i < nodeNum; i++) {
			dis[i][i] = 0;
			for (int j = 1, index =  i + 1; j < nodeNum; j++, index++) {
				//index %= nodeNum;
				dis[i][index % nodeNum] = dis[i][(index - 1) % nodeNum] + path[(index - 1) % nodeNum];
			}
		}
		int count  = Integer.parseInt(buf.readLine()), start, end;
		for (int i = 0;  i < count; i++) {
			arr = buf.readLine().split(" ");
			start = Integer.parseInt(arr[0]) - 1;
			end = Integer.parseInt(arr[1]) - 1;
			System.out.println(dis[start][end] < dis[end][start] ? dis[start][end] : dis[end][start]);
		}
		buf.close();
	}
}
