package �׼�һ��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1006 {
	public static void main(String[] args) throws IOException {
		/*
		 * ���룺��¼����
		 * 			 ID1 ����ʱ�� ����ʱ��
		 * 			 ID2...
		 * �������һ������ID ���һ������ID
		 */
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int recNum = Integer.valueOf(buf.readLine());
		String[] record = new String[recNum];
		for (int i = 0; i <recNum; i++) {
			record[i] = buf.readLine();
		}
		int firstIndex = 0;
		int lastIndex = 0;
		for (int i = 0; i < recNum; i++) {
			if (record[i].split(" ")[1].compareTo(record[firstIndex].split(" ")[1]) < 0) {
				firstIndex = i;
			}
		}
		for (int i = 0; i < recNum; i++) {
			if (record[i].split(" ")[2].compareTo(record[lastIndex].split(" ")[2]) > 0) {
				lastIndex = i;
			}
		}
		buf.close();
		System.out.print(record[firstIndex].split(" ")[0] + " ");
		System.out.print(record[lastIndex].split(" ")[0]);
	}
}
