package 甲级一轮;
import java.util.Scanner;
public class Q1024 {
	public static void main(String[] args) {
		/*
		 * 输入：小于10的10次方的数 最多可操作次数
		 * 输出：操作n步后的数
		 * 			 n
		 * */
		Scanner sca = new Scanner(System.in);
		String string = sca.nextLine();
		String number = string.split(" ")[0];
		int max = Integer.parseInt(string.split(" ")[1]);
		sca.close();
		int i = 0;
		while (true) {
			if (i >= max || isPalindromic(number))
				break;
			i++;
			number = operation(number);
		}
		System.out.println(number);
		System.out.print(i);
	}
	static String operation(String number) {
		String result = "";
		StringBuffer str = new StringBuffer(String.valueOf(number));
		str.reverse();
		result = strAdd(number, str.toString());
		return result;
	}
	static boolean isPalindromic(String number) {
		boolean result = true;
		char[] arr = number.toCharArray();
		int len = arr.length;
		for(int i = 0; i < len / 2; i++) {
			if (arr[i] != arr[len - i - 1]) {
				result = false;
				break;
			}
		}
		return result;
	}
	static String strAdd(String s1, String s2) {
		String result = "";
		int len = s1.length();
		int is = 0;
		for (int i = len - 1; i >= 0; i--) {
			int n = s1.charAt(i) + s2.charAt(i) - 96 + is;
			result = (n % 10) + result;
			if (n >= 10) {
				is = 1;
			} else {
				is = 0;
			}			
		}
		if (is == 1) {
			result = is + result;
		}
		return result;
	}
}
