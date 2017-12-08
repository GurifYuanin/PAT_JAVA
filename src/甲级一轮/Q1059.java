package ¼×¼¶Ò»ÂÖ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

public class Q1059 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(buf.readLine());
		buf.close();
		
		if (number == 1) {
			System.out.print("1=1");
		} else {
			System.out.print(number + "=");
			LinkedList<Integer> list = new LinkedList<Integer>();
			int time = 1, pre = 0, next = 0;
			for (int i = 2; number > 1;) {
				if (number % i == 0) {
					number /= i;
					list.add(i);
				} else {
					i++;
				}
			}
			Iterator<Integer> ite = list.iterator();
			
			if (ite.hasNext()) {
				pre = ite.next();
			}
			while (ite.hasNext()) {
				next = ite.next();
				if (pre != next) {
					opt(pre, time);
					time = 1;
				} else {
					time++;
				}
				pre = next;
			}
			if (time > 1) {
				System.out.print(pre + "^" + time);
			} else {
				System.out.print(pre);
			}
		}
	}
	static void opt(int num, int time) {
		if (time > 1) {
			System.out.print(num + "^" + time + "*");
		} else {
			System.out.print(num + "*");
		}
	}
}
