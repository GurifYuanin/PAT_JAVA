package ¼×¼¶Ò»ÂÖ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1049 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));	
		int number = Integer.parseInt(buf.readLine());
		buf.close();
		int sum = 0, fund = 0, mul = 1;
		String subNumber = String.valueOf(number);
		if (subNumber.length() > 1) {
			int num = Integer.parseInt(subNumber.substring(1, subNumber.length()));
			int time = subNumber.charAt(1) - 48;
			for (; num != 0; num /= 10) {
				fund  = fund * 9 + mul;
				mul *= 10;
				sum += fund;
			}
			fund = (fund - mul) / 9;
			sum += fund * time + 1;
			if (subNumber.charAt(0) > 49) {
				sum += mul;
			}
			fund = 0;
			mul = 1;
			number /= 10;
		}
		for ( ;number != 0; number /= 10) {
			fund  = fund * 9 + mul;
			mul *= 10;
			sum += fund;
		}
		System.out.print(sum);
	}
}
