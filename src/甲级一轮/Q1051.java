package ¼×¼¶Ò»ÂÖ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1051 {
	public static void main(String[] args) throws IOException {
		int stackSize, length, lineNumber, min, max, elementNumber;
		boolean flag;
		String[] arr;
		int[] line;
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		arr = buf.readLine().split(" ");
		stackSize = Integer.parseInt(arr[0]);
		length = Integer.parseInt(arr[1]);
		lineNumber = Integer.parseInt(arr[2]);
		line = new int[length];
		for (int i = 0; i < lineNumber; i++) {
			flag = true;
			arr = buf.readLine().split(" ");
			for (int j = 0; j < length; j++) {
				line[j] = Integer.parseInt(arr[j]);
			}
			min = max = elementNumber = line[0];
			for (int j = 1; j < lineNumber; j++) {
				if (elementNumber <= stackSize) {
					if (line[j] == (min - 1)) {
						elementNumber--;
						min = line[j];
					} else {
						if (line[j] == (max + 1)) {
							max = line[j];
						} else {
							elementNumber += (line[j] - max);
						}
					}
				} else {
					flag = false;
					break;
				}
			}
			if (flag) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		buf.close();
	}
}
