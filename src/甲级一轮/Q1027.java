package 甲级一轮;
import java.util.Scanner;
public class Q1027 {
	public static void main(String[] args) {
		/*
		 * 输入：0~168 0~168 0~168
		 * 输出：#十三进制下对应的数字
		 * */
		Scanner sca = new Scanner(System.in);
		int r = sca.nextInt();
		int g = sca.nextInt();
		int b = sca.nextInt();
		sca.close();
		System.out.print("#");
		System.out.print(toMars(r));
		System.out.print(toMars(g));
		System.out.print(toMars(b));
	}
	static String toMars(int number) {
		String result = "";
		for(int i = 0; i < 2; i++) {
			int j = number % 13;
			if (j < 10) {
				result = j + result;
			} else {
				switch (j) {
				case 10: result = "A" + result;break;
				case 11: result = "B" + result;break;
				case 12: result = "C" + result;break;
				}
			}
			number = number / 13;
		}
		return result;
	}
}
