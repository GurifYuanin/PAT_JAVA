package 甲级一轮;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1055 {
	public static void main(String[] args) throws IOException {
		/**
		 * 输入：人数 查询数
		 * 			 名字 年龄 财产
		 * 			 ...
		 * 			 输出条数 最小年龄 最大年龄
		 * 			 ...
		 * 输出：case #n:
		 * 			 名字 年龄 财产
		 * 			 ...
		 * */
		String[] arr = null;
		P tmp = null;
		int peoNum, queNum, time, minAge, maxAge;
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		arr = buf.readLine().split(" ");
		peoNum = Integer.parseInt(arr[0]);
		queNum = Integer.parseInt(arr[1]);
		P[] people = new P[peoNum];
		for (int i = 0; i < peoNum; i++) {
			arr = buf.readLine().split(" ");
			people[i] = new P(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
		}
		// sort
		for (int i = peoNum - 1; i > 0; i--) {
			for (int j = peoNum - 1; j >= peoNum - i; j--) {
				if (people[j].money  > people[j - 1].money || (people[j].money  == people[j - 1].money && people[j].name.compareTo(people[j - 1].name) < 0)) {
					tmp = people[j];
					people[j] = people[j - 1];
					people[j - 1] = tmp;
				}
			}
		}
		for (int i = 1; i <= queNum; i++) {
			arr = buf.readLine().split(" ");
			time = Integer.parseInt(arr[0]);
			minAge = Integer.parseInt(arr[1]);
			maxAge = Integer.parseInt(arr[2]);
			System.out.println("Case #" + i + ":");
			for (int j = 0; time > 0 && j < peoNum; j++) {
				if (people[j].age >= minAge && people[j].age <= maxAge) {
					System.out.println(people[j].name + " " + people[j].age + " " + people[j].money);
					time--;
				}
			}
			if (time ==  Integer.parseInt(arr[0])) {
				System.out.println("None");
			}
		}
		buf.close();
	}
}
class P {
	String name;
	int age;
	int money;
	P(String name, int age, int money) {
		this.name = name;
		this.age = age;
		this.money = money;
	}
}
