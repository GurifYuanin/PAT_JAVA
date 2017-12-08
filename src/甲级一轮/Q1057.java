package ¼×¼¶Ò»ÂÖ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Q1057 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(buf.readLine());
		String str;
		int value, size = 0;
		int[] rank;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < number; i++) {
			str = buf.readLine();
			switch (str) {
			case "Pop": {
				if (!stack.isEmpty()) {
					System.out.println(stack.pop());
				} else {
					System.out.println("Invalid");
				}
				break;
			}
			case "PeekMedian": {
				if (!stack.isEmpty()) {
					size = stack.size();
					rank = new int[size];
					for (int j = 0; j < size; j++) {
						rank[j] = stack.get(j);
					}
					Arrays.sort(rank);
					if (size % 2 == 0) {
						size--;
					}
					System.out.println(rank[size / 2]);
				} else {
					System.out.println("Invalid");
				}
				break;
			}
			default : {
				value = Integer.parseInt(str.split(" ")[1]);
				stack.push(value);
			}
			}
		}
		buf.close();
	}
}
