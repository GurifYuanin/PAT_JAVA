package 甲级一轮;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.regex.Pattern;

public class Q1035 {
	public static void main(String[] args) throws IOException {
		/*
		 * 输入：行数
		 * 			 用户名 密码
		 * 			 ...
		 * 输出：行数
		 * 			 用户名 改后的密码
		 * 			 ...
		 * */
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(buf.readLine());
		String[] arr = new String[num];
		for (int i = 0; i < num; i++) {
			arr[i] = buf.readLine();
		}
		buf.close();
		
		Pattern p = Pattern.compile("[10lO]");
		LinkedList<String> list = new LinkedList<String>();
		for (int i = 0; i < num; i++) {
			String[] str = arr[i].split(" ");
			if (p.matcher(str[1]).find()) {
				list.add(str[0] + " " + str[1].replace('1', '@').replace('0', '%').replace('l', 'L').replace('O', 'o'));
			}
		}
		if (list.size() == 0) {
			if (num == 1) {
				System.out.print("There is 1 account and no account is modified");
			} else {
				System.out.print("There are " + num + " accounts and no account is modified");
			}
		} else {
			System.out.println(list.size());
			for (String s : list) {
				System.out.println(s);
			}
		}
	}
}
