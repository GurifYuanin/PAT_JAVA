package ¼×¼¶¶þÂÖ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1037 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int len1 = Integer.parseInt(buf.readLine());
		int[] a1 = new int[len1];
		String[] arr = buf.readLine().split(" ");
		for (int i = 0; i < len1; i++) {
			a1[i] = Integer.parseInt(arr[i]);
		}
		int len2 = Integer.parseInt(buf.readLine());
		int a2[] = new int[len2];
		arr = buf.readLine().split(" ");
		for (int i = 0; i < len2; i++) {
			a2[i] = Integer.parseInt(arr[i]);
		}
		buf.close();
		
		int sum = 0, index1, index2, border;
		Arrays.sort(a1);
		Arrays.sort(a2);
		for (index1 = 0; index1 < len1 && a1[index1] < 0; index1++);
		for (index2 = 0; index2 < len2 && a2[index2] < 0; index2++);
		border = Math.min(index1, index2);
		for (int i = 0; i < border; i++) {
			sum += a1[i] * a2[i];
		}
		border = Math.min(len1 - index1, len2 - index2);
		for (int i = len1 - 1, j = len2 - 1, k = 0; k < border; k++) {
			sum += a1[i - k] * a2[j - k];
		}
		System.out.print(sum);
	}
}
