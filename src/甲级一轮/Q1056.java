package ¼×¼¶Ò»ÂÖ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1056 {
	public static void main(String[] args) throws IOException {
		String[] arr;
		int number, group, max, index;
		int[] tmp, weight, rank;
		boolean[] isLose;
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		arr = buf.readLine().split(" ");
		number = Integer.parseInt(arr[0]);
		group = Integer.parseInt(arr[1]);
		tmp = new int[number];
		weight = new int[number];
		rank = new int[number];
		isLose = new boolean[number];
		Arrays.fill(rank, number / group + 1);
		Arrays.fill(isLose, false);
		arr = buf.readLine().split(" ");
		for (int i = 0; i < number; i++) {
			tmp[i] = Integer.parseInt(arr[i]);
		}
		arr = buf.readLine().split(" ");
		for (int i = 0; i < number; i++) {
			weight[Integer.parseInt(arr[i])] = tmp[i];
		}
		buf.close();
		
		for (int i = 0; i < number; i++) {
			
		}
	}
}
