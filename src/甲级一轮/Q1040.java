package 甲级一轮;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1040 {
	public static void main(String[] args) throws IOException {
		/*
		 * 输入：字符串
		 * 输出：子最大对称字符串长度
		 * */
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String str = buf.readLine();
		buf.close();
		
		int length = str.length();
		int len = 0;
		int border = 0;
		int max1 = 0, max2 = 0;
		// 以字符为对称轴
		for (int i = 1; i < length - 1; i++) {
			len = 0;
			border = i < length / 2 ? i : length - i - 1;
			for (int j = 1; j <= border; j++) {
				if (str.charAt(i - j) == str.charAt(i + j)) {
					len++;
				} else {
					break;
				}
			}
			if (max1 < len) {
				max1 = len;
			}
		}
		// 以空白为对称轴
		for (int i = 1; i < length; i++) {
			len = 0;
			border = i <= length / 2 ? i : length - i;
			for (int j = 1; j <= border; j++) {
				if (str.charAt(i - j) == str.charAt(i + j - 1)) {
					len++;
				} else {
					break;
				}
			}
			if (max2 < len) {
				max2 = len;
			}
		}
		max1 = max1 * 2 + 1;
		max2 = max2 * 2;
		System.out.print(max1 > max2 ? max1 : max2);

	}
}
