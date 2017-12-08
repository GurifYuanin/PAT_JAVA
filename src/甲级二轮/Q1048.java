package ¼×¼¶¶þÂÖ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1048 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		int count = Integer.parseInt(arr[0]);
		int all = Integer.parseInt(arr[1]);
		arr = buf.readLine().split(" ");
		buf.close();
		
		int[] num = new int[count];
		for (int i = 0; i < count; i++) {
			num[i] = Integer.parseInt(arr[i]);
		}
		Arrays.sort(num);
		int sum;
		for (int i = 0; i < count; i++) {
			sum = num[i];
			for (int j = count - 1; j > i && sum + num[j] >= all; j--) {
				if (sum + num[j] == all) {
					System.out.print(num[i] + " " + num[j]);
					return;
				}
			}
		}
		System.out.print("No Solution");
	}
	
}
