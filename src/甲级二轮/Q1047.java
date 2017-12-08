package ¼×¼¶¶þÂÖ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Q1047 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		int stuNum = Integer.parseInt(arr[0]);
		int couNum = Integer.parseInt(arr[1]);
		Course[] course = new Course[couNum];
		for (int i = 0; i < couNum; i++) {
			course[i] = new Course();
		}
		for (int i = 0; i < stuNum; i++) {
			arr = buf.readLine().split(" ");
			for (int j = Integer.parseInt(arr[1]), index = 2; j > 0; j--, index++) {
				course[Integer.parseInt(arr[index]) - 1].list.add(arr[0]);
			}
		}
		buf.close();
		
		for (int i = 0; i < couNum; i++) {
			Collections.sort(course[i].list);
			System.out.println((i + 1) + " " + course[i].list.size());
			Iterator<String> ite = course[i].list.iterator();
			while (ite.hasNext()) {
				System.out.println(ite.next());
			}
		}
	}
}
class Course{
	LinkedList<String> list = new LinkedList<String>();
}
