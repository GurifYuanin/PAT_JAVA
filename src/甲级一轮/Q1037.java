package 甲级一轮;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Q1037 {
	public static void main(String[] args) throws IOException{
		/*
		 * 输入：A乘数数量
		 * 			 a1 a2...
		 * 			 B乘数数量
		 * 			 b1 b2...
		 * */
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> m = new LinkedList<Integer>();
		LinkedList<Integer> n = new LinkedList<Integer>();
		int num1 = Integer.parseInt(buf.readLine());
		String[] arr = buf.readLine().split(" ");
		for (int i = 0; i < num1; i++) {
			m.add(Integer.parseInt(arr[i]));
		}
		int num2 = Integer.parseInt(buf.readLine());
		arr = buf.readLine().split(" ");
		for (int i = 0; i < num2; i++) {
			n.add(Integer.parseInt(arr[i]));
		}
		buf.close();
		Collections.sort(m);
		Collections.sort(n);
		int sum = 0;
		int a = 0, b = 0;
		while (m.size() != 0 && n.size() != 0) {
			a = m.removeFirst();
			b = n.removeFirst();
			if (a < 0 && b < 0) {
				sum += a * b;
			} else {
				break;
			}
		}
		Collections.sort(m, new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return 1;
			}
		});
		Collections.sort(n, new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return 1;
			}
		});
		while (m.size() != 0 && n.size() != 0) {
			a = m.removeFirst();
			b = n.removeFirst();
			if (a > 0 && b > 0) {
				sum += a * b;
			} else {
				break;
			}
		}
		System.out.print(sum);
	}
}
