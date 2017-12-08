package ¼×¼¶Ò»ÂÖ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1058 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = buf.readLine().split(" ");
		buf.close();
		
		String[] arr1 = tmp[0].split("\\.");
		String[] arr2 = tmp[1].split("\\.");
		int k =  Integer.parseInt(arr1[2]) +  Integer.parseInt(arr2[2]);
		int s = Integer.parseInt(arr1[1]) + Integer.parseInt(arr2[1]);
		int g = Integer.parseInt(arr1[0]) + Integer.parseInt(arr2[0]);
		if (k >= 29) {
			k %= 29;
			s++;
		}
		if(s >= 17) {
			s %= 17;
			g++;
		}
		System.out.print(g + "." + s + "." + k);
	}
}
