package ¼×¼¶¶þÂÖ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1049 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String number = buf.readLine();
		int num = Integer.parseInt(number);
		buf.close();
		int length = number.length();
		int sum = 0, base = 1, factor, high, low;
		for (int i = length - 1; i >= 0; i--, base *= 10) {
			factor = number.charAt(i) - 48;
			high = num / (base * 10);
			low = num % base;
			switch (factor) {
			case 0: {
				sum += high * base;
				break;
			}
			case 1: {
				sum += high * base + low + 1;
				break;
			}
			default: {
				sum += (high + 1) * base;
			}
			}
		}
		System.out.print(sum);
	}
}
