package ¼×¼¶Ò»ÂÖ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
public class Que1001 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Character> list = new LinkedList<Character>();
		String inpStr = in.readLine();
		in.close();
		String[] arr = inpStr.split(" ");
		int outNum = Integer.valueOf(arr[0]) + Integer.valueOf(arr[1]);
		String outStr = String.valueOf(outNum);
		if (outNum < 0) {
			System.out.print("-");
			outStr = outStr.substring(1, outStr.length());
		}
		int len = outStr.length();
		for (int i = 1, j = 0; i <= len; i++, j++) {
			if (i % 4 == 0) {
				list.add(',');
				len++;
				j--;
			} else {
				list.add(outStr.charAt(outStr.length() - j - 1));
			}
		}
		Character[] cha = new Character[len];
		for (int i = 0; i < len; i++) {
			cha[len - i - 1] = list.remove();
		}
		for(Character c: cha) {
			System.out.print(c);
		}
	}
}
