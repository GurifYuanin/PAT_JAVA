package ¼×¼¶¶þÂÖ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Q1053 {
	public static void main(String[] args) throws IOException {
		String[] arr;
		int nodeNum, nonNum, value, count, parent, index;
		String str;
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		arr = buf.readLine().split(" ");
		nodeNum = Integer.parseInt(arr[0]);
		nonNum = Integer.parseInt(arr[1]);
		value = Integer.parseInt(arr[2]);
		int[] pre = new int[nodeNum];
		int[] weight = new int[nodeNum];
		boolean[] isLeft = new boolean[nodeNum];
		Arrays.fill(pre, -1);
		Arrays.fill(isLeft, true);
		arr = buf.readLine().split(" ");
		for (int i = 0; i < nodeNum; i++) {
			weight[i] = Integer.parseInt(arr[i]);
		}
		for (int i = 0; i < nonNum; i++) {
			arr = buf.readLine().split(" ");
			parent = Integer.parseInt(arr[0]);
			count = Integer.parseInt(arr[1]) + 2;
			isLeft[parent] = false;
			for (int j = 2; j < count; j++) {
				pre[Integer.parseInt(arr[j])] = parent;
				
			}
		}
		buf.close();
		
		Stack<Integer> stack = new Stack<Integer>();
		Stack<String> list = new Stack<String>();
		for (int i = 0; i < nodeNum; i++) {
			count = 0;
			index = i;
			stack.clear();
			str = "";
			if (isLeft[index]) {
				do {
					count += weight[index];
					stack.push(weight[index]);
					index = pre[index];
				} while (index != -1);
				if (count == value) {
					while (!stack.isEmpty()) {
						str += stack.pop() + " ";
					}
					list.push(str.trim());
				}
			}
		}
		Collections.sort(list);
		while (!list.isEmpty()) {
			System.out.println(list.pop());
		}
	}
}
