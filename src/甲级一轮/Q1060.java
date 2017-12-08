package ¼×¼¶Ò»ÂÖ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1060 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		buf.close();
		
		int sig = Integer.parseInt(arr[0]);
		int start = 0;
		int length1 = arr[1].length(), length2 = arr[2].length();
		String str1, str2;
		start = findStart(length1, arr[1]);
		str1 = arr[1].substring(start, start + Math.min(sig, length1 - start));
		for (int i = sig - str1.length(); i > 0; i--) {
			str1 += 0;
		}
		start = findStart(length2, arr[2]);
		str2 = arr[2].substring(start, start + Math.min(sig, length2 - start));
		for (int i = sig - str2.length(); i > 0; i--) {
			str2 += 0;
		}
		if (str1.equals(str2)) {
			System.out.print("YES 0." + str1 + "*10^");
			judge(length1, arr[1]);
		} else {
			System.out.print("NO 0." + str1 + "*10^");
			judge(length1, arr[1]);
			System.out.print(" 0." + str2 + "*10^");
			judge(length2, arr[2]);
		}
	}
	static int findStart(int length, String target) {
		int result = 0;
		for (int i = 0; i < length; i++) {
			if (target.charAt(i) != '0' && target.charAt(i) != '.') {
				result = i;
				break;
			}
		}
		return result;
	}
	static void judge(int length, String target) {
		int mul = target.indexOf('.');
		if (mul == -1) {
			System.out.print(length);
		} else {
			System.out.print(mul);
		}
	}
}
