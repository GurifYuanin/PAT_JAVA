package ¼×¼¶Ò»ÂÖ;

import java.util.HashMap;
import java.util.Scanner;

public class Q1041_2 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int number = sca.nextInt();
		int[] arr = new int[number];
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		for (int i = 0; i < number; i++) {
			arr[i] = sca.nextInt();
			if (map.containsKey(arr[i])) {
				map.put(arr[i], false);
			} else {
				map.put(arr[i], true);
			}
		}
		sca.close();
		for (int i = 0; i < number; i++) {
			if (map.get(arr[i])) {
				System.out.print(arr[i]);
				return;
			}
		}
		System.out.print("None");
	}
}
