package 甲级一轮;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1048 {
	public static void main(String[] args) throws IOException {
		/*
		 * 输入：硬币数 总金额
		 * 			 硬币值1 硬币值2...
		 * 输出：硬币值1 硬币值2
		 * */
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int coinNum = 0, money = 0, half = 0;
		String[] arr = null;
		int[] coin = null;
		arr = buf.readLine().split(" ");
		coinNum = Integer.parseInt(arr[0]);
		if (coinNum == 0) {
			System.out.print("No Solution");
			return;
		}
		money = Integer.parseInt(arr[1]);
		coin = new int[coinNum];
		arr = buf.readLine().split(" ");
		for (int i = 0; i < coinNum; i++) {
			coin[i] = Integer.parseInt(arr[i]);
		}
		buf.close();
		
		Arrays.sort(coin);
		half = money - coin[0];
		int low = 0, high = coinNum - 1, sum = 0;
		for (int i = coinNum - 1; i > 0; i--) {
			if (half >= coin[i]) {
				high = i;
				break;
			}
		}
		while (low < high) {
			sum = coin[low] + coin[high];
			if (sum == money) {
				System.out.print(coin[low] + " " + coin[high]);
				return;
			} else {
				if (sum > money) {
					high--;
				} else {
					low++;
				}
			}
		}
		System.out.print("No Solution");
	}
}
