package 甲级一轮;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class Q1036 {
	public static void main(String[] args) throws IOException {
		/*
		 * 输入：行数
		 * 			 名字 F/M 课程号 分数
		 * 			 ...
		 * 输出：女生姓名 课程号
		 * 			 男生姓名 课程号
		 * 			 分差
		 * */
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int lineNum = Integer.parseInt(buf.readLine());
		LinkedList<String> male = new LinkedList<String>();
		LinkedList<String> female = new LinkedList<String>();
		String[] arr = null;
		for (int i = 0; i < lineNum; i++) {
			arr = buf.readLine().split(" ");
			if (arr[3].equals("100"))
				arr[3] = "a";
			if (arr[1].equals("M")) {
				male.add(arr[3] + " " + arr[0] + " " + arr[2]);
			} else {
				female.add(arr[3] + " " + arr[0] + " " + arr[2]);
			}
		}
		buf.close();
		int a = 0, b = 0;
		if (female.size() == 0) {
			System.out.println("Absent");
		} else {
			Collections.sort(female);
			arr = female.get(female.size() - 1).split(" ");
			if (arr[0].equals("a")) {
				a = 100;
			} else {
				a = Integer.parseInt(arr[0]);
			}
			System.out.println(arr[1] + " " + arr[2]);
		}
		if (male.size() == 0) {
			System.out.println("Absent");
		} else {
			Collections.sort(male);
			arr = male.get(0).split(" ");
			if (arr[0].equals("a")) {
				b = 100;
			} else {
				b = Integer.parseInt(arr[0]);
			}
			System.out.println(arr[1] + " " + arr[2]);	
		}
		if (female.size() != 0 && male.size() != 0) {
			System.out.print(a - b);
		} else  {
			System.out.print("NA");
		}
	}
}