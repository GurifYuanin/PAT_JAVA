package 甲级一轮;
import java.util.LinkedList;
import java.util.Scanner;
public class Q1019 {
	public static void main(String[] args) {
		/*
		 * 输入：十进制的数 目标基数
		 * 输出：Yes/No
		 * 			 目标基数的数（数字中间用空格隔开）
		 * */
		Scanner sca = new Scanner(System.in);
		int source = sca.nextInt();
		int radix = sca.nextInt();
		sca.close();
		LinkedList<Integer> list = transfer(source, radix);
		if (isPalindromic(list)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		for (int i = list.size() - 1; i > 0; i--) {
			System.out.print(list.get(i) + " ");
		}
		System.out.print(list.get(0));
	}
	static LinkedList<Integer> transfer(int source, int radix) {
		LinkedList<Integer> result = new LinkedList<Integer>();
		do{
			result.add(source % radix);
			source /= radix;
		} while (source != 0);
		return result;
	}
	static boolean isPalindromic(LinkedList<Integer> source) {
		int len = source.size();
		for (int i = 0; i < len / 2; i++) {
			if (source.get(i) != source.get(len - i - 1)) {
				return false;
			}
		}
		return true;
	}
}
