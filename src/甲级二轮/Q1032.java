package ¼×¼¶¶þÂÖ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1032 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		int s1 = Integer.parseInt(arr[0]);
		int s2 = Integer.parseInt(arr[1]);
		int num = Integer.parseInt(arr[2]);
		int next[] = new int[100000];
		char ch[] = new char[100000];
		boolean visited[] = new boolean[100000];
		Arrays.fill(visited, false);
		for (int i = 0; i < num; i++) {
			arr = buf.readLine().split(" ");
			next[Integer.parseInt(arr[0])] = Integer.parseInt(arr[2]);
			ch[Integer.parseInt(arr[0])] = arr[1].charAt(0);
		}
		buf.close();
		
		while (s1 != -1) {
			visited[s1] = true;
			s1 = next[s1];
		}
		while (s2 != -1 && visited[s2] == false) {
			s2 = next[s2];
		}
		if (s2 != -1) {
			System.out.printf("%5d", s2);
		} else {
			System.out.print(-1);
		}
	}
}
