package ¼×¼¶¶þÂÖ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1009_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		int count = Integer.parseInt(arr[0]);
		int index = 0;
		float value = 0;
		float[] coe = new float[1001];
		float[] res = new float[1000001];
		Arrays.fill(coe, 0);
		Arrays.fill(res, 0);
		for (int i = 0, j = 1; i < count; i++) {
			index = Integer.parseInt(arr[j++]);
			value = Float.parseFloat(arr[j++]);
			coe[index] = value;
		}
		arr = buf.readLine().split(" ");
		buf.close();
		count = Integer.parseInt(arr[0]);
		for (int i = 0, j = 1; i < count; i++) {
			index = Integer.parseInt(arr[j++]);
			value = Float.parseFloat(arr[j++]);
			for (int k = 0; k <= 1000; k++) {
				if (coe[k] != 0) {
					res[k + index] += coe[k] * value;
				}
			}
		}
		count = 0;
		String result = "";
		for (int i = 1000000; i >= 0; i--) {
			if (res[i] != 0) {
				count++;
				result += String.format("%d %.1f ", i, res[i]);
			}
		}
		System.out.print(count + " " + result.trim());
	}
}
