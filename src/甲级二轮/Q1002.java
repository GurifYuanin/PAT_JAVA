package ¼×¼¶¶þÂÖ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1002 {
	public static void main(String[] args) {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr1 = null, arr2 = null;
		String str = "";
		int length = 0, len1, len2, exp, i, j;
		float[]  term = null;
		float coe;
		try {
			arr1 = buf.readLine().split(" ");
			arr2 = buf.readLine().split(" ");
			buf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		len1 = Integer.parseInt(arr1[0]);
		len2 = Integer.parseInt(arr2[0]);
		term = new float[1001];
		Arrays.fill(term, 0);
		for (i = 0, j = 1; i < len1; i++) {
			exp = Integer.parseInt(arr1[j++]);
			coe = Float.parseFloat(arr1[j++]);
			term[exp] += coe;
		}
		for (i = 0, j = 1; i < len2; i++) {
			exp = Integer.parseInt(arr2[j++]);
			coe = Float.parseFloat(arr2[j++]);
			term[exp] += coe;
		}
		for (i = 1000; i >= 0; i--) {
			if (term[i] != 0) {
				length++;
				str += i + " " + String.format("%.1f", term[i]) + " ";
			}
		}
		System.out.print((length + " " + str.trim()).trim());
	}
}
