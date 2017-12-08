package 甲级一轮;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1046 {
	public static void main(String[] args) throws IOException {
		// 一般做法
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		int number = Integer.parseInt(arr[0]);
		int[] dis = new int[number];
		for (int i = 0; i < number; i++) {
			dis[i] = Integer.parseInt(arr[i + 1]);
		}
		int count = Integer.parseInt(buf.readLine());
		int start, end, sum1, sum2, tmp;
		for (int i = 0; i < count; i++) {
			arr = buf.readLine().split(" ");
			start = Integer.parseInt(arr[0]) - 1;
			end = Integer.parseInt(arr[1]) - 1;
			if (start > end) {
				tmp = start;
				start = end;
				end = tmp;
			}
			sum1 = sum2 = 0;
			for (int j = start; j < end; j++) {
				sum1 += dis[j];
			}
			for (int j = 0; j < start; j++) {
				sum2 += dis[j];
			}
			for(int j = end; j < number; j++) {
				sum2 += dis[j];
			}
			System.out.println(sum1 > sum2 ? sum2 : sum1);
		}
		buf.close();
	}
}
