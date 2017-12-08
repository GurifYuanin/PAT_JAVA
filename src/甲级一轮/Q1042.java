package ¼×¼¶Ò»ÂÖ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1042 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int time = Integer.parseInt(buf.readLine());
		String[] strArr = buf.readLine().split(" ");
		int[] arr = new int[54];
		for (int i = 0; i < 54; i++) {
			arr[i] = Integer.parseInt(strArr[i]) - 1;
		}
		strArr = null;
		buf.close();
		
		String[][] card = {
				{"S1", "S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "S10", "S11", "S12", "S13", "H1", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10", "H11", "H12", "H13", "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "C11", "C12", "C13", "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10", "D11", "D12", "D13","J1", "J2"},
				{"S1", "S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "S10", "S11", "S12", "S13", "H1", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10", "H11", "H12", "H13", "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "C11", "C12", "C13", "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10", "D11", "D12", "D13","J1", "J2"}
				};
		int flag = 0;
		int o1 = 0, o2 = 0;
		for (int i = 0; i < time; i++, flag++) {
			if (flag % 2 == 0) {
				o1 = 1;
				o2 = 0;
			} else {
				o2 = 1;
				o1 = 0;
			}
			for (int j = 0; j < 54; j++) {
				card[o1][arr[j]] = card[o2][j];
			}
		}
		for (int i = 0; i < 53; i++) {
			System.out.print(card[time % 2][i] + " ");
		}
		System.out.print(card[time % 2][53]);
	}
}
