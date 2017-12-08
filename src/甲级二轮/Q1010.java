package ¼×¼¶¶şÂÖ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1010 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		buf.close();
		
		int radix = Integer.parseInt(arr[3]), srcDec, start;
		String src, des;
		if (Integer.parseInt(arr[2]) == 1) {
			src = arr[0];
			des = arr[1];
		} else {
			src = arr[1];
			des = arr[0];
		}
		char max = des.charAt(des.length() - 1);
		for (int i = des.length() - 2; i >= 0 ; i--) {
			if (des.charAt(i) > max) {
				max = des.charAt(i);
			}
		}
		if (max < 58) {
			start = max - 47;
		} else {
			start = max - 86;
		}
		srcDec = toDec(src, radix);
		for (int i = start; i <= srcDec; i++) {
			if (srcDec == toDec(des, i)) {
				System.out.print(i);
				return;
			}
		}
		System.out.print("Impossible");
	}
	static int toDec(String str, int radix) {
		int result = 0;
		for (int i = str.length() - 1, j = 0; i >= 0; i--, j++) {
			result += map(str.charAt(i)) * Math.pow(radix,  j);
		}
		return result;
	}
	static int map(char ch) {
		switch (ch) {
		case '0': return 0;
		case '1': return 1;
		case '2': return 2;
		case '3': return 3;
		case '4': return 4;
		case '5': return 5;
		case '6': return 6;
		case '7': return 7;
		case '8': return 8;
		case '9': return 9;
		case 'a': return 10;
		case 'b': return 11;
		case 'c': return 12;
		case 'd': return 13;
		case 'e': return 14;
		case 'f': return 15;
		case 'g': return 16;
		case 'h': return 17;
		case 'i': return 18;
		case 'j': return 19;
		case 'k': return 20;
		case 'l': return 21;
		case 'm': return 22;
		case 'n': return 23;
		case 'o': return 24;
		case 'p': return 25;
		case 'q': return 26;
		case 'r': return 27;
		case 's': return 28;
		case 't': return 29;
		case 'u': return 30;
		case 'v': return 31;
		case 'w': return 32;
		case 'x': return 33;
		case 'y': return 34;
		case 'z': return 35;
		}
		return -1;
	}
}
