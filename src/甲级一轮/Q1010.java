package 甲级一轮;
import java.util.Scanner;
public class Q1010 {
	public static void main(String[] args) {
		/*
		 * 输入： 数字1 数字2 标志（1或2） 基数1
		 * 输出： 使得｛基数1的数字[标志] <=> 基数2的另一个数字｝的基数2
		 * */
		Scanner sca = new Scanner(System.in);
		String inpStr = sca.nextLine();
		sca.close();
		String[] inpArr = inpStr.split(" ");
		int flagA = Integer.parseInt(inpArr[2]) - 1;
		int flagB;
		int rad = Integer.parseInt(inpArr[3]);
		String aimStr = inpArr[flagA];
		String resStr;
		if (inpArr[0].equals("0") || rad ==0) {
			System.out.print(0);
		} else {
			int aimDec = 0;
			if (rad == 1) {
				for (int i = 0; i < aimStr.length(); i++) {
					aimDec += Integer.parseInt(String.valueOf(aimStr.charAt(i)));
				}
			} else {
				aimDec = Integer.parseInt(aimStr, rad);
			}
			int resDec = 0;
			if (flagA == 0) {
				flagB = 1;
			} else {
				flagB = 0;
			}
			resStr = inpArr[flagB];
			char ch = resStr.charAt(0);
			for (int i = 1; i < resStr.length(); i++) {
				if (ch < resStr.charAt(i)) {
					ch = resStr.charAt(i);
				}
			}
			for (int j = 0; j < resStr.length(); j++) {
				resDec += Integer.parseInt(String.valueOf(resStr.charAt(j)));
			}
			int i = 0;
			if (ch > 96) {
				i = ch - 86;
			} else {
				i = ch - 47;
			}
			if (i == 1) {
				for (int j = 0; j < resStr.length(); j++) {
					resDec += Integer.parseInt(String.valueOf(resStr.charAt(j)));
				}
			} else {
				do {
					resDec = Integer.parseInt(resStr, i);
					i++;
				} while(resDec < aimDec);
			}
			if (resDec == aimDec) {
				System.out.print(--i);
			} else {
				System.out.print("Impossible");
			}
		}
	}
}
