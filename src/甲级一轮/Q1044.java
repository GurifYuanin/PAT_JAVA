package 甲级一轮;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1044 {
	public static void main(String[] args) throws IOException {
		/*
		 * 输入：钻石个数 应付金额
		 * 			 钻石价值1 ...
		 * 输出：a-b
		 * 			 ...
		 * */
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		int number = Integer.parseInt(arr[0]);
		int payment = Integer.parseInt(arr[1]);
		arr = buf.readLine().split(" ");
		buf.close();
		int[] money = new int[number];
		for (int i = 0; i < number; i++) {
			money[i] = Integer.parseInt(arr[i]);
		}
		arr = null;
		
		int sum;
		boolean flag = true;
		for (int i = 0; i < number; i++) {
			sum = 0;
			for (int j = i; j < number; j++) {
				sum += money[j];
				if (sum == payment) {
					flag = false;
					System.out.println((i + 1) + "-" + (j + 1));
					break;
				}
			}
		}
		if (flag) {
			for (int i = 0; i < number; i++) {
				sum = 0;
				for (int j = i; j < number; j++) {
					sum += money[j];
					if (sum > payment && (sum - money[i] < payment)) {
						System.out.println((i + 1) + "-" + (j + 1));
						break;
					}
				}
			}
		}
	}
}
