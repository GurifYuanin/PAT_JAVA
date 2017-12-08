package ¼×¼¶¶þÂÖ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Q1038 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] ele = buf.readLine().split(" ");
		buf.close();
		int num = Integer.parseInt(ele[0]), i;
		ele = Arrays.copyOfRange(ele, 1, num + 1);
		Arrays.sort(ele, new Comparator<String>() {
			public int compare(String a, String b) {
				return (a + b).compareTo(b + a);
			}
		});
		for (i = 0; i < num && Integer.parseInt(ele[i]) == 0; i++);
		if (i == num) {
			System.out.print(0);
		} else {
			System.out.print(Integer.parseInt(ele[i]));
			for (int j = i + 1; j < num; j++) {
				System.out.print(ele[j]);
			}
		}
	}
}
