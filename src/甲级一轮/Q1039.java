package �׼�һ��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Q1039 {
	public static void main(String[] args) throws IOException {
		/*
		 * ���룺ѧ���� �γ���
		 * 			 �γ̱�� ǩ��ѧ����
		 * 			 ѧ����1 ѧ����2 ...
		 * 			 ...
		 * 			 ����ѧ����
		 * �����ѧ����1 ǩ������ �γ̱��1 �γ̱��2...
		 * 			 ...
		 * */
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		int studentNum = Integer.parseInt(arr[0]);
		int courseNum = Integer.parseInt(arr[1]);
		Course[] course = new Course[courseNum];
		for (int i = 0; i < courseNum; i++) {
			course[i] = new Course();
			course[i].id = Integer.parseInt(buf.readLine().split(" ")[0]);
			course[i].singUp = buf.readLine().split(" ");
		}
		arr = buf.readLine().split(" ");
		buf.close();
		
		for (int i = 0; i < courseNum - 1; i++) {
			if (course[i].id > course[i + 1].id) {
				Course tmp = course[i];
				course[i] = course[i + 1];
				course[i + 1] = tmp;
			}
		}
		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < studentNum; i++) {
			map.put(arr[i], "");
		}
		for (int i = 0; i < courseNum; i++) {
			String str = null;
			int len = course[i].singUp.length;
			for (int j = 0; j < len; j++) {
				str = course[i].singUp[j];
				map.put(str, map.get(str) + " " + course[i].id);
			}
		}
		for (int i = 0; i < studentNum; i++) {
			System.out.print(arr[i] + " ");
			System.out.print(map.get(arr[i]).split(" ").length - 1);
			System.out.println(map.get(arr[i]));
		}
	}
}
class Course {
	int id;
	String[] singUp;
}
