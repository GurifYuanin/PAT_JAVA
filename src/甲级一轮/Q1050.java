package ¼×¼¶Ò»ÂÖ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1050 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(buf.readLine().replaceAll("[" + buf.readLine() + "]", ""));
	}
}