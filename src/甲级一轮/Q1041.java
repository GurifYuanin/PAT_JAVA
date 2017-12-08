package ¼×¼¶Ò»ÂÖ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Q1041 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		buf.close();
		int number = Integer.parseInt(arr[0]) + 1;
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		int key = 0;
		for (int i = 1; i < number; i++) {
			key = Integer.parseInt(arr[i]);
			if (map.containsKey(key)) {
				map.put(key, false);
			} else {
				map.put(key, true);
			}
		}
		for (int i = 1; i < number; i++) {
			key = Integer.parseInt(arr[i]);
			if (map.get(key)) {
				System.out.print(key);
				return;
			}
		}
		System.out.print("None");
	}
}
