package ¼×¼¶¶þÂÖ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1055 {
	public static void main(String[] args) throws IOException {
		int peopleNum, checkNum;
		String[] arr;
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		arr = buf.readLine().split(" ");
		peopleNum = Integer.parseInt(arr[0]);
		checkNum = Integer.parseInt(arr[1]) + 1;
		Famous[] people = new Famous[peopleNum];
		for (int i = 0; i < peopleNum; i++) {
			arr = buf.readLine().split(" ");
			people[i] = new Famous(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
		}
		
		//sort
		Famous tmp = null;
		int m1, m2;
		for (int i = 1; i < peopleNum; i++) {
			for (int j = 0; j < peopleNum - i; j++) {
				m1 = people[j].money;
				m2 = people[j + 1].money;
				if (m1 < m2 || (m1 == m2 && people[j].age > people[j + 1].age) || (m1 == m2 && people[j].age == people[j + 1].age && people[j].name.compareTo(people[j + 1].name) > 0)) {
					tmp = people[j];
					people[j] = people[j + 1];
					people[j + 1] = tmp;
				}
			}
		}
		int count, min, max;
		boolean flag;
		for (int i = 1; i < checkNum; i++) {
			flag = true;
			arr = buf.readLine().split(" ");
			System.out.println("Case #" + i + ":");
			count = Integer.parseInt(arr[0]);
			min = Integer.parseInt(arr[1]);
			max = Integer.parseInt(arr[2]);
			for (int j = 0; j < peopleNum && count > 0; j++) {
				if (people[j].age >= min && people[j].age <= max) {
					System.out.println(people[j].name + " " + people[j].age + " " + people[j].money);
					count--;
					flag = false;
				}
			}
			if (flag) {
				System.out.println("None");
			}
		}
		buf.close();
	}
}
class Famous {
	String name;
	int age;
	int money;
	Famous(String n, int a, int m) {
		name = n;
		age = a;
		money = m;
	}
}
