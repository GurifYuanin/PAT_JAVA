package ¼×¼¶¶þÂÖ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Q1028 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		int row = Integer.parseInt(arr[0]);
		int col = Integer.parseInt(arr[1]);
		Line[] list = new Line[row];
		for (int i = 0; i < row; i++) {
			arr = buf.readLine().split(" ");
			list[i] = new Line(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2]));
		}
		buf.close();
		
		switch (col) {
		case 1: {
			Arrays.sort(list, new Comparator<Line>(){
				public int compare(Line a, Line b) {
					return a.id - b.id;
				}
			});
			break;
		}
		case 2: {
			Arrays.sort(list, new Comparator<Line>(){
				public int compare(Line a, Line b) {
					int tmp = a.name.compareTo(b.name);
					if (tmp > 0 || (tmp == 0 && a.id > b.id)) {
						return 1;
					} else {
						return -1;
					}
				}
			});
			break;
		}
		case 3: {
			Arrays.sort(list, new Comparator<Line>(){
				public int compare(Line a, Line b) {
					if (a.age > b.age || (a.age == b.age &&  a.id > b.id)) {
						return 1;
					} else {
						return -1;
					}
				}
			});
		}
		}
		for (int i = 0; i < row; i++) {
			System.out.printf("%06d %s %s\n", list[i].id, list[i].name, list[i].age);
		}
	}
}
class Line{
	int id;
	String name;
	int age;
	Line(int i, String n, int a) {
		id = i;
		name = n;
		age = a;
	}
}
