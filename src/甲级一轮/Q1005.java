package �׼�һ��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1005 {
	public static void main(String[] args) throws IOException {
		// ���룺һ������
		// ����������������ÿλ����ӣ��ٽ���Ӻ��������λ��Ӣ����ĸ���
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String inpStr = buf.readLine();
		buf.close();
		int sum = 0;
		for (int i = 0; i < inpStr.length(); i++) {
			sum += Integer.valueOf(inpStr.substring(i, i + 1));
		}
		String outStr = String.valueOf(sum);
		for (int i = 0; i < outStr.length(); i++) {
			char option = outStr.charAt(i);
			switch (option) {
				case '0': System.out.print("zero");break;
				case '1': System.out.print("one");break;
				case '2': System.out.print("two");break;
				case '3': System.out.print("three");break;
				case '4': System.out.print("four");break;
				case '5': System.out.print("five");break;
				case '6': System.out.print("six");break;
				case '7': System.out.print("seven");break;
				case '8': System.out.print("eight");break;
				case '9': System.out.print("nine");break;
			}
			if (i != outStr.length() - 1) {
				System.out.print(" ");
			}
		}
	}
}
