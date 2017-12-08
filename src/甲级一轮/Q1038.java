package ¼×¼¶Ò»ÂÖ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1038 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		buf.close();
		
		int num = Integer.parseInt(arr[0]);
		arr = Arrays.copyOfRange(arr, 1, arr.length);
		Arrays.sort(arr);
		for (int i = 0; i < num; i++) {
			arr[i] = String.valueOf(Integer.parseInt(arr[i]));
		}
		String s1, s2;
		boolean flag;
		int min = 0;
		for (int i = 0; i < num - 1; i++) {
			for (int j = i; j < num - 1; j++) {
				flag = true;
				s1 = arr[j];
				s2 = arr[j + 1];
				min = s1.length() > s2.length() ? s2.length() :s1.length();
				for (int k = 0; k < min; k++) {
					if (s1.charAt(k) != s2.charAt(k)) {
						flag = false;
						break;
					}
				}
				if (flag) {
					if (s1.length() > s2.length()) {
						if (s1.charAt(s2.length()) > s2.charAt(0)) {
							arr[j] = s2;
							arr[j + 1] = s1;
						}
					} else {
						if (s2.charAt(s1.length()) < s1.charAt(0)) {
							arr[j] = s2;
							arr[j + 1] = s1;
						}
					}
				}
			}
		}
		System.out.print(arrToString(arr));
	}
	static String arrToString(String[] arr) {
		String result = "";
		int length = arr.length;
		for (int i = 0; i < length; i++) {
			result += arr[i];
		}
		return result;
	}
}
