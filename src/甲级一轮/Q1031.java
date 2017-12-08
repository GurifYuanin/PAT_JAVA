package 甲级一轮;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1031 {
	public static void main(String[] args) throws IOException {
		/*
		 * 输入：[5, 80]长度的字符串
		 * 输出：拆分成单个字符呈U形输出
		 * */
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String str = buf.readLine();
		buf.close();
		int n = str.length() + 2;
		int height = n / 3;
		int width = height + (n % 3);
		int len = str.length();
		int index = 0;
		for (int i = 0; i < height - 1; i++, index++) {
			System.out.print(str.charAt(index));
			for (int j = 0; j < width - 2; j++) {
				System.out.print(" ");
			}
			System.out.println(str.charAt(len - index - 1));
		}
		for (int i = 0; i < width; i++, index++) {
			System.out.print(str.charAt(index));
		}
		
	}
}
