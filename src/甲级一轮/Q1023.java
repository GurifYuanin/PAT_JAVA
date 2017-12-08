package 甲级一轮;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1023 {
	public static void main(String[] args) throws IOException {
		/*
		 * 输入：长度小于20的数
		 * 输出：Yes/No
		 * 			 数乘以2的结果
		 * */
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String number =buf.readLine();
		buf.close();

		if (isFunNumber(number)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		System.out.print(dbNumber(number));
	}
	static boolean isFunNumber(String number) {
		boolean result = true;
		char[] numArr = number.toCharArray();
		if (Integer.parseInt(String.valueOf(numArr[0])) >= 5) {
			result = false;
		} else {
			int len = number.length();
			String db = dbNumber(number);
			char[] dbArr = db.toCharArray();
			for (int i = 0; i < len; i++) {
				boolean flag = true;
				for (int j = 0; j < len; j++) {
					if (numArr[i] == dbArr[j]) {
						flag = false;
						dbArr[j] = '\0';
						break;
					}
				}
				if (flag) {
					result = false;
					break;
				}
			}
		}
		return result;
	}
	static String dbNumber(String number) {
		String result = "";
		int len = number.length();
		char[] numArr = number.toCharArray();
		int is = 0;
		for (int i = len - 1; i >= 0; i--) {
			int n = (numArr[i] - 48) * 2;
			result = (n % 10 + is) + result;
			if (n >= 10) {
				is = 1;
			} else {
				is = 0;
			}
		}
		if (is == 1) {
			result = is + result;
		}
		return result;
	}
}
