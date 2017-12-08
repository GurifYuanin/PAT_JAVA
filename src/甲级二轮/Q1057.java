package ¼×¼¶¶þÂÖ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1057 {
	public static void main(String[] args) throws IOException {
		int lineNum;
		int index = -1;
		int[] stack = new int[100001];
		String str;
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		lineNum = Integer.parseInt(buf.readLine());
		for (int i = 0; i< lineNum; i++) {
			str = buf.readLine();
			switch(str) {
			case "Pop": {
				if (index == -1) {
					System.out.println("Invalid");
				} else {
					System.out.println(stack[index--]);
				}
				break;
			}
			case "PeekMedian": {
				if (index == -1) {
					System.out.println("Invalid");
				} else {
					System.out.println(stack[(index + 1) / 2]);
				}
				break;
			}
			default: {
				stack[++index] = Integer.parseInt(str.split(" ")[1]);
			}
			}
		}
		buf.close();
	}
}
