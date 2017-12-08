package �׼�һ��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Q1047 {
	public static void main(String[] args) throws IOException {
		/*
		 * ���룺ѧ���� �γ���
		 * 			 ѧ����1 ��ע��γ��� �γ̱��1 �γ̱��2...
		 * 			 ...
		 * ������γ̱��1 ǩ��ѧ����
		 * 			 ѧ����1
		 * 			 ...
		 * 			 ...
		 * */
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = null;
		String name = null, tmp = null;
		int stuNum, couNum, regNum, couId;
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		arr = buf.readLine().split(" ");
		stuNum = Integer.parseInt(arr[0]);
		couNum = Integer.parseInt(arr[1]);
		for (int i = 1; i <= couNum; i++) {
			map.put(i, "");
		}
		for (int i = 0; i < stuNum; i++) {
			arr = buf.readLine().split(" ");
			name = arr[0];
			regNum = Integer.parseInt(arr[1]) + 2;
			for (int j = 2; j < regNum; j++) {
				couId = Integer.parseInt(arr[j]);
				map.put(couId, map.get(couId) + " " + name);
			}
		}
		buf.close();
		for (int i = 1; i <= couNum; i++) {
			tmp = map.get(i).trim();
			if (!tmp.equals("")) {
				arr = tmp.split(" ");
				Arrays.sort(arr);
				regNum = arr.length;
				System.out.println(i + " " + regNum);
				for (int j = 0; j < regNum; j++) {
					System.out.println(arr[j]);
				}
			}
		}
	}
}